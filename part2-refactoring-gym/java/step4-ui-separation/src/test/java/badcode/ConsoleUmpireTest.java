package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

// TODO: 이 테스트 클래스를 어떻게 짜야 할지 막막할 것입니다!
// ConsoleUmpire 가 값을 반환하는 대신 화면에 출력(System.out)만 하고 있기 때문입니다.
// 이 코드를 리팩토링하여 반환값을 갖게 만들고, 아래에 정상적인 단언(assertThat)을 작성해 보세요.
class ConsoleUmpireTest {
    @DisplayName("출력(System.out)에 의존하는 코드는 테스트하기 어렵다")
    @Test
    void cannotTestConsoleOutput() {
        ConsoleUmpire umpire = new ConsoleUmpire();
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(1, 4, 5);

        // 실행은 되지만 결과를 검증할 방법이 없습니다!
        umpire.play(answer, guess);

        // TODO: 아래와 비슷한 검증이 가능해지도록 콘솔 로직을 걷어내세요.
        // String result = umpire.judge(answer, guess);
        // assertThat(result).isEqualTo("1스트라이크");
    }
}
