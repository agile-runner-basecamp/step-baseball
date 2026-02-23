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
        return 3;
    }
}
