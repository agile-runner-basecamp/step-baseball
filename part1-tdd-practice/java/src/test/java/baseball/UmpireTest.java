package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UmpireTest {
    @DisplayName("같은 자리에 같은 수가 있으면 스트라이크 판정한다.")
    @Test
    void judgeStrike(){
        // given
        String ranNum = "486";
        String userNum = "497";
        int index = 0;

        Umpire umpire = new Umpire();

        // when
        int result = umpire.checkStrike(ranNum, userNum, index);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("자릿수만 다르고 같은 숫자가 있다면 볼 판정한다.")
    @Test
    void judgeBall(){
        // given
        String ranNum = "123";
        String userNum = "123";
        int index = 1;

        Umpire umpire = new Umpire();

        // when
        int result = umpire.checkBall(ranNum, userNum, index);

        // then
        assertThat(result).isEqualTo(0);
    }

}
