package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.TheaterConvertor;
import com.example.book_my_show.Entities.TheaterSeatEntity;
import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.Entities.TheaterEntity;
import com.example.book_my_show.Enums.SeatType;
import com.example.book_my_show.Repositories.TheaterRepository;
import com.example.book_my_show.Repositories.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    @Autowired
    TheaterRepository theaterRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) throws Exception {

        if(theaterEntryDto.getName()==null || theaterEntryDto.getLocation()== null){
            throw new Exception("Enter valid Name and Location");
        }

        TheaterEntity theaterEntity = TheaterConvertor.convertEntryDtoToEntity(theaterEntryDto);

        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);
        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);

        theaterRepository.save(theaterEntity);

        return "Theater added successfully";
    }

    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto, TheaterEntity theaterEntity) {

        int noClassicSeats = theaterEntryDto.getNoOfClassicSeats();
        int noPremiumSeats = theaterEntryDto.getNoOfPremiumSeats();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        // create Classic seats
        for(int count = 1; count <= noClassicSeats; count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatType(SeatType.CLASSIC)
                    .seatNo(count+"C")
                    .theaterEntity(theaterEntity)
                    .build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        // create Premium seats
        for(int count = 1; count <= noPremiumSeats; count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatType(SeatType.PREMIUM)
                    .seatNo(count+"P")
                    .theaterEntity(theaterEntity)
                    .build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        return theaterSeatEntityList;

    }
}
