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
}
