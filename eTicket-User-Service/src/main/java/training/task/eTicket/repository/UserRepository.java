package training.task.eTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import training.task.eTicket.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
