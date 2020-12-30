package training.task.eTicket.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import training.task.eTicket.dto.RequestDto;

@FeignClient(name="ETICKET-SERVICE")
public interface TicketServiceFeignClient {

	 @PostMapping("/tickets")
	 @HystrixCommand(fallbackMethod = "ticketCreationFailure")
	 public String createTicketReservation(@RequestBody RequestDto ticketsDto) ;
	 
		default String ticketCreationFailure(@RequestBody RequestDto ticketsDto) {
			System.out.println("Ticket Service is down!!! fallback route enabled...");
			return "CIRCUIT BREAKER ENABLED!!!No Response From Student Service at this moment. Service will be back shortly - ";
		}
	 
}
