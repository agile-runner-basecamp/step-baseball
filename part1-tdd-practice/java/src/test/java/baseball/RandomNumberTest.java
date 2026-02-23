package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @DisplayName("서로 다른 수(1~9)를 가진 세자릿 수의 자연수를 생성한다.")
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
