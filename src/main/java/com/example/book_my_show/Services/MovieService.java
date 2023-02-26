package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.MovieConvertor;
import com.example.book_my_show.EntryDtos.MovieEntryDto;
import com.example.book_my_show.Entities.MovieEntity;
import com.example.book_my_show.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(MovieEntryDto movieEntryDto) throws Exception {
        MovieEntity movieEntity = MovieConvertor.convertEntryDtoToEntity(movieEntryDto);

        movieRepository.save(movieEntity);

        return "Movie added successfully";

    }
}
