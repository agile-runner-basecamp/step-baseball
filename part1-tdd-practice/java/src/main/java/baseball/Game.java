package baseball;

import java.util.Scanner;

public class Game {
    private final Judge judge;
    private final RandomGenerator generator;
    private final InputValidator in;
    private final OutputPrinter out;

    public Game(Judge judge, RandomGenerator randomGenerator, InputValidator in, OutputPrinter out) {
        this.judge = judge;
        this.generator = randomGenerator;
        this.in = in;
        this.out = out;
    }
    public void start(){
        do {
            play();
        }while (restart());
    }

    private void play() {
        int answer = generator.generate();

        boolean finished = false;

        while(!finished){
            out.printInputMessage();
            int input = in.inputHandler();
            int[] result = judge.makeCall(input, answer);

            int ball = result[0];
            int strike = result[1];

            out.printBallStrike(ball, strike);

            finished = isThreeStrike(strike);
        }
    }

    private boolean isThreeStrike(int strike) {
        return strike == 3;
    }

    private boolean restart() {
        out.printGameClear();
        int choice = in.readRestartChoice();
        return choice == 1;
    }
}
