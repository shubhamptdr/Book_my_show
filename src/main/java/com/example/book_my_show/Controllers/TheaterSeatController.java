package com.example.book_my_show.Controllers;

import com.example.book_my_show.ResponseDtos.TheaterSeatEnityResponseDto;
import com.example.book_my_show.Services.TheaterSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theater_seat")
public class TheaterSeatController {

    @Autowired
    TheaterSeatService theaterSeatService;

    @GetMapping("/get-all-theaterSeats")
    public ResponseEntity<List<TheaterSeatEnityResponseDto>> getAllTheaterSeatByTheaterId(@RequestParam int theaterId){
        try {
            List<TheaterSeatEnityResponseDto> response = theaterSeatService.getAllTheaterSeatByTheaterId(theaterId);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/get-theaterSeat")
    public ResponseEntity<TheaterSeatEnityResponseDto> getTheaterSeatById(@RequestParam int theaterSeatId){
        try {
            TheaterSeatEnityResponseDto response = theaterSeatService.getTheaterSeatById(theaterSeatId);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
