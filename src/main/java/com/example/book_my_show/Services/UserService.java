package com.example.book_my_show.Services;

import com.example.book_my_show.DTOs.UserEntryDto;
import com.example.book_my_show.Entities.UserEntity;
import com.example.book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(UserEntryDto userEntryDto) {

        UserEntity userEntity = UserEntity.builder().age(userEntryDto
                        .getAge())
                        .email(userEntryDto.getEmail())
                        .mobNo(userEntryDto.getMobNo())
                        .address(userEntryDto.getAddress())
                        .name(userEntryDto.getName())
                        .build();

         userRepository.save(userEntity);

        return "User added successfully";
    }
}
