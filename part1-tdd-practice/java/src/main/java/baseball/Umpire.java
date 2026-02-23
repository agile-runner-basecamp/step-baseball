package baseball;

public class Umpire {
    public int checkStrike(String ranNum, String userNum, int i){
        int same = 0;
        if(ranNum.charAt(i) == userNum.charAt(i)){
            same = 1;
            return same;
        }
        return same;
    }

}
