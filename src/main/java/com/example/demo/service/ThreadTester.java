package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ThreadTester {
    public String runThreadTest() throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            double counter = 0;
            for (int i = 0; i < 10000000; i++) {
                counter += 1;
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        log.info("Thread 1 is currently: " + t1.getState());

        t1.start();
        log.info("Thread 1 is currently: " + t1.getState());

        t2.start();
        Thread.sleep(50);
        log.info("Thread 2 is currently: " + t2.getState());

        synchronized (lock) {
            t3.start();
            Thread.sleep(50);
            log.info("Thread 3 is currently: " + t3.getState());
        }

        Thread.sleep(50);
        log.info("Thread 3 is currently: " + t3.getState());

        synchronized (lock) {
            lock.notify();
        }

        t1.join();
        log.info("Thread 1 is currently: " + t1.getState());

        return "ok";
    }
}
