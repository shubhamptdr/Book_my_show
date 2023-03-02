package com.example.book_my_show.Controllers;

import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){
        try {
            String response = userService.addUser(userEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {

            String result = "User could not be added";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody int userId){
        try {
            String response = userService.deleteUser(userId);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateMobileNo(@RequestBody int userId, @RequestParam String mobNo){
        try {
            String response = userService.updateMobileNo(userId,mobNo);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
