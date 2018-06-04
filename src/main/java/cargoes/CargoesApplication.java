package cargoes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cargoes.**.dao")
@EnableTransactionManagement
@ServletComponentScan("cargoes.web.druidMonitor")
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)//
public class CargoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargoesApplication.class, args);
	}
}
