package com.example.demo;

import com.example.demo.service.ThreadTester;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Main.class, args);

        ThreadTester threadTester = new ThreadTester();
//        threadTester.runThreadTest();
        threadTester.runNumberTest();
	}

}
