package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.ShowConvertor;
import com.example.book_my_show.Entities.*;
import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.Enums.SeatType;
import com.example.book_my_show.Repositories.MovieRepository;
import com.example.book_my_show.Repositories.ShowRepository;
import com.example.book_my_show.Repositories.TheaterRepository;
import com.example.book_my_show.ResponseDtos.ShowEntityResponseDto;
import com.example.book_my_show.ResponseDtos.TheaterSeatEnityResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShowService {
    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;
    public String addShow(ShowEntryDto showEntryDto) throws Exception {
        // create sho
        ShowEntity showEntity = ShowConvertor.convertEntryDtoToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theaterId = showEntryDto.getTheaterId();

        // fetch MovieEntity & TheaterEntity
        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();

        if(movieEntity == null || theaterEntity ==null){
            throw  new Exception("Entered wrong parameter");
        }

        //setting attribute of FK
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);


        List<ShowSeatEntity> showSeatEntities   = createShowSeatEntity(showEntryDto,showEntity);
        showEntity.setListOfShowSeats(showSeatEntities);

        //Now we  also need to update the parent entities


       showRepository.save(showEntity);

//        movieEntity.getShowEntityList().add(showEntity);
//        theaterEntity.getShowEntityList().add(showEntity);
//
//
//        movieRepository.save(movieEntity);
//
//        theaterRepository.save(theaterEntity);



        return "The show has been added successfully";
    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto, ShowEntity showEntity) {

        // fetch list of theaterSeats for particular theater;
        List<TheaterSeatEntity> theaterSeatEntityList = showEntity.getTheaterEntity().getTheaterSeatEntityList();

        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();
        for (TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            //setting price here
            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC)){
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());
            }else {
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity);

            showSeatEntityList.add(showSeatEntity);
        }
        return showSeatEntityList;

    }

    public List<ShowEntityResponseDto> getAllShowByTheaterId(int theaterId) {
        List<ShowEntity> showEntityList = theaterRepository.findById(theaterId).get().getShowEntityList();

        List<ShowEntityResponseDto> showEntityResponseDtoList = new ArrayList<>();

        for (ShowEntity showEntity : showEntityList){
            ShowEntityResponseDto showEntityResponseDto = ShowConvertor.convertEntityToResponseDto(showEntity);

            showEntityResponseDtoList.add(showEntityResponseDto);
        }

        return showEntityResponseDtoList;
    }
}
