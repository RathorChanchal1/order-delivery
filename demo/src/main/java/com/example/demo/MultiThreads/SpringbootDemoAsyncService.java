package com.example.demo.MultiThreads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpringbootDemoAsyncService {

    @Async("multithreadingdemobean")
    public void processTask(String payload) {
        log.info("Starting Thread - Processing Payload {}",payload );
        log.info("Length of Payload string is {}", payload.length());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Exiting Thread - Processing payload {} completed", payload);

    }
}