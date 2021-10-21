package edu.kcg.futurelab.sample.springboot;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.kcg.futurelab.sample.springboot.service.repository.UserRepository;
import edu.kcg.futurelab.sample.springboot.service.repository.entity.User;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationStartedEvent.class)
	@Transactional
	public void init() {
		if(urepo.count() > 0) return;
		urepo.save(new User(
				"admin",
				passwordEncoder().encode("ald34oijfsl"),
				"administrator",
				User.Role.ADMIN));
	}

	@Autowired
	private UserRepository urepo;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
