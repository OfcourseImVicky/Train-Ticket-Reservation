package training.task.eTicket.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import training.task.eTicket.dto.BookingPojo;
import training.task.eTicket.dto.RequestDto;
import training.task.eTicket.dto.TrainDto;
import training.task.eTicket.feignclient.TicketServiceFeignClient;
import training.task.eTicket.servie.TrainService;

@RestController
public class UserController {

	@Autowired
	private TrainService trainService;
	@Autowired
	private TicketServiceFeignClient ticketServiceClient;

	@GetMapping("/test")
	public String test() {

		return "Successfully authenticated and logged into Test Controller";
	}

	@PostMapping("/tickets")
	public ResponseEntity<String> createTicketReservation(@RequestBody RequestDto requestDto) {
		String responseMessage = ticketServiceClient.createTicketReservation(requestDto);
		if(responseMessage.contains("success")) {
			return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
		}
		
	}

	@GetMapping("/trains")
	public ResponseEntity<List<TrainDto>> getTrains(@RequestParam String source, @RequestParam String destination,
			@RequestParam String travelDate) {
		BookingPojo bookingPojo = new BookingPojo();
		bookingPojo.setSource(source);
		bookingPojo.setDestination(destination);
		String[] travelDateStr = travelDate.split("-");
		bookingPojo.setTravelDate(LocalDate.of(Integer.parseInt(travelDateStr[0]), Integer.parseInt(travelDateStr[1]),
				Integer.parseInt(travelDateStr[2])));
		List<TrainDto> trainList = trainService.searchTrains(bookingPojo);
		return ResponseEntity.status(HttpStatus.OK).body(trainList);

	}
}
