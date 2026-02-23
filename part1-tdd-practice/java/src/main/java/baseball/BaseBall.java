package baseball;

import io.ConsoleInputHandler;
import io.ConsoleOutputHandler;
import io.InputHandler;
import io.OutputHandler;

public class BaseBall{
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RandomNumber randomNumber;
    public BaseBall(InputHandler inputHandler, OutputHandler outputHandler, RandomNumber randomNumber){
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.randomNumber = randomNumber;
    }

    public void run(){

        outputHandler.gameStartMessage();
        String ranNum = randomNumber.makeRandomNumber();

        while(true){
            String userNum = inputHandler.inputUserNum();

            Umpire umpire = new Umpire(ranNum, userNum);
            int strike = umpire.countStrike();
            int ball = umpire.countBall();

            outputHandler.gameScoreMessage(strike, ball);

            if(strike != 3) continue;
            outputHandler.gameCompleteMessage();

            String restartNum = inputHandler.inputRestartNum();

            if(restartNum == "1"){
                ranNum = randomNumber.makeRandomNumber();
                continue;
            }

            if(restartNum == "2"){
                outputHandler.gameCompleteMessage();
                return;
            }



        }







    }

}
