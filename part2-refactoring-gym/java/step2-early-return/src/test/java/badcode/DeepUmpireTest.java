package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DeepUmpireTest {
    @DisplayName("같은 자리에 같은 수가 있으면 스트라이크이다")
    @Test
    void countStrikeReturnsCorrectCount() {
        // given
        DeepUmpire umpire = new DeepUmpire();
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(1, 4, 5);

        // when
        int strike = umpire.countStrike(answer, guess);

        // then
        assertThat(strike).isEqualTo(1);
    }

    @DisplayName("입력값이 null이면 예외가 발생한다")
    @Test
    void throwsExceptionWhenInputIsNull() {
        DeepUmpire umpire = new DeepUmpire();
        assertThatThrownBy(() -> umpire.countStrike(null, List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값의 크기가 다르면 예외가 발생한다")
    @Test
    void throwsExceptionWhenSizeMismatch() {
        DeepUmpire umpire = new DeepUmpire();
        assertThatThrownBy(() -> umpire.countStrike(List.of(1, 2), List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
