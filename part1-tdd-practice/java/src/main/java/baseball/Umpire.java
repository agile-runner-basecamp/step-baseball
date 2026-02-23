package baseball;

public class Umpire {
    public int checkStrike(String ranNum, String userNum, int i){
        int check = 0;
        if(ranNum.charAt(i) == userNum.charAt(i)){
            check = 1;
        }
        return check;
    }

    public int checkBall(String ranNum, String userNum, int i){
        int check = 0;
        if((ranNum.charAt(i) != userNum.charAt(i)) && ranNum.contains(String.valueOf(userNum.charAt(i)))){
            check = 1;
        }
        return check;
    }


}
