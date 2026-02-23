package baseball;

import java.util.List;
import java.util.Objects;

public class BaseballNumber {
    private static final int DIGIT_COUNT = 3;

    private final List<Integer> digits;

    public BaseballNumber(List<Integer> digits) {
        validateDigits(digits);
        this.digits = List.copyOf(digits);
    }

    public int digitAt(int index) {
        return digits.get(index);
    }

    public int size() {
        return digits.size();
    }

    private void validateDigits(List<Integer> digits) {
        Objects.requireNonNull(digits, "digits must not be null");
        if (digits.size() != DIGIT_COUNT) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다.");
        }
    }
}
