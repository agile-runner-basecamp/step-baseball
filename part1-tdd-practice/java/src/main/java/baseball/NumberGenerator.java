package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public List<Integer> generate() {
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            candidates.add(i);
        }
        Collections.shuffle(candidates);
        return candidates.subList(0, 3);
    }
}
