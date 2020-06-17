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
    public void should_return_3_when_given_1234() {
        //given
        String answer1 = "1 2 3 4";
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        GameService gameService = new GameService(guessNumberGame);
        //when
        int result = gameService.integral(answer1);
        //then
        Assert.assertEquals(3,result);
    }
}
