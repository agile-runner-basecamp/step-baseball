package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MassiveUmpireTest {
    @DisplayName("1스트라이크 1볼을 올바르게 판정한다")
    @Test
    void judgesOneStrikeOneBall() {
        // given
        MassiveUmpire umpire = new MassiveUmpire();
        List<String> answer = List.of("1", "2", "3");
        List<String> guess = List.of("1", "4", "2");

        // when
        int[] result = umpire.playGame(answer, guess);

        // then
        assertThat(result[0]).isEqualTo(1); // 1스트라이크
        assertThat(result[1]).isEqualTo(1); // 1볼
    }

    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생한다")
    @Test
    void throwsExceptionForNonNumericInput() {
        MassiveUmpire umpire = new MassiveUmpire();
        List<String> answer = List.of("1", "2", "3");
        List<String> guess = List.of("1", "a", "3");

        assertThatThrownBy(() -> umpire.playGame(answer, guess))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @DisplayName("입력값이 null이면 예외가 발생한다")
    @Test
    void throwsExceptionWhenInputIsNull() {
        MassiveUmpire umpire = new MassiveUmpire();
        assertThatThrownBy(() -> umpire.playGame(null, List.of("1", "2", "3")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모두 같은 숫자일 때 3스트라이크 0볼이다")
    @Test
    void allMatchReturnsThreeStrikesZeroBall() {
        MassiveUmpire umpire = new MassiveUmpire();
        int[] result = umpire.playGame(List.of("1", "2", "3"), List.of("1", "2", "3"));
        assertThat(result[0]).isEqualTo(3);
        assertThat(result[1]).isEqualTo(0);
    }

    @DisplayName("모두 다른 숫자일 때 0스트라이크 0볼이다")
    @Test
    void noMatchReturnsZeroStrikeZeroBall() {
        MassiveUmpire umpire = new MassiveUmpire();
        int[] result = umpire.playGame(List.of("1", "2", "3"), List.of("4", "5", "6"));
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(0);
    }
}
