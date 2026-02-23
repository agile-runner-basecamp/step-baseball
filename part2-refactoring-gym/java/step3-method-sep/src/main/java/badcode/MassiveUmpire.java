package badcode;

import java.util.List;

public class MassiveUmpire {
    private static final int DIGIT_COUNT = 3;

    public int[] playGame(List<String> rawAnswer, List<String> rawGuess) {
        validateInput(rawAnswer, rawGuess);
        int[] answer = parseDigits(rawAnswer);
        int[] guess = parseDigits(rawGuess);

        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);

        return new int[] { strikeCount, ballCount };
    }

    private void validateInput(List<String> rawAnswer, List<String> rawGuess) {
        if (rawAnswer == null || rawGuess == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }

        if (rawAnswer.size() != DIGIT_COUNT || rawGuess.size() != DIGIT_COUNT) {
            throw new IllegalArgumentException("입력값의 길이가 3이어야 합니다.");
        }
    }

    private int[] parseDigits(List<String> rawNumbers) {
        int[] parsed = new int[DIGIT_COUNT];
        for (int index = 0; index < DIGIT_COUNT; index++) {
            parsed[index] = parseDigit(rawNumbers.get(index));
        }
        return parsed;
    }

    private int parseDigit(String rawNumber) {
        try {
            return Integer.parseInt(rawNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private int countStrike(int[] answer, int[] guess) {
        int strikeCount = 0;
        for (int index = 0; index < DIGIT_COUNT; index++) {
            if (answer[index] == guess[index]) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(int[] answer, int[] guess) {
        int ballCount = 0;
        for (int answerIndex = 0; answerIndex < DIGIT_COUNT; answerIndex++) {
            for (int guessIndex = 0; guessIndex < DIGIT_COUNT; guessIndex++) {
                if (answerIndex != guessIndex && answer[answerIndex] == guess[guessIndex]) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }
}
