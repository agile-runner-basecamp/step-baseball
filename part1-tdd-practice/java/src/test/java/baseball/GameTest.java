package baseball;

import static org.assertj.core.api.Assertions.assertThat;

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
}
