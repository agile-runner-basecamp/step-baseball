package baseball;

public class InputValidator {
    public void validate(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력은 숫자만 가능합니다.");
        }
    }
}
