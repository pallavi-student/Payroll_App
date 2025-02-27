package com.uc.payrollapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;;

@SpringBootApplication
@Slf4j
public class PayRollApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PayRollApiApplication.class, args);
		log.info("Employee Payroll App Started in {} Environment", context.getEnvironment().getProperty("environment"));

		log.info("Employee Payroll DB User is {}",
				context.getEnvironment().getProperty("spring.datasource.username"));

	}
}
