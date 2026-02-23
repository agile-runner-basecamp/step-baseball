package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

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

    @DisplayName("자릿수만 다르고 같은 숫자가 있다면 볼 판정한다.")
    @Test
    void makeRandomNum(){
        // given
        RandomNumber randomNumber = new RandomNumber();

        // when
        String result = randomNumber.makeRandomNumber();

        // then

        // 세자릿 수 인지
        assertThat(result).hasSize(3);

        // 1~9까지의 숫자인지
        assertThat(result).matches("[1-9]{3}");

        // 서로 다른 숫자인지
        assertThat(result.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toSet()))
                .hasSize(3);


    }

}
