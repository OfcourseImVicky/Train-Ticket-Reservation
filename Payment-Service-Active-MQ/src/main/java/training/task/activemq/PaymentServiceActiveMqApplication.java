package training.task.activemq;

import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class PaymentServiceActiveMqApplication {
	
//	@Bean
//	public Topic topic() {
//		return new ActiveMQTopic("paymentTopic");
//	}
	@Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceActiveMqApplication.class, args);
	}

}
