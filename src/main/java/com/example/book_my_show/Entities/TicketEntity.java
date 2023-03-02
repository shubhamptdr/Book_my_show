package com.example.book_my_show.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;

    private String theaterName;

    private LocalDate showDate;

    private LocalTime showTime;

    private double totalAmount;

    private String bookedSeats;

    private String ticketId = UUID.randomUUID().toString();


    // child wrt to user
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    // child wrt to show
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;


}
