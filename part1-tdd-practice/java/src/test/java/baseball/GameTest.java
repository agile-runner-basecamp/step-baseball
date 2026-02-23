package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("스트라이크가 3이면 게임이 종료된다")
    @Test
    void gameEndsWhenThreeStrike() {
        // given
        Game game = new Game();

        // when
        boolean result = game.isEnd(3);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("한 턴 결과를 볼/스트라이크 문자열로 반환한다")
    @Test
    void playTurn() {
        // given
        Game game = new Game();
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(1, 3, 5);

        // when
        String result = game.playTurn(answer, guess);

        // then
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("문자열 입력으로 한 턴 결과를 반환한다")
    @Test
    void playTurnWithInput() {
        // given
        Game game = new Game();
        List<Integer> answer = List.of(1, 2, 3);

        // when
        String result = game.playTurn(answer, "135");

        // then
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }
}
