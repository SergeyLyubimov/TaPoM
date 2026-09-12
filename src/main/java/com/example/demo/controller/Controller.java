package com.example.demo.controller;

import com.example.demo.service.ThreadTester;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ThreadTester threadTester;

    @GetMapping("/test/threads")
    public String threadTest() throws InterruptedException {
        return threadTester.runThreadTest();
    }
}
