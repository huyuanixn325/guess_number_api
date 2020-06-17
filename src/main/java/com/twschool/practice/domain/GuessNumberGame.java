package com.twschool.practice.domain;

import com.twschool.practice.domain.GameStatus;

import java.util.List;

public class GuessNumberGame {
    private Answer answer;
    private GameStatus status = GameStatus.CONTINUED;
    private int MAX_TRY_TIMES = 6;
    private static int correctTimes = 0;
    private static int score = 0;
    private int leftTryTimes = MAX_TRY_TIMES;
    private RandomAnswerGenerator randomAnswerGenerator;

    public GuessNumberGame(RandomAnswerGenerator randomAnswerGenerator) {
        this.randomAnswerGenerator = randomAnswerGenerator;
        this.answer = randomAnswerGenerator.generateAnswer();
    }

    public String guess(List<String> userAnswerNumbers) {
        String result = answer.check(userAnswerNumbers);
        decreaseTryTimes();
        modifyStatus(result);
        return result;
    }

    private void modifyStatus(String result) {
        boolean noTryTimes = leftTryTimes == 0;
        if (noTryTimes) {
            status = GameStatus.FAILED;
        }
        boolean succeed = result.equals("4A0B");
        if (succeed) {
            status = GameStatus.SUCCEED;
        }
    }

    private void decreaseTryTimes() {
        leftTryTimes --;
    }

    public GameStatus getStatus() {
        return status;
    }

    public int countScore(String result){
        if (result.equals("4A0B")){
            if (correctTimes==0){
                score=score+3;
                correctTimes++;
            }else {
                score=score+3;
                correctTimes++;
                if (correctTimes%3==0) score=score+2;
                if (correctTimes%5==0) score=score+3;
            }
        }else {
            if (score>=3)
                score=score-3;
            else score=0;
            correctTimes=0;
        }
        return score;
    }
}
