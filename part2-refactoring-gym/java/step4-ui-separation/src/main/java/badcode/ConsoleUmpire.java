package badcode;

public class ConsoleUmpire {

    public int[] judge(Numbers answer, Numbers guess) {
        int strikeCount = answer.countStrike(guess);
        int ballCount = answer.countBall(guess);

        return new int[]{strikeCount, ballCount};
    }
}
