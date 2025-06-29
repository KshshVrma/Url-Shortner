package url.shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import url.shortner.Service.addToRedis;
import url.shortner.controller.ConnectBasicExample;

@SpringBootApplication
public class ShortnerApplication {

	public static void main(String[] args) {


//		ConnectBasicExample basic=new ConnectBasicExample();
//		basic.run();
addToRedis redisService =  addToRedis.getInstance();
//		redisService.start();
		SpringApplication.run(ShortnerApplication.class, args);
		redisService.close();

	}


}
