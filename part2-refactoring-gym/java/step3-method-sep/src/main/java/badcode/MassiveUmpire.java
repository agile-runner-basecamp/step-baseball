package badcode;

import java.util.List;

public class MassiveUmpire {

    public static final int NUMBER_SIZE = 3;

    private void validateInput(List<String> rawAnswer, List<String> rawGuess){
        if (rawAnswer == null || rawGuess == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }
        if (rawAnswer.size() != NUMBER_SIZE || rawGuess.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("입력값의 길이가 3이어야 합니다.");
        }
    }

    private int[] parseInput(List<String> rawNumber){
        int[] number = new int[NUMBER_SIZE];

        for (int i = 0; i < NUMBER_SIZE; i++) {
            try {
                number[i] = Integer.parseInt(rawNumber.get(i));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
        return number;
    }

    private int countStrike(int[] answer, int[] guess){
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (answer[i] == guess[i]) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(int[] answer, int[] guess){
        int ballCount = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            for (int j = 0; j < NUMBER_SIZE; j++) {
                if (i != j && answer[i] == guess[j]) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }
    public int[] playGame(List<String> rawAnswer, List<String> rawGuess) {
        // 1. 입력 검증
        validateInput(rawAnswer, rawGuess);

        // 2. 파싱 (String -> Integer)
        int[] answer = parseInput(rawAnswer);
        int[] guess = parseInput(rawGuess);

        // 3. 스트라이크 판정
        int strike = countStrike(answer, guess);

        // 4. 볼 판정
        int ball = countBall(answer, guess);

        // 5. 결과 반환 (0번 인덱스: 스트라이크, 1번 인덱스: 볼)
        return new int[] { strike, ball };
    }
}
