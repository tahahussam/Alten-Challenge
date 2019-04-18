package com.altenchallenge;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Taha
 *
 */
@SpringBootApplication
public class AltenChallengeApplication {

	private final static Logger logger = LoggerFactory.getLogger(AltenChallengeApplication.class);

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AltenChallengeApplication.class, args);
		System.out.println("Application Started");
		logger.info("Application Started");
	}
}
