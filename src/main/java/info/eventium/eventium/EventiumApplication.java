package info.eventium.eventium;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EntityScan( basePackages = {"core.entity"})
@EnableJpaRepositories(basePackages = "core.repository")
@ComponentScan(basePackages = {"adapter","core"})
@SpringBootApplication
public class EventiumApplication {
	@Bean
	public ModelMapper getObjectMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(EventiumApplication.class, args);
	}

}
