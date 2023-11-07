package com.dto.springbootdto;

import com.dto.springbootdto.model.Location;
import com.dto.springbootdto.model.User;
import com.dto.springbootdto.repo.LocationRepository;
import com.dto.springbootdto.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class SpringbootDtoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;


	@Override
	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setPlace("Pune");
		location.setDescription("Pune is great place to live");
//		location.setLongitude(40.5);
//		location.setLatitude(30.6);
		locationRepository.save(location);

		User user1 = new User();
		user1.setFirstname("Ramesh");
		user1.setLastname("Fadatare");
		user1.setEmail("ramesh@gmail.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();

		user2.setFirstname("John");
		user2.setLastname("Cena");
		user2.setEmail("john@gmail.com");
		user2.setPassword("secret");
		user2.setLocation(location);
		userRepository.save(user2);

	}
}
