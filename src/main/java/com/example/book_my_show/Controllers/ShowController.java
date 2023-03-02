package com.example.book_my_show.Controllers;

import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.ResponseDtos.ShowEntityResponseDto;
import com.example.book_my_show.ResponseDtos.TheaterSeatEnityResponseDto;
import com.example.book_my_show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){
        try {
            String response = showService.addShow(showEntryDto);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-show")
    public ResponseEntity<List<ShowEntityResponseDto>> getAllShowByTheaterId(@RequestParam int theaterId){
        try {
            List<ShowEntityResponseDto> response = showService.getAllShowByTheaterId(theaterId);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
