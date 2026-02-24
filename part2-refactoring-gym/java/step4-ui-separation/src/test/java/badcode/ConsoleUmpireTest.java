package badcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

// TODO: 이 테스트 클래스를 어떻게 짜야 할지 막막할 것입니다!
// ConsoleUmpire 가 값을 반환하는 대신 화면에 출력(System.out)만 하고 있기 때문입니다.
// 이 코드를 리팩토링하여 반환값을 갖게 만들고, 아래에 정상적인 단언(assertThat)을 작성해 보세요.
class ConsoleUmpireTest {
    @DisplayName("play 함수 입력값이 3자리가 아니면 예외 발생하는지 검증")
    @Test
    void play_exception_test() {
        OutputPrinter printer = new OutputPrinter();
        OutputHandler out = new OutputHandler();
        ConsoleUmpire umpire = new ConsoleUmpire(out, printer);

        List<Integer> answer = List.of(1, 2);
        List<Integer> guess = List.of(1, 4, 5);

        //void인 play를 검증할 수 있는 방법 : 예외 처리가 잘 동작하는지 확인
        assertThrows(IllegalArgumentException.class, () -> {
            umpire.play(answer, guess);
        });
    }
}
