package badcode;

import java.util.List;

public class BadUmpire {

    public static final int DIGIT_COUNT = 3;

    public int countStrike(List<Integer> numbers, List<Integer> target) {
        int strike = 0;
        for (int index = 0; index < DIGIT_COUNT; index++) {
            if (numbers.get(index).equals(target.get(index))) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> numbers, List<Integer> target) {
        int ball = 0;
        for (int guessIndex = 0; guessIndex < DIGIT_COUNT; guessIndex++) {
            for (int targetIndex = 0; targetIndex < DIGIT_COUNT; targetIndex++) {
                if (guessIndex != targetIndex && numbers.get(guessIndex).equals(target.get(targetIndex))) {
                    ball++;
                }
            }
        }
        return ball;
    }
}
