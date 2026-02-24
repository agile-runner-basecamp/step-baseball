package io;

public class ConsoleOutputHandler implements OutputHandler{
    @Override
    public void gameStartMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void gameScoreMessage(int strike, int ball){
        if(strike <= 0 && ball <= 0){System.out.printf("낫싱\n");}
        if(strike > 0 && ball > 0){System.out.printf("%d볼 %d스트라이크\n" ,ball ,strike);}
        if(strike <= 0 && ball > 0){System.out.printf("%d볼\n" ,ball);}
        if(strike > 0 && ball <= 0){System.out.printf("%d스트라이크\n",strike);}
    }

    public void gameCompleteMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    public void gameRestartMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public String showErrorMessage(){
       return "[ERROR] 숫자는 3자리여야 합니다.";
    }

}
