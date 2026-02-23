package baseball;

import java.util.List;

public class GameController {
    private final NumberGenerator numberGenerator;
    private final Game game;
    private final InputView inputView;
    private final ResultView resultView;
    private final List<Integer> answer;

    public GameController(NumberGenerator numberGenerator, Game game, InputView inputView, ResultView resultView) {
        this.numberGenerator = numberGenerator;
        this.game = game;
        this.inputView = inputView;
        this.resultView = resultView;
        this.answer = this.numberGenerator.generate();
    }

    public void run() {
        boolean finished = false;
        while (!finished) {
            String input = inputView.readInput();
            finished = playOneTurn(input);
        }
    }

    private boolean playOneTurn(String input) {
        try {
            TurnResult turnResult = game.playTurnWithStatus(answer, input);
            return handleTurnResult(turnResult);
        } catch (IllegalArgumentException exception) {
            resultView.printErrorMessage(exception);
            return false;
        }
    }

    private boolean handleTurnResult(TurnResult turnResult) {
        resultView.printTurnResult(turnResult);
        if (!turnResult.end()) {
            return false;
        }
        resultView.printGameEndMessage();
        return true;
    }
}
