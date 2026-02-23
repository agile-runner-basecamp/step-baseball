package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @DisplayName("입력 문자열을 숫자 리스트로 변환한다")
    @Test
    void parse() {
        // given
        InputParser inputParser = new InputParser();

        // when
        List<Integer> result = inputParser.parse("123");

        // then
        assertThat(result).isEqualTo(List.of(1, 2, 3));
    }
}
