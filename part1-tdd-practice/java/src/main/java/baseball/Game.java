package baseball;

import java.util.List;

public class Game {
    public boolean isEnd(int strike) {
        return strike == 3;
    }

    public String playTurn(List<Integer> answer, List<Integer> guess) {
        Judge judge = new Judge();
        int strike = judge.countStrike(answer, guess);
        int ball = judge.countBall(answer, guess);
        return judge.formatResult(ball, strike);
    }

    public String playTurn(List<Integer> answer, String input) {
        return playTurnWithStatus(answer, input).result();
    }

    public TurnResult playTurnWithStatus(List<Integer> answer, String input) {
        //하나의 함수에 너무 많은 함수가 연결되는데 괜찮은건지
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        Judge judge = new Judge();
        inputValidator.validate(input);
        List<Integer> guess = inputParser.parse(input);
        int strike = judge.countStrike(answer, guess);
        int ball = judge.countBall(answer, guess);
        String result = judge.formatResult(ball, strike);
        return new TurnResult(result, isEnd(strike));
    }
}
