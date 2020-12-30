package training.task.eTicket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import training.task.eTicket.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Long>{

	List<Train> findBySourceAndDestination(String source, String destination);

}
