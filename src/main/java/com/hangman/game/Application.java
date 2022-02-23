package com.hangman.game;

import com.hangman.game.service.WordService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    private final WordService wordService;

    public Application(WordService wordService) {
        this.wordService = wordService;
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        builder.headless(false);
        builder.run(args);
    }

    @PostConstruct
    public void init(){
        this.wordService.saveDataInDb();
    }
}
