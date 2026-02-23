package badcode;

import java.util.List;

public class ConsoleUmpire {
    private static final int DIGIT_COUNT = 3;

    public String judge(List<Integer> answer, List<Integer> guess) {
        if (answer.size() != DIGIT_COUNT || guess.size() != DIGIT_COUNT) {
            throw new IllegalArgumentException("[ERROR] 숫자는 3자리여야 합니다.");
        }

        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);

        return formatResult(strikeCount, ballCount);
    }

    private int countStrike(List<Integer> answer, List<Integer> guess) {
        int count = 0;
        for (int i = 0; i < DIGIT_COUNT; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Integer> answer, List<Integer> guess) {
        int count = 0;
        for (int i = 0; i < DIGIT_COUNT; i++) {
            for (int j = 0; j < DIGIT_COUNT; j++) {
                if (i != j && answer.get(i).equals(guess.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private String formatResult(int strikeCount, int ballCount) {
        if (strikeCount == DIGIT_COUNT) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        return sb.toString().trim();
    }
}
