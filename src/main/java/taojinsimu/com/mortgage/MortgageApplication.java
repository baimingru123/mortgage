package taojinsimu.com.mortgage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("taojinsimu.com.mortgage.dao")
public class MortgageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MortgageApplication.class, args);
    }

}
