package url.shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import url.shortner.Service.addToRedis;
import url.shortner.controller.ConnectBasicExample;
@SpringBootApplication
//		(exclude = {SecurityAutoConfiguration.class})

public class ShortnerApplication {

	public static void main(String[] args) {


//		ConnectBasicExample basic=new ConnectBasicExample();
//		basic.run();
addToRedis redisService =  addToRedis.getInstance();
//		redisService.start();
		SpringApplication.run(ShortnerApplication.class, args);
		redisService.close();

	}
	//todo:
//	🔐 Switch to BCryptPasswordEncoder
//	More secure — good for staging/prod. I can help you migrate.
//
//🧠 Store users in a database (e.g., H2, MySQL)
//	Instead of hardcoding, make a UserEntity table.
//
//			📦 Add session persistence with Redis
//	Useful if you deploy across multiple servers.
//
//🎯 Add role-based access
//	Protect /admin/** for only "ROLE_ADMIN" etc.

}
