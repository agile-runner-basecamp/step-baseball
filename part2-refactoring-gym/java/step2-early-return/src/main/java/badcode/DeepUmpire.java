package badcode;

import java.util.List;

public class DeepUmpire {
    private static final int DIGIT_COUNT = 3;

    public int countStrike(List<Integer> numbers, List<Integer> target) {
        int strikeCount = 0;

        if (numbers == null || target == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }

        if (numbers.size() != DIGIT_COUNT || target.size() != DIGIT_COUNT) {
            throw new IllegalArgumentException("입력값의 길이가 올바르지 않습니다.");
        }
        
        for (int index = 0; index < DIGIT_COUNT; index++) {
            if (numbers.get(index).equals(target.get(index))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
