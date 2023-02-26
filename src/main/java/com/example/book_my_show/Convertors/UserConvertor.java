package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Entities.UserEntity;

 public class UserConvertor {
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){
        return UserEntity.builder()
                .name(userEntryDto.getName())
                .age(userEntryDto.getAge())
                .mobNo(userEntryDto.getMobNo())
                .email(userEntryDto.getEmail())
                .address(userEntryDto.getAddress())
                .build();
    }
}
