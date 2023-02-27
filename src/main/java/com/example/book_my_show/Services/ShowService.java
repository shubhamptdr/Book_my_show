package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.ShowConvertor;
import com.example.book_my_show.Entities.*;
import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.Enums.SeatType;
import com.example.book_my_show.Repositories.MovieRepository;
import com.example.book_my_show.Repositories.TheaterRepository;
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
    public String addShow(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowConvertor.convertEntryDtoToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theaterId = showEntryDto.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();

        //setting attribute of FK
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);


        List<ShowSeatEntity> showSeatEntities   = createShowSeatEntity(showEntryDto,showEntity);
        showEntity.setListOfShowSeats(showSeatEntities);

        List<ShowEntity> showEntityList = movieEntity.getShowEntityList();
        showEntityList.add(showEntity);
        movieEntity.setShowEntityList(showEntityList);

        movieRepository.save(movieEntity);

        List<ShowEntity> showEntityList1 = theaterEntity.getShowEntityList();
        showEntityList1.add(showEntity);
        theaterEntity.setShowEntityList(showEntityList1);

        theaterRepository.save(theaterEntity);

        return "The show has been added successfully";
    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto, ShowEntity showEntity) {


        TheaterEntity theaterEntity = showEntity.getTheaterEntity();

        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();

        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();
        for (TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());


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
}
