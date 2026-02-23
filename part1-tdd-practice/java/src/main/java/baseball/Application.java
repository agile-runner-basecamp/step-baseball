package baseball;

import io.ConsoleInputHandler;
import io.ConsoleOutputHandler;
import io.InputHandler;
import io.OutputHandler;

public class Application {
    public static void main(String[] args){
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        RandomNumber randomNumber = new RandomNumber();

        BaseBall baseBall = new BaseBall(inputHandler, outputHandler, randomNumber);
        baseBall.run();
    }
}
