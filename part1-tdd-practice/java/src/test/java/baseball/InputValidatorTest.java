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
}
