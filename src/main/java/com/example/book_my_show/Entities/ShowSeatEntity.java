package com.example.book_my_show.Entities;

import com.example.book_my_show.Enums.ShowType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "show_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    private int price;

    private boolean isBooked;

    @Enumerated(value = EnumType.STRING)
    private ShowType seatType;

    @CreationTimestamp
    private Date bookedAt;

}
