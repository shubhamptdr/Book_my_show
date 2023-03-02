package com.example.book_my_show.ResponseDtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntityResponseDto {

    private String ticketId;

    private String movieName;

    private String theaterName;

    private LocalDate showDate;

    private LocalTime showTime;

    private String bookedSeats;

    private double totalAmount;

}
