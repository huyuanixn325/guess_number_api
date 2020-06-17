package com.twschool.practice.service;


import com.twschool.practice.domain.GuessNumberGame;

import java.util.Arrays;
import java.util.List;

public class GameService {
    private GuessNumberGame guessNumberGame;

    public GameService(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public String guess(String answer) {
        List<String> answerList = Arrays.asList(answer.split(" "));
        return guessNumberGame.guess(answerList);
    }
}
