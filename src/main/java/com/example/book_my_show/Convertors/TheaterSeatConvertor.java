package com.example.book_my_show.Convertors;

import com.example.book_my_show.Entities.TheaterSeatEntity;
import com.example.book_my_show.ResponseDtos.TheaterSeatEnityResponseDto;

public class TheaterSeatConvertor {
    public static TheaterSeatEnityResponseDto convertEntityToResponseDto(TheaterSeatEntity theaterSeatEntity){
        return TheaterSeatEnityResponseDto.builder()
                .id(theaterSeatEntity.getId())
                .seatNo(theaterSeatEntity.getSeatNo())
                .seatType(theaterSeatEntity.getSeatType())
                .build();
    }
}
