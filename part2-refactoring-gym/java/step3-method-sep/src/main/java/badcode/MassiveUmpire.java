package badcode;

import java.util.List;

public class MassiveUmpire {
    public int[] playGame(List<String> rawAnswer, List<String> rawGuess) {
        // 1. 입력 검증
        if (rawAnswer == null || rawGuess == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }
        if (rawAnswer.size() != 3 || rawGuess.size() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 3이어야 합니다.");
        }

        // 2. 파싱 (String -> Integer)
        int[] answer = new int[3];
        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            try {
                answer[i] = Integer.parseInt(rawAnswer.get(i));
                guess[i] = Integer.parseInt(rawGuess.get(i));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }

        // 3. 스트라이크 판정
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (answer[i] == guess[i]) {
                strikeCount++;
            }
        }

        // 4. 볼 판정
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && answer[i] == guess[j]) {
                    ballCount++;
                }
            }
        }

        // 5. 결과 반환 (0번 인덱스: 스트라이크, 1번 인덱스: 볼)
        return new int[] { strikeCount, ballCount };
    }
}
