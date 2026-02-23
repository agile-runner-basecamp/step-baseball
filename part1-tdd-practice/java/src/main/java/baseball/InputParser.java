package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char number : input.toCharArray()) {
            numbers.add(number - '0');
        }
        return numbers;
    }
}
