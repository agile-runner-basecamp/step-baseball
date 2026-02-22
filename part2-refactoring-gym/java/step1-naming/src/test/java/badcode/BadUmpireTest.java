package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class BadUmpireTest {
    @DisplayName("테스트1")
    @Test
    void t1() {
        BadUmpire u = new BadUmpire();
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(1, 4, 5);
        int r = u.doS(a, b);
        assertThat(r).isEqualTo(1);
    }

    @DisplayName("테스트2")
    @Test
    void t2() {
        BadUmpire u = new BadUmpire();
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(1, 2, 3);
        int r = u.doS(a, b);
        assertThat(r).isEqualTo(3);
    }

    @DisplayName("테스트3")
    @Test
    void t3() {
        BadUmpire u = new BadUmpire();
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(3, 1, 2);
        int r = u.doB(a, b);
        assertThat(r).isEqualTo(3);
    }
}
