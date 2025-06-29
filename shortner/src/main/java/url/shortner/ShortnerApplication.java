package url.shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import url.shortner.controller.ConnectBasicExample;

@SpringBootApplication
public class ShortnerApplication {

	public static void main(String[] args) {


//		ConnectBasicExample basic=new ConnectBasicExample();
//		basic.run();

		SpringApplication.run(ShortnerApplication.class, args);

	}


}
