package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UmpireTest {

    private final Umpire umpire = new Umpire();

    @Test
    @DisplayName("같은 자리에 같은 수가 있으면 스트라이크이다")
    void countStrike() {
        BaseballNumber answer = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber guess = new BaseballNumber(List.of(1, 5, 3));

        int strikeCount = umpire.countStrike(answer, guess);

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    @DisplayName("다른 자리에 같은 수가 있으면 볼이다")
    void countBall() {
        BaseballNumber answer = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber guess = new BaseballNumber(List.of(2, 1, 9));

        int ballCount = umpire.countBall(answer, guess);

        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    @DisplayName("3스트라이크일 때 볼은 0이다")
    void threeStrikeZeroBall() {
        BaseballNumber answer = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber guess = new BaseballNumber(List.of(1, 2, 3));

        Judgement judgement = umpire.judge(answer, guess);

        assertThat(judgement.strikeCount()).isEqualTo(3);
        assertThat(judgement.ballCount()).isEqualTo(0);
    }
}
