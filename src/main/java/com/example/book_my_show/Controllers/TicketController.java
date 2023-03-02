package com.example.book_my_show.Controllers;

import com.example.book_my_show.EntryDtos.TicketEntryDto;
import com.example.book_my_show.ResponseDtos.TicketEntityResponseDto;
import com.example.book_my_show.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book-ticket")
    public ResponseEntity<String> bookTicket(@RequestBody TicketEntryDto ticketEntryDto){
        try {

            String response =  ticketService.bookTicket(ticketEntryDto);
            return new ResponseEntity<>(response,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-ticket-by-user")
    public ResponseEntity<List<TicketEntityResponseDto>> getAllTicketByUserId(@RequestParam int userId){
        List<TicketEntityResponseDto> response = ticketService.getAllTicketByUserId(userId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/get-all-ticket-by-show")
    public ResponseEntity<List<TicketEntityResponseDto>> getAllTicketByShowId(@RequestParam int showId){
        List<TicketEntityResponseDto> response = ticketService.getAllTicketByShowId(showId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
