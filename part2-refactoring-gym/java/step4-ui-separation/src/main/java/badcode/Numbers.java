package badcode;

import java.util.ArrayList;
import java.util.List;

import static badcode.ErrorCode.LENGTH_EXCEPTION;

public class Numbers {

    public static final int DIGIT_COUNT = 3;

    private final List<Integer> numbers;

    private Numbers(List<Integer> list) {
        numbers = new ArrayList<>(list);
        validate();
    }

    public static Numbers of(List<Integer> list) {
        return new Numbers(list);
    }

    private void validate() {
        if (numbers.size() != DIGIT_COUNT) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION.getMessage());
        }
    }

    public int getNumberOf(int index) {
        return numbers.get(index);
    }

    public int countStrike(Numbers guess) {
        int count = 0;
        for (int i = 0; i < DIGIT_COUNT; i++) {
            if (this.getNumberOf(i) == guess.getNumberOf(i)) {
                count++;
            }
        }
        return count;
    }

    public int countBall(Numbers guess) {
        int count = 0;
        for (int answerIndex = 0; answerIndex < DIGIT_COUNT; answerIndex++) {
            for (int guessIndex = 0; guessIndex < DIGIT_COUNT; guessIndex++) {
                if (answerIndex != guessIndex && this.getNumberOf(answerIndex) == (guess.getNumberOf(guessIndex))) {
                    count++;
                }
            }
        }
        return count;
    }
}
