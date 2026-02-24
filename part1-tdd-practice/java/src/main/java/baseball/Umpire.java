package baseball;

public class Umpire {
    private String ranNum;
    private String userNum;
    public Umpire(String ranNum, String userNum){
        this.ranNum = ranNum;
        this.userNum = userNum;
    }

    public int checkStrike(int i){
        int check = 0;
        if(ranNum.charAt(i) == userNum.charAt(i)){
            check = 1;
        }
        return check;
    }

    public int checkBall(int i){
        int check = 0;
        if((ranNum.charAt(i) != userNum.charAt(i)) && ranNum.contains(String.valueOf(userNum.charAt(i)))){
            check = 1;
        }
        return check;
    }

    public int countStrike(){
        int count = 0;
        for(int i = 0; i < 3; i++){
            count += checkStrike(i);
        }
        return count;
    }

    public int countBall(){
        int count = 0;
        for(int i = 0; i < 3; i++){
            count += checkBall(i);
        }
        return count;
    }



}
