package badcode;

import java.util.List;

public class ConsoleUmpire {

    private final OutputHandler out;
    private final OutputPrinter printer;

    public ConsoleUmpire(OutputHandler out, OutputPrinter printer){
        this.out = out;
        this.printer = printer;
    }

    public void play(List<Integer> answer, List<Integer> guess) {
        if (validate(answer, guess)) return;

        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);

        String result = out.printResult(strikeCount, ballCount);
        printer.print(result);
    }

    private boolean validate(List<Integer> answer, List<Integer> guess) {
        if (answer.size() != 3 || guess.size() != 3) {
            String str = out.printErrorMessage();
            printer.print(str);
            throw new IllegalArgumentException(str);
        }
        return false;
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

}
