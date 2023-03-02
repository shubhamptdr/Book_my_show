package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.TheaterSeatConvertor;
import com.example.book_my_show.Entities.TheaterSeatEntity;
import com.example.book_my_show.Repositories.TheaterRepository;
import com.example.book_my_show.Repositories.TheaterSeatRepository;
import com.example.book_my_show.ResponseDtos.TheaterSeatEnityResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterSeatService {
    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    public List<TheaterSeatEnityResponseDto> getAllTheaterSeatByTheaterId(int theaterId) {
        // fetch list of theaterSeat for given theaterId
        List<TheaterSeatEntity> theaterSeatEntityList = theaterRepository.findById(theaterId).get().getTheaterSeatEntityList();
        List<TheaterSeatEnityResponseDto> theaterSeatEnityResponseDtoList = new ArrayList<>();

        for (TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){
            TheaterSeatEnityResponseDto theaterSeatEnityResponseDto = TheaterSeatConvertor.convertEntityToResponseDto(theaterSeatEntity);

            theaterSeatEnityResponseDtoList.add(theaterSeatEnityResponseDto);
        }

        return theaterSeatEnityResponseDtoList;
    }

    public TheaterSeatEnityResponseDto getTheaterSeatById(int theaterSeatId) throws Exception {
        //fetch theaterSeatEntity by given theaterSeatId
        TheaterSeatEntity theaterSeatEntity = theaterSeatRepository.findById(theaterSeatId).get();

        if(theaterSeatEntity == null){
            throw new Exception("Entered wrong theaterSeatId");
        }

        TheaterSeatEnityResponseDto theaterSeatEnityResponseDto = TheaterSeatConvertor.convertEntityToResponseDto(theaterSeatEntity);

        return theaterSeatEnityResponseDto;
    }
}
