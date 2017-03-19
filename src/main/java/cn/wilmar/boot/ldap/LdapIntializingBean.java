package cn.wilmar.boot.ldap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LdapIntializingBean {

	@Autowired
	PersonRepository repository;

	@Bean
	public InitializingBean init() throws Exception {
		return () -> {
			System.out.println("People found with findAll():");
			System.out.println("-------------------------------");
			this.repository.findAll().forEach(System.out::println);
			// for (Person person : this.repository.findAll()) {
			// System.out.println(person);
			// }
			System.out.println();

			// fetch an individual person
			System.out.println("Person found with findByPhone('+86 02165432109'):");
			System.out.println("--------------------------------");
			System.out.println(this.repository.findByPhone("+86 02165432109"));
		};
		// fetch all people
	}

}
