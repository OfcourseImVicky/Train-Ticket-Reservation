package training.task.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.task.activemq.dto.TicketsDto;
import training.task.activemq.service.TicketReservationService;

@RestController
@RequestMapping("")
public class TicketReservationController {

	 @Autowired
	 TicketReservationService ticketReservationService;
	 
	 @PostMapping("/tickets")
	 public String createTicketReservation(@RequestBody TicketsDto ticketsDto) {
		 ticketReservationService.bookTicket(ticketsDto);
		 return "Ticket Reservation is done Successfully";
	 }
	
}
