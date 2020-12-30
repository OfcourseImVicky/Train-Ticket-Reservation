package training.task.eTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import training.task.eTicket.entity.AvailabilityDetails;

public interface AvailabilityDetailsRepository extends JpaRepository<AvailabilityDetails, Long>{

	 AvailabilityDetails findByTrainIdAndDayOfWeek(long trainId, int dayOfWeek);

}
