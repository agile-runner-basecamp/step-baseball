package badcode;

import java.util.List;

public class MassiveUmpire {
    private static final int DIGIT_LENGTH = 3;
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;

    public int[] playGame(List<String> rawAnswer, List<String> rawGuess) {
        validateInput(rawAnswer, rawGuess);

        int[] answer = parseNumbers(rawAnswer);
        int[] guess = parseNumbers(rawGuess);

        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);

        return toResult(strikeCount, ballCount);
    }

    private void validateInput(List<String> rawAnswer, List<String> rawGuess) {
        if (rawAnswer == null || rawGuess == null) {
            throw new IllegalArgumentException("입력값은 NULL일 수 없습니다.");
        }
        if (rawAnswer.size() != DIGIT_LENGTH || rawGuess.size() != DIGIT_LENGTH) {
            throw new IllegalArgumentException("입력값의 길이가 3이어야 합니다.");
        }
    }

    private int[] parseNumbers(List<String> rawNumbers) {
        int[] parsedNumbers = new int[DIGIT_LENGTH];
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            parsedNumbers[i] = parseNumber(rawNumbers.get(i));
        }
        return parsedNumbers;
    }

    private int parseNumber(String rawNumber) {
        try {
            return Integer.parseInt(rawNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private int countStrike(int[] answer, int[] guess) {
        int strikeCount = 0;
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            if (answer[i] == guess[i]) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(int[] answer, int[] guess) {
        int ballCount = 0;
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            for (int j = 0; j < DIGIT_LENGTH; j++) {
                if (isBall(answer, guess, i, j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private boolean isBall(int[] answer, int[] guess, int answerIndex, int guessIndex) {
        return answerIndex != guessIndex && answer[answerIndex] == guess[guessIndex];
    }

    private int[] toResult(int strikeCount, int ballCount) {
        int[] result = new int[2];
        result[STRIKE_INDEX] = strikeCount;
        result[BALL_INDEX] = ballCount;
        return result;
    }
}

/*
package badcode;

import java.util.List;

public class MassiveUmpire {
    private static final int DIGIT_LENGTH = 3;
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;

    public int[] playGame(List<String> rawAnswer, List<String> rawGuess) {
        validateInput(rawAnswer, rawGuess);

        int[] answer = parseNumbers(rawAnswer);
        int[] guess = parseNumbers(rawGuess);

        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);

        return toResult(strikeCount, ballCount);
    }

    private void validateInput(List<String> rawAnswer, List<String> rawGuess) {
        if (rawAnswer == null || rawGuess == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }
        if (rawAnswer.size() != DIGIT_LENGTH || rawGuess.size() != DIGIT_LENGTH) {
            throw new IllegalArgumentException("입력값의 길이가 3이어야 합니다.");
        }
    }

    private int[] parseNumbers(List<String> rawNumbers) {
        int[] parsedNumbers = new int[DIGIT_LENGTH];
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            parsedNumbers[i] = parseNumber(rawNumbers.get(i));
        }
        return parsedNumbers;
    }

    private int parseNumber(String rawNumber) {
        try {
            return Integer.parseInt(rawNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private int countStrike(int[] answer, int[] guess) {
        int strikeCount = 0;
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            if (answer[i] == guess[i]) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(int[] answer, int[] guess) {
        int ballCount = 0;
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            for (int j = 0; j < DIGIT_LENGTH; j++) {
                if (isBall(answer, guess, i, j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private boolean isBall(int[] answer, int[] guess, int answerIndex, int guessIndex) {
        return answerIndex != guessIndex && answer[answerIndex] == guess[guessIndex];
    }

    private int[] toResult(int strikeCount, int ballCount) {
        int[] result = new int[2];
        result[STRIKE_INDEX] = strikeCount;
        result[BALL_INDEX] = ballCount;
        return result;
    }
}

 */