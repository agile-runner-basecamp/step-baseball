package badcode;

import java.util.List;

public class BadUmpire {
    private static final int DIGIT_LENGTH = 3;

    public int countStrikes(List<Integer> answerNumbers, List<Integer> guessedNumbers) {
        int strikeCount = 0;
        for (int index = 0; index < DIGIT_LENGTH; index++) {
            if (answerNumbers.get(index).equals(guessedNumbers.get(index))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBalls(List<Integer> answerNumbers, List<Integer> guessedNumbers) {
        int ballCount = 0;
        for (int answerIndex = 0; answerIndex < DIGIT_LENGTH; answerIndex++) {
            for (int guessIndex = 0; guessIndex < DIGIT_LENGTH; guessIndex++) {
                if (answerIndex != guessIndex
                        && answerNumbers.get(answerIndex).equals(guessedNumbers.get(guessIndex))) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }
}
