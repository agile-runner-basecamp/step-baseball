package baseball;

public class InputValidator {
    public void validate(String input) {
        // 반환값이 void인 경우는 테스트를 우예짜는지..
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력은 숫자만 가능합니다.");
        }
    }
}
