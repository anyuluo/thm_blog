package cn.thm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.thm.system.mapper")
public class TumoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TumoApplication.class, args);
    }
}
