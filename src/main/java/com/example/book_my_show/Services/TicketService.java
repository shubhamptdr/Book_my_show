package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.TicketConvertor;
import com.example.book_my_show.Entities.ShowEntity;
import com.example.book_my_show.Entities.ShowSeatEntity;
import com.example.book_my_show.Entities.TicketEntity;
import com.example.book_my_show.Entities.UserEntity;
import com.example.book_my_show.EntryDtos.TicketEntryDto;
import com.example.book_my_show.Repositories.ShowRepository;
import com.example.book_my_show.Repositories.TicketRepository;
import com.example.book_my_show.Repositories.UserRepository;
import com.example.book_my_show.ResponseDtos.TicketEntityResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JavaMailSender javaMailSender;


    public String bookTicket(TicketEntryDto ticketEntryDto) throws Exception {

        // create entity
        TicketEntity ticketEntity = TicketConvertor.convertEntryDtoToEntity(ticketEntryDto);

        // Validation : check is requestedSeat is available or not?
        boolean isValidRequest = checkValidityOfRequestedSeats(ticketEntryDto);

        if (isValidRequest==false){
            throw new Exception("RequestedSeats are not available");
        }

        // calculate totalAmount:
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeatEntity> showSeatEntityList = showEntity.getListOfShowSeats();

        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        int totalAmount = 0;
        for (ShowSeatEntity showSeatEntity : showSeatEntityList){
            if (requestedSeats.contains(showSeatEntity.getSeatNo())){
                totalAmount += showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }

        ticketEntity.setTotalAmount(totalAmount);

        // Setting other attr.
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMovieName());
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());

        // Set string requestedSeats
        String allotedSeats = getAllotedSeatsFromShowSeats(requestedSeats);
        ticketEntity.setBookedSeats(allotedSeats);


        // Setting Foreign Key attr.
        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();
        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setShowEntity(showEntity);

        ticketRepository.save(ticketEntity);

        // Save the parent
//        showEntity.getListOfBookedTickets().add(ticketEntity);
//
//        showRepository.save(showEntity);
//
//        userEntity.getBookedTickets().add(ticketEntity);
//
//        userRepository.save(userEntity);

        return "Ticket has successfully been added";
    }

    private String getAllotedSeatsFromShowSeats(List<String> requestedSeats) {
        String result = "";
        for (String seat : requestedSeats){
            result = result + seat + ", ";
        }
        return result;
    }


    private boolean checkValidityOfRequestedSeats(TicketEntryDto ticketEntryDto) {

        int showId = ticketEntryDto.getShowId();

        // fetch ShowEntity
        ShowEntity showEntity = showRepository.findById(showId).get();
        List<ShowSeatEntity> showSeatEntityList = showEntity.getListOfShowSeats();

        //  requestedSeats from DTO
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        // check for available requestedSeats
        for (ShowSeatEntity showSeatEntity : showSeatEntityList){
            String seatNo = showSeatEntity.getSeatNo();

            if (requestedSeats.contains(seatNo)){
                if (showSeatEntity.isBooked()){
                    return false; //Since this seat is booked
                }
            }
        }
        // All requestedSeats were available;
        return  true;

    }

    public List<TicketEntityResponseDto> getAllTicketByUserId(int userId) {

        List<TicketEntity> ticketEntityList = userRepository.findById(userId).get().getBookedTickets();
        List<TicketEntityResponseDto> ticketEntityResponseDtoList = new ArrayList<>();
        for (TicketEntity ticketEntity : ticketEntityList){
            TicketEntityResponseDto ticketEntityResponseDto = TicketConvertor.convertEntityToResponseDto(ticketEntity);
            ticketEntityResponseDtoList.add(ticketEntityResponseDto);
        }
        return ticketEntityResponseDtoList;
    }

    public List<TicketEntityResponseDto> getAllTicketByShowId(int showId) {
        List<TicketEntity> ticketEntityList = showRepository.findById(showId).get().getListOfBookedTickets();
        List<TicketEntityResponseDto> ticketEntityResponseDtoList = new ArrayList<>();
        for (TicketEntity ticketEntity : ticketEntityList){
            TicketEntityResponseDto ticketEntityResponseDto = TicketConvertor.convertEntityToResponseDto(ticketEntity);
            ticketEntityResponseDtoList.add(ticketEntityResponseDto);
        }
        return ticketEntityResponseDtoList;
    }
}
