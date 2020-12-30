package training.task.activemq.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import training.task.activemq.dto.TicketsDto;
import training.task.activemq.entity.Tickets;
import training.task.activemq.repo.TicketsRepository;

@Service
public class TicketReservationService {
	
	@Autowired
	TicketsRepository ticketsRepository;
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	 
	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
	public void bookTicket(TicketsDto ticketsDto) {
		Tickets tickets = new Tickets();
		ticketsDto.setBookingStatus("PENDING");
		ticketsDto.setUserId(Long.valueOf(1));
		ticketsDto.setTotalTicketsPrice(100*ticketsDto.getTotalSeats());
		BeanUtils.copyProperties(ticketsDto, tickets);
		Tickets savedTicket = ticketsRepository.save(tickets);
		ticketsDto.setId(savedTicket.getId());
		this.jmsMessagingTemplate.convertAndSend("ticketTopic",ticketsDto);
	    System.out.println("Ticket is created in TicketBooking service and posted into ticketTopic");
	}

}
