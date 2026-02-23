package baseball;

import io.ConsoleInputHandler;
import io.ConsoleOutputHandler;
import io.InputHandler;
import io.OutputHandler;

public class BaseBall{
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RandomNumber randomNumber;
    private String ranNum;
    private String userNum;

    public BaseBall(InputHandler inputHandler, OutputHandler outputHandler, RandomNumber randomNumber){
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.randomNumber = randomNumber;
        this.ranNum = randomNumber.makeRandomNumber();
    }

    public void run(){
        outputHandler.gameStartMessage();
        inputHandler.inputUserNum();
        Umpire umpire = new Umpire(ranNum, userNum);




    }

}
