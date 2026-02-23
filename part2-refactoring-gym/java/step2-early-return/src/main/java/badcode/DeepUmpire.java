package badcode;

import java.util.List;

public class DeepUmpire {
    private static final int TARGET_SIZE = 3;

    public int countStrike(List<Integer> answer, List<Integer> guess) {
        if (answer == null || guess == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }

        if (answer.size() != TARGET_SIZE || guess.size() != TARGET_SIZE) {
            throw new IllegalArgumentException("입력값의 길이가 올바르지 않습니다.");
        }

        int strikeCount = 0;
        for (int index = 0; index < TARGET_SIZE; index++) {
            if (answer.get(index).equals(guess.get(index))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
