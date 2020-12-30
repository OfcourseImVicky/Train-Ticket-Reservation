package training.task.eTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

import training.task.eTicket.config.RibbonConfig;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@RibbonClient(name = "ticket-service", configuration = RibbonConfig.class)
public class ETicketApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ETicketApiGatewayApplication.class, args);
	}

}
