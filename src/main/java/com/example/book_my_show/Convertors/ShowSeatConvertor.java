package com.example.book_my_show.Convertors;

import com.example.book_my_show.Entities.ShowSeatEntity;
import com.example.book_my_show.ResponseDtos.ShowSeatResponseDto;

public class ShowSeatConvertor {
    public static ShowSeatResponseDto convertEntityToResponseDto(ShowSeatEntity showSeatEntity){
        return ShowSeatResponseDto.builder()
                .seatNo(showSeatEntity.getSeatNo())
                .price(showSeatEntity.getPrice())
                .isBooked(showSeatEntity.isBooked())
                .seatType(showSeatEntity.getSeatType())
                .build();
    }
}
