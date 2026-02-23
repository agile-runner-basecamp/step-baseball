package badcode;

import java.util.List;

public class Umpire {
    public String judge(List<Integer> answer, List<Integer> guess) {
        validateInput(answer, guess);

        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);

        if (strikeCount == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        String message = "";
        if (ballCount > 0) {
            message = ballCount + "볼";
        }
        if (strikeCount > 0) {
            if (!message.isEmpty()) {
                message += " ";
            }
            message += strikeCount + "스트라이크";
        }
        return message;
    }

    private void validateInput(List<Integer> answer, List<Integer> guess) {
        if (answer == null || guess == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }
        if (answer.size() != 3 || guess.size() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 3이어야 합니다.");
        }
    }

    private int countStrike(List<Integer> answer, List<Integer> guess) {
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (answer.get(index).equals(guess.get(index))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(List<Integer> answer, List<Integer> guess) {
        int ballCount = 0;
        for (int answerIndex = 0; answerIndex < 3; answerIndex++) {
            for (int guessIndex = 0; guessIndex < 3; guessIndex++) {
                if (isBall(answer, guess, answerIndex, guessIndex)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private boolean isBall(List<Integer> answer, List<Integer> guess, int answerIndex, int guessIndex) {
        return answerIndex != guessIndex && answer.get(answerIndex).equals(guess.get(guessIndex));
    }
}
