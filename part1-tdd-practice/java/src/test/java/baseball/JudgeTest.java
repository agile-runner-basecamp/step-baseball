package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {

    @DisplayName("같은 자리에 같은 수가 있으면 스트라이크이다")
    @Test
    void countStrike() {
        // given
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(1, 4, 5);

        // when
        Judge judge = new Judge();
        int result = judge.countStrike(answer, guess);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("같은 수가 다른 자리에 있으면 볼이다")
    @Test
    void countBall() {
        // given
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(3, 1, 2);

        // when
        Judge judge = new Judge();
        int result = judge.countBall(answer, guess);

        // then
        assertThat(result).isEqualTo(3);
    }
}
