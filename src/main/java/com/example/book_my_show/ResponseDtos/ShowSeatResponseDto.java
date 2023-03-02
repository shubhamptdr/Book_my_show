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
public class ShowSeatResponseDto {

    private String seatNo;

    private int price;

    private boolean isBooked;

    private SeatType seatType;

}
