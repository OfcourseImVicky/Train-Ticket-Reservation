package training.task.activemq.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import training.task.activemq.entity.Tickets;

public interface TicketsRepository extends JpaRepository<Tickets, Long>{

}
