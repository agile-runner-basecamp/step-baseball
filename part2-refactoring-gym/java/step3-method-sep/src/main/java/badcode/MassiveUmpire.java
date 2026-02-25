package badcode;

import java.util.List;

public class MassiveUmpire {

    public static final int DIGIT_COUNT = 3;

    public int[] playGame(List<String> rawAnswer, List<String> rawGuess) {
        validateInput(rawAnswer, rawGuess); // 레벨 2

        int[] answer = parseInput(rawAnswer);
        int[] guess = parseInput(rawGuess);

        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);

        // 5. 결과 반환 (0번 인덱스: 스트라이크, 1번 인덱스: 볼)
        return new int[]{strikeCount, ballCount};
    }

    private static void validateInput(List<String> rawAnswer, List<String> rawGuess) {
        // 1. 입력 검증
        if (rawAnswer == null || rawGuess == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }
        if (rawAnswer.size() != DIGIT_COUNT || rawGuess.size() != DIGIT_COUNT) {
            throw new IllegalArgumentException("입력값의 길이가 3이어야 합니다.");
        }
    }

    private int[] parseInput(List<String> rawInput) {
        // 2. 파싱 (String -> Integer)
        int[] parsedInput = new int[DIGIT_COUNT];
        for (int index = 0; index < DIGIT_COUNT; index++) {
            try {
                parsedInput[index] = Integer.parseInt(rawInput.get(index));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
        return parsedInput;
    }

    private int countStrike(int[] answer, int[] guess) {
        // 3. 스트라이크 판정
        int strikeCount = 0;
        for (int index = 0; index < DIGIT_COUNT; index++) {
            if (answer[index] == guess[index]) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(int[] answer, int[] guess) {
        // 4. 볼 판정
        int ballCount = 0;
        for (int targetIndex = 0; targetIndex < DIGIT_COUNT; targetIndex++) {
            for (int guessIndex = 0; guessIndex < DIGIT_COUNT; guessIndex++) {
                if (targetIndex != guessIndex && answer[targetIndex] == guess[guessIndex]) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }
}
