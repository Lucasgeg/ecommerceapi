package com.boc.ecommerceapi;

import com.boc.ecommerceapi.model.User;
import com.boc.ecommerceapi.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceapiApplication {

	public static void main(String[] args) {
/*		User user = new User();
		user.setId(102);
		user.setEmail("john.doe@gmail.com");
		user.setName("John DOE");

		userRepository.save(user);*/
		SpringApplication.run(EcommerceapiApplication.class, args);
	}

}
