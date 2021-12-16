package uz.dosya.marketapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MarketAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketAppApplication.class, args);
    }

}
