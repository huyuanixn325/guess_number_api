package com.twschool.practice.controller;

import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GameController {
    @GetMapping("/game")
    public String guess(@RequestParam String guess){
        RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        GameService gameService = new GameService(guessNumberGame);
        return gameService.guess(guess);
    }
}
