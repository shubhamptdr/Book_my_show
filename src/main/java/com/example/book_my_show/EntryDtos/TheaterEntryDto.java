package com.example.book_my_show.EntryDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterEntryDto {

    private  String name;

    private String location;

    private int noOfClassicSeats;

    private int noOfPremiumSeats;

}
