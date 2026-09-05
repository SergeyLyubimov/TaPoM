package com.example.demo.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ScrapeTask implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Thread scrapeWorker = new ScrapeWorker();
        Thread formatterThread = new Thread(new FormatterThread());

        scrapeWorker.setName("scrape-worker-1");
        scrapeWorker.start();

        formatterThread.setName("formatter-thread-1");
        formatterThread.start();
    }
}

class ScrapeWorker extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running: " + getName() + "; ID: " + getId());
    }
}

class FormatterThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable running: " + Thread.currentThread().getName()  + "; ID: " + Thread.currentThread().getId());
    }
}