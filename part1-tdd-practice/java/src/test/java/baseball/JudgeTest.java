package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {
    @DisplayName("스트라이크, 볼을 판단하는 로직입니다.")
    @Test
    void countStrike(){
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 2, 3};

        Judge judge = new Judge();

        int strike = judge.countStrike(a, b);
        assertEquals(3, strike);
    }

    @Test
    void countBall(){
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 2, 3};

        Judge judge = new Judge();

        int ball = judge.countBall(a, b);
        assertEquals(0, ball);
    }
}