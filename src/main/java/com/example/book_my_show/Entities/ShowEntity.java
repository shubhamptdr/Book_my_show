package com.example.book_my_show.Entities;

import com.example.book_my_show.Enums.ShowType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private LocalDate showDate;

    private LocalDate showTime;

    @CreationTimestamp
    private Data createdOn;

    @Enumerated(EnumType.STRING)
    private ShowType showType;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntityList = new ArrayList<>();


}
