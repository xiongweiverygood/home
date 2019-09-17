package com.example.kafkause;

import com.example.kafkause.producer.UserLogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class KafkauseApplication {
	@Autowired
	private UserLogProducer kafkaSender;

	@PostConstruct
	public void init() {
		for(int i = 0; i < 10; i++) {
			kafkaSender.sendLog(String.valueOf(i));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkauseApplication.class, args);
	}

}
