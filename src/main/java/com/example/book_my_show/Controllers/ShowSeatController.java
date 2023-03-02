package com.example.book_my_show.Controllers;

import com.example.book_my_show.ResponseDtos.ShowSeatResponseDto;
import com.example.book_my_show.Services.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/show-seat")
public class ShowSeatController {

    @Autowired
    ShowSeatService showSeatService;

    @GetMapping("/get-all-show-seat")
    public ResponseEntity<List<ShowSeatResponseDto>> getAllShowSeatByShowId(@RequestParam int showId){

        List<ShowSeatResponseDto> response = showSeatService.getAllShowSeatByShowId(showId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
