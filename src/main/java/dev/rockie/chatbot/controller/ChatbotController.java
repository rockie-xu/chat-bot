package dev.rockie.chatbot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class ChatbotController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatbotController.class);

    @GetMapping("/hello")
    public String helloWorld() {

        return "hello World";
    }
}
