package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.UserConvertor;
import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Entities.UserEntity;
import com.example.book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(UserEntryDto userEntryDto) throws Exception{

        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);
         userRepository.save(userEntity);

        return "User added successfully";
    }
}
