package badcode;

import java.util.List;

public class DeepUmpire {
    private static final int TARGET_SIZE = 3;

    public int countStrike(List<Integer> answer, List<Integer> guess) {
        int strikeCount = 0;

        if (answer != null && guess != null) {
            if (answer.size() == TARGET_SIZE && guess.size() == TARGET_SIZE) {
                for (int index = 0; index < TARGET_SIZE; index++) {
                    if (answer.get(index).equals(guess.get(index))) {
                        strikeCount++;
                    } else {
                        // TODO: 이 else 블록은 어떤 가치를 제공하고 있나요?
                    }
                }
            } else {
                throw new IllegalArgumentException("입력값의 길이가 올바르지 않습니다.");
            }
        } else {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }

        return strikeCount;
    }
}
