package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력이 3자리가 아니면 예외가 발생한다")
    @Test
    void validateLength() {
        // given
        InputValidator inputValidator = new InputValidator();

        // when & then
        assertThatThrownBy(() -> inputValidator.validate("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자가 포함되면 예외가 발생한다")
    @Test
    void validateNumberOnly() {
        // given
        InputValidator inputValidator = new InputValidator();

        // when & then
        assertThatThrownBy(() -> inputValidator.validate("1a3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
