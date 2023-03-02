package com.example.book_my_show.ResponseDtos;

import com.example.book_my_show.Entities.MovieEntity;
import com.example.book_my_show.Entities.TheaterEntity;
import com.example.book_my_show.Enums.ShowType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowEntityResponseDto {

    private LocalDate showDate;

    private LocalTime showTime;

    private ShowType showType;

    private String movieName;

    private String theaterName;
}
