package baseball;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new NumberGenerator(),
                new Game(),
                new InputView(),
                new ResultView()
        );
        gameController.run();
    }
}
