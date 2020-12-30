package training.task.activemq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import training.task.activemq.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}
