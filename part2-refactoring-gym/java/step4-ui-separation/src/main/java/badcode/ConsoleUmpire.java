package badcode;

import java.util.List;

public class ConsoleUmpire {
    public void play(List<Integer> answer, List<Integer> guess) {
        if (answer.size() != 3 || guess.size() != 3) {
            System.out.println("[ERROR] 숫자는 3자리여야 합니다.");
            return;
        }

        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);

        printResult(strikeCount, ballCount);
    }

    private int countStrike(List<Integer> answer, List<Integer> guess) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Integer> answer, List<Integer> guess) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && answer.get(i).equals(guess.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private void printResult(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        System.out.println(sb.toString().trim());
    }
}
