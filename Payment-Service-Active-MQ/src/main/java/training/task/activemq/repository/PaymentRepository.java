package training.task.activemq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import training.task.activemq.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
