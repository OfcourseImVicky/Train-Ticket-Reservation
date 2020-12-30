package training.task.activemq.receiver;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import training.task.activemq.dto.InsuranceDto;
import training.task.activemq.dto.PaymentDto;
import training.task.activemq.dto.TicketsDto;
import training.task.activemq.entity.Insurance;
import training.task.activemq.repository.InsuranceRepository;

@Component
public class InsuranceReceiver {
	@Autowired
	private InsuranceRepository insuranceRepository;

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@JmsListener(destination = "paymentTopic")
	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
	public void receiveQueue(PaymentDto paymentDto) {
		System.out.println("Message Received: " + paymentDto.toString());
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Optional<Insurance> insurance = insuranceRepository.findById(paymentDto.getInsuranceId());
		if (Objects.nonNull(insurance)) {
			Insurance updatedInsurance = insurance.get();
			updatedInsurance.setInsuranceStatus("CONFIRMED");
			insuranceRepository.save(updatedInsurance);
		}
	}

	@JmsListener(destination = "ticketTopic")
	public void receiveQueue(TicketsDto ticketsDto) {
		System.out.println("Message Received: " + ticketsDto.toString());
		InsuranceDto insuranceDto = new InsuranceDto();
		insuranceDto.setInsurancePrice(ticketsDto.getTotalTicketsPrice() * 0.1);
		insuranceDto.setTicketId(ticketsDto.getId());
		insuranceDto.setTicketPrice(ticketsDto.getTotalTicketsPrice());
		insuranceDto.setUserId(ticketsDto.getUserId());
		insuranceDto.setInsuranceStatus("PENDING");
		Insurance insurance = new Insurance();
		BeanUtils.copyProperties(insuranceDto, insurance);
		Insurance savedInsurance = insuranceRepository.save(insurance);
		insuranceDto.setId(savedInsurance.getId());
		this.jmsMessagingTemplate.convertAndSend("insuranceTopic", insuranceDto);
		System.out.println("Insurance is created in Insurance service and posted into insuranceTopic");
	}
}
