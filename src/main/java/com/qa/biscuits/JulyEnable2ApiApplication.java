package com.qa.biscuits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.biscuits.rest.BiscuitController;
import com.qa.biscuits.service.BiscuitService;
import com.qa.biscuits.service.BiscuitServiceDB;

@SpringBootApplication
public class JulyEnable2ApiApplication {

	public static void main(String[] args) {
		// THIS IS FOR DEMO PURPOSES ONLY
		ApplicationContext context = SpringApplication.run(JulyEnable2ApiApplication.class, args);
		System.out.println("SERVICE: " + context.getBean(BiscuitService.class));
		System.out.println("CONTROLLER: " + context.getBean(BiscuitController.class));

		// kinda works like this:
		BiscuitController controller = new BiscuitController(new BiscuitServiceDB());
	}

}
