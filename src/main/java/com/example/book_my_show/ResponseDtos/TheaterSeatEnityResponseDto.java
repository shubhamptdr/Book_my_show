package com.example.book_my_show.ResponseDtos;

import com.example.book_my_show.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeatEnityResponseDto {

    private int id;

    private SeatType seatType;

    private String seatNo;
}
