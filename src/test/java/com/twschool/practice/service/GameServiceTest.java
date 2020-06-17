package com.twschool.practice.service;


import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GameServiceTest {
    @Test
    public void should_return_guess_result_when_given_current() throws Exception{
        //given
        String answer1 = "1 2 3 4";
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        GameService gameService = new GameService(guessNumberGame);
        //when
        String result = gameService.guess(answer1);
        //then
        Assert.assertEquals("4A0B",result);
    }
}
