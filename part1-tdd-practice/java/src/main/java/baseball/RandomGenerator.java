package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {
    private final Random random;

    public RandomGenerator(Random random){
        this.random = random;
    }

    public int generate(){
        Set<Integer> numbers = new HashSet<>();

        while(numbers.size() < 3){
            numbers.add(random.nextInt(9)+1);
        }

        // 세자리 숫자로 생성
        int result = 0;
        for(int n : numbers){
            result = result * 10 + n;
        }

        return result;
    }
}
