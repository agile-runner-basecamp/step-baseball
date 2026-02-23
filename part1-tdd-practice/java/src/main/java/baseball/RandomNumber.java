package baseball;

import java.util.HashSet;
import java.util.Random;

public class RandomNumber {
    public String makeRandomNumber(){
        String ranNum = "";
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();

        while(set.size() < 3){
            set.add(random.nextInt(9)+1);
        }

        for(Integer num : set){
            ranNum += Integer.toString(num);
        }

        return ranNum;
    }
}
