package baseball;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        OutputPrinter out = new OutputPrinter();
        Random random = new Random();

        Game game = new Game(
                new Judge(), new RandomGenerator(random),
                new InputValidator(out), new OutputPrinter());

        game.start();
    }
}
