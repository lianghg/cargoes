package cargoes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cargoes.**.dao")
@EnableTransactionManagement
@ServletComponentScan("cargoes.web.configuration.druidMonitor")
public class CargoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargoesApplication.class, args);
	}
}
