package training.task.activemq.receiver;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import training.task.activemq.dto.InsuranceDto;
import training.task.activemq.dto.PaymentDto;
import training.task.activemq.entity.Payment;
import training.task.activemq.repository.PaymentRepository;
@Component
public class PaymentReceiver {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@JmsListener(destination = "insuranceTopic")
	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
	public void receiveQueue(InsuranceDto insuranceDto) {
		System.out.println("Message Received: "+insuranceDto.toString());
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setInsuranceId(insuranceDto.getId());
		paymentDto.setTicketId(insuranceDto.getTicketId());
		paymentDto.setUserId(insuranceDto.getUserId());
		paymentDto.setTotalPrice(insuranceDto.getTicketPrice()+insuranceDto.getInsurancePrice());
		paymentDto.setPaymentStatus("CONFIRMED");
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDto, payment);
		Payment savedPayment = paymentRepository.save(payment);
		paymentDto.setId(savedPayment.getId());
		this.jmsMessagingTemplate.convertAndSend(new ActiveMQTopic("paymentTopic"),paymentDto);
	    System.out.println("Payment is Done in Payment service and posted into paymentTopic");
	}
}
