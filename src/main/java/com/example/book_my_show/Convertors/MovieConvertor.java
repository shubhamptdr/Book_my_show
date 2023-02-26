package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDtos.MovieEntryDto;
import com.example.book_my_show.Entities.MovieEntity;

public class MovieConvertor {
    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){
        return MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .rating(movieEntryDto.getRating())
                .languages(movieEntryDto.getLanguages())
                .build();
    }
}
