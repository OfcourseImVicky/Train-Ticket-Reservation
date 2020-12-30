package training.task.eTicket.servie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import training.task.eTicket.dto.BookingPojo;
import training.task.eTicket.dto.TrainDto;
import training.task.eTicket.entity.AvailabilityDetails;
import training.task.eTicket.entity.Train;
import training.task.eTicket.repository.AvailabilityDetailsRepository;
import training.task.eTicket.repository.TrainRepository;

@Service
public class TrainService {
	@Autowired
	private TrainRepository trainRepository;
	@Autowired
	private AvailabilityDetailsRepository availabilityDetailsRepository;

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
	public List<TrainDto> searchTrains(BookingPojo bookingDto) {
		List<Train> availableTrainList = trainRepository.findBySourceAndDestination(bookingDto.getSource(),
				bookingDto.getDestination());
		List<Train> finalTrainList = new ArrayList<>();
		List<TrainDto> finalTrainDtoList = new ArrayList<>();
		int dateOfTravel = bookingDto.getTravelDate().getDayOfWeek().getValue();
		availableTrainList.stream().forEach(train -> {
			AvailabilityDetails availabilityDetails = availabilityDetailsRepository
					.findByTrainIdAndDayOfWeek(train.getId(), dateOfTravel);
			if (Objects.nonNull(availabilityDetails)) {
				finalTrainList.add(train);
			} else {

			}
		});
		finalTrainList.forEach(train -> {
			TrainDto trainDto = new TrainDto();
			BeanUtils.copyProperties(train, trainDto);
			finalTrainDtoList.add(trainDto);
		});

		return finalTrainDtoList;

	}
}
