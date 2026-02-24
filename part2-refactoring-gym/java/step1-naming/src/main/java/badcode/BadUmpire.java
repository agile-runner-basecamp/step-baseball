package badcode;

import java.util.List;

public class BadUmpire {

    public static final int NUMBER_SIZE = 3;

    public int countStrike(List<Integer> ranNum, List<Integer> userNum) {
        int check = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (ranNum.get(i).equals(userNum.get(i))) {
                check++;
            }
        }
        return check;
    }

    public int countBall(List<Integer> ranNum, List<Integer> userNum) {
        int check = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            for (int j = 0; j < NUMBER_SIZE; j++) {
                if (i != j && ranNum.get(i).equals(userNum.get(j))) {
                    check++;
                }
            }
        }
        return check;
    }
}
