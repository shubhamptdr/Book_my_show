package com.example.book_my_show.Convertors;

import com.example.book_my_show.Entities.ShowEntity;
import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.ResponseDtos.ShowEntityResponseDto;

public class ShowConvertor {
    public static ShowEntity convertEntryDtoToEntity(ShowEntryDto showEntryDto){
        return ShowEntity
                .builder()
                .showDate(showEntryDto.getLocalDate())
                .showTime(showEntryDto.getLocalTime())
                .showType(showEntryDto.getShowType())
                .build();

    }

    public static ShowEntityResponseDto convertEntityToResponseDto(ShowEntity showEntity){
        return ShowEntityResponseDto.builder()
                .movieName(showEntity.getMovieEntity().getMovieName())
                .theaterName(showEntity.getTheaterEntity().getName())
                .showDate(showEntity.getShowDate())
                .showTime(showEntity.getShowTime())
                .showType(showEntity.getShowType())
                .build();

    }
}
