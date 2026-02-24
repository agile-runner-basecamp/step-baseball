package badcode;

import io.InputHandler;
import io.OutputHandler;

import java.util.List;

public class ConsoleUmpire {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public ConsoleUmpire(InputHandler inputHandler, OutputHandler outputHandler){
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }
    public void play(List<Integer> answer, List<Integer> guess) {
        if (answer.size() != 3 || guess.size() != 3) {
            throw new IllegalArgumentException(outputHandler.showErrorMessage());
        }

        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);

        outputHandler.gameScoreMessage(strikeCount, ballCount);
    }

    private int countStrike(List<Integer> answer, List<Integer> guess) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Integer> answer, List<Integer> guess) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && answer.get(i).equals(guess.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private void printResult(int strikeCount, int ballCount) {
        outputHandler.gameScoreMessage(strikeCount, ballCount);
        if (strikeCount == 3) {
            outputHandler.gameCompleteMessage();
            return;
        }
    }
}
