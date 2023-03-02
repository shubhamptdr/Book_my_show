package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.ShowSeatConvertor;
import com.example.book_my_show.Entities.ShowEntity;
import com.example.book_my_show.Entities.ShowSeatEntity;
import com.example.book_my_show.Repositories.ShowRepository;
import com.example.book_my_show.ResponseDtos.ShowEntityResponseDto;
import com.example.book_my_show.ResponseDtos.ShowSeatResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowSeatService {
    @Autowired
    ShowRepository showRepository;

    public List<ShowSeatResponseDto> getAllShowSeatByShowId(int showId) {
        List<ShowSeatEntity> showSeatEntityList = showRepository.findById(showId).get().getListOfShowSeats();
        List<ShowSeatResponseDto> showSeatResponseDtos = new ArrayList<>();
        for (ShowSeatEntity showSeatEntity : showSeatEntityList){
            ShowSeatResponseDto showSeatResponseDto  = ShowSeatConvertor.convertEntityToResponseDto(showSeatEntity);
            showSeatResponseDtos.add(showSeatResponseDto);
        }
        return showSeatResponseDtos;
    }
}
