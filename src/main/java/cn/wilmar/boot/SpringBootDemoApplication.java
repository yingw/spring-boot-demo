package cn.wilmar.boot;

import java.util.stream.Stream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cn.wilmar.boot.model.User;
import cn.wilmar.boot.repository.UserRepository;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	//test
	//fs
	@Bean
	InitializingBean saveData(UserRepository userRepo) {
		return () -> Stream.of("Gary Yin", "Will Ling", "Pan XD", "Chuang Wang").forEach(name -> userRepo.save(new User(name)));
	}
}
