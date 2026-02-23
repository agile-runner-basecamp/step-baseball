package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class UmpireTest {
    @DisplayName("같은 자리에 같은 수가 있으면 스트라이크 판정한다.")
    @Test
    void checkStrikeTest(){
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
    void checkBallTest(){
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


    @DisplayName("랜덤한 숫자와 사용자가 입력한 숫자간의 스트라이크 갯수를 센다.")
    @Test
    void countStrikeTest(){
        String ranNum = "123";
        String userNum = "124";

        Umpire umpire = new Umpire();

        int result = umpire.countStrike(ranNum, userNum);

        assertThat(result).isEqualTo(2);

    }

    @DisplayName("랜덤한 숫자와 사용자가 입력한 숫자간의 볼 갯수를 센다.")
    @Test
    void countBallTest(){
        String ranNum = "123";
        String userNum = "312";

        Umpire umpire = new Umpire();

        int result = umpire.countStrike(ranNum, userNum);

        assertThat(result).isEqualTo(0);

    }





}
