package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

        Set<Thread> activeThreads = Thread.getAllStackTraces().keySet();

        System.out.println("Active Threads:");
        System.out.println("----------------");
        for (Thread thread : activeThreads)
            System.out.println(thread.getName());
        System.out.println("----------------");
	}

}
