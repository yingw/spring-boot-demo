package cn.wilmar.boot;

import java.security.Principal;
import java.util.stream.Stream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wilmar.boot.model.User;
import cn.wilmar.boot.repository.UserRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableJms
@EnableWebSecurity
// @EnableOAuth2Sso
@EnableOAuth2Client
@EnableSwagger2
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	// test
	// fs
	@Bean
	InitializingBean saveData(UserRepository userRepo) {
		return () -> Stream.of("Gary Yin", "Will Ling", "Pan XD", "Chuang Wang")
				.forEach(name -> userRepo.save(new User(name)));
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
