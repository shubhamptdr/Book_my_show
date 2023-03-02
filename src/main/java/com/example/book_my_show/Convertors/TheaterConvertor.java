package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.Entities.TheaterEntity;


public class TheaterConvertor {
    public static TheaterEntity convertEntryDtoToEntity(TheaterEntryDto theaterEntryDto){
        return TheaterEntity.builder()
                .name(theaterEntryDto.getName())
                .location(theaterEntryDto.getLocation())
                .build();
    }

}
