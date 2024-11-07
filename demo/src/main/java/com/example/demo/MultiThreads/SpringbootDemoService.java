package com.example.demo.MultiThreads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SpringbootDemoService {

    @Autowired
    SpringbootDemoAsyncService springbootDemoAsyncService;

    public void processTask() {
        log.info("Start Preparing the Task list");
        List<String> taskList = new ArrayList<>();
        taskList.add("apple");
        taskList.add("orange");
        taskList.add("grapes");
        taskList.add("pineapple");
        taskList.add("banana");
        taskList.add("sapota");
        taskList.add("papaya");
        taskList.add("watermelon");
        taskList.add("coconut");
        taskList.add("muskmelon");
        taskList.add("lemon");
        taskList.add("guvava");

        log.info("Start processing the task list");
        for (String payload : taskList) {
            springbootDemoAsyncService.processTask(payload);
        }
        log.info("Completed processing the task list");
    }
}