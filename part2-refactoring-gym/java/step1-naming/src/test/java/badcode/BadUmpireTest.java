package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class BadUmpireTest {
    @DisplayName("같은 자리에 같은 수가 존재하면 스트라이크다.")
    @Test
    void doStrike() {
        BadUmpire u = new BadUmpire();
        List<Integer> ranNum = List.of(1, 2, 3);
        List<Integer> userNum = List.of(1, 4, 5);
        int result = u.countStrike(ranNum, userNum);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("랜덤 한 세자리의 숫자와 사용자가 입력한 숫자가 같으면 3스트라이크다.")
    @Test
    void doAllStrike() {
        BadUmpire u = new BadUmpire();
        List<Integer> ranNum = List.of(1, 2, 3);
        List<Integer> userNum = List.of(1, 2, 3);
        int result = u.countStrike(ranNum, userNum);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("랜덤한 숫자에 포함된 숫자지만 다른 자리에 존재할 경우 볼이다.")
    @Test
    void doAllBall() {
        BadUmpire u = new BadUmpire();
        List<Integer> ranNum = List.of(1, 2, 3);
        List<Integer> userNum = List.of(3, 1, 2);
        int result = u.countBall(ranNum, userNum);
        assertThat(result).isEqualTo(3);
    }
}
