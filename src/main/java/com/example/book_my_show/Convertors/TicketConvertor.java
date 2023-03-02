package com.example.book_my_show.Convertors;

import com.example.book_my_show.Entities.TicketEntity;
import com.example.book_my_show.EntryDtos.TicketEntryDto;
import com.example.book_my_show.ResponseDtos.TicketEntityResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TicketConvertor {
    public static TicketEntity convertEntryDtoToEntity(TicketEntryDto ticketEntryDto){
        return new TicketEntity();
    }
    public static TicketEntityResponseDto convertEntityToResponseDto(TicketEntity ticketEntity){
        return TicketEntityResponseDto.builder()
                .ticketId(ticketEntity.getTicketId())
                .totalAmount(ticketEntity.getTotalAmount())
                .movieName(ticketEntity.getMovieName())
                .theaterName(ticketEntity.getTheaterName())
                .showTime(ticketEntity.getShowTime())
                .showDate(ticketEntity.getShowDate())
                .bookedSeats(ticketEntity.getBookedSeats())
                .build();
    }
}
