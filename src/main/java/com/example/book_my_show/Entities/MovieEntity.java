package com.example.book_my_show.Entities;

import com.example.book_my_show.Enums.Genre;
import com.example.book_my_show.Enums.Languages;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String movieName;

    private int duration;

    private double rating;

    @Enumerated(value = EnumType.STRING)
    private Languages languages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

}
