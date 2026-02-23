package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @DisplayName("3자리 숫자를 생성한다")
    @Test
    void generateThreeNumbers() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when
        List<Integer> numbers = numberGenerator.generate();

        // then
        assertThat(numbers).hasSize(3);
    }
}
