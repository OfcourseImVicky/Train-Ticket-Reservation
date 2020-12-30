package training.task.activemq.receiver;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import training.task.activemq.dto.PaymentDto;
import training.task.activemq.entity.Tickets;
import training.task.activemq.repo.TicketsRepository;

@Component
public class TicketReceiver {

	@Autowired
	private TicketsRepository ticketRepository;

	@JmsListener(destination = "paymentTopic")
	public void receiveQueue(PaymentDto paymentDto) {
		try {
			Thread.sleep(16000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Message Received: " + paymentDto.toString());
		Optional<Tickets> ticket = ticketRepository.findById(paymentDto.getTicketId());
		if (Objects.nonNull(ticket)) {
			Tickets updatedTicket = ticket.get();
			updatedTicket.setBookingStatus("CONFIRMED");
			ticketRepository.save(updatedTicket);
		}
	}
}
