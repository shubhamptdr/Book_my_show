package com.example.book_my_show.Convertors;

import com.example.book_my_show.Entities.ShowEntity;
import com.example.book_my_show.EntryDtos.ShowEntryDto;

public class ShowConvertor {
    public static ShowEntity convertEntryDtoToEntity(ShowEntryDto showEntryDto){
        return ShowEntity
                .builder()
                .showDate(showEntryDto.getLocalDate())
                .showTime(showEntryDto.getLocalTime())
                .showType(showEntryDto.getShowType())
                .build();

    }
}
