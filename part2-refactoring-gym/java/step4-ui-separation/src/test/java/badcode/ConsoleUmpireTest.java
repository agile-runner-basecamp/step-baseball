package badcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class ConsoleUmpireTest {
    @DisplayName("1스트라이크일 때 1스트라이크를 반환한다")
    @Test
    void returnsOneStrikeMessage() {
        ConsoleUmpire umpire = new ConsoleUmpire();
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(1, 4, 5);

        String result = umpire.judge(answer, guess);

        assertThat(result).isEqualTo("1스트라이크");
    }

    @DisplayName("3스트라이크면 게임 종료 메시지를 포함한다")
    @Test
    void returnsGameEndMessageWhenThreeStrike() {
        ConsoleUmpire umpire = new ConsoleUmpire();
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(1, 2, 3);

        String result = umpire.judge(answer, guess);

        assertThat(result).contains("3스트라이크");
        assertThat(result).contains("게임 종료");
    }

    @DisplayName("0볼 0스트라이크일 때 낫싱을 반환한다")
    @Test
    void returnsNothingWhenNoBallNoStrike() {
        ConsoleUmpire umpire = new ConsoleUmpire();
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(4, 5, 6);

        String result = umpire.judge(answer, guess);

        assertThat(result).isEqualTo("낫싱");
    }

    @DisplayName("1볼 1스트라이크일 때 형식에 맞게 반환한다")
    @Test
    void returnsOneBallOneStrikeMessage() {
        ConsoleUmpire umpire = new ConsoleUmpire();
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(1, 3, 5);

        String result = umpire.judge(answer, guess);

        assertThat(result).isEqualTo("1볼 1스트라이크");
    }
}
