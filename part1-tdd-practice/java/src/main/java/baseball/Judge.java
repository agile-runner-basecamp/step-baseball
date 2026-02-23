package baseball;

import java.util.List;

public class Judge {
    public int countStrike(List<Integer> answer, List<Integer> guess) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> answer, List<Integer> guess) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (!answer.get(i).equals(guess.get(i)) && answer.contains(guess.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public String formatResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(ball).append("볼");
        }
        if (ball > 0 && strike > 0) {
            result.append(" ");
        }
        if (strike > 0) {
            result.append(strike).append("스트라이크");
        }
        return result.toString();
    }
}
