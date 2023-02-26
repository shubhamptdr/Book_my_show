package com.example.book_my_show.EntryDtos;

import com.example.book_my_show.Enums.Genre;
import com.example.book_my_show.Enums.Languages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntryDto {

    private String movieName;

    private int duration;

    private double rating;

    private Languages languages;

    private Genre genre;
}
