package app.mony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//DB없이 실행
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication

public class MonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonyApplication.class, args);
	}

}
