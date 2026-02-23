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
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        inputValidator.validate(input);
        List<Integer> guess = inputParser.parse(input);
        return playTurn(answer, guess);
    }
}
