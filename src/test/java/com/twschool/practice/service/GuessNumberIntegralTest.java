package com.twschool.practice.service;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class GuessNumberIntegralTest {

    @Test
    public void should_return_3_when_given_1235() {
        //given
        String answer1 = "1 2 3 5";
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "5"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        GameService gameService = new GameService(guessNumberGame);
        //when
        int result = gameService.integral(answer1);
        //then
        Assert.assertEquals(3,result);
    }

    @Test
    public void should_return_6_when_given_1235_1235() {
        //given
        String answer1 = "1 2 3 5";
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "5"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        GameService gameService = new GameService(guessNumberGame);
        //when
        gameService.integral(answer1);
        int result = gameService.integral(answer1);
        //then
        Assert.assertEquals(6,result);
    }

    @Test
    public void should_return_0_when_given_1237() {
        //given
        String answer1 = "1 2 3 7";
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "5"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        GameService gameService = new GameService(guessNumberGame);
        //when
        gameService.integral(answer1);
        gameService.integral(answer1);
        int result = gameService.integral(answer1);
        //then
        Assert.assertEquals(0,result);
    }

    @Test
    public void should_return_0_when_given_1235_1237() {
        //given
        String currentAnswer = "1 2 3 5";
        String answer1 = "1 2 3 7";

        Answer answer = new Answer(Arrays.asList("1", "2", "3", "5"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        GameService gameService = new GameService(guessNumberGame);
        //when
        gameService.integral(currentAnswer);
        gameService.integral(answer1);
        int result = gameService.integral(answer1);
        //then
        Assert.assertEquals(0,result);
    }

    @Test
    public void should_return_11_when_given_1235_1235_1235() {
        //given
        String currentAnswer = "1 2 3 5";

        Answer answer = new Answer(Arrays.asList("1", "2", "3", "5"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        GameService gameService = new GameService(guessNumberGame);
        //when
        gameService.integral(currentAnswer);
        gameService.integral(currentAnswer);
        int result = gameService.integral(currentAnswer);
        //then
        Assert.assertEquals(11,result);
    }
}
