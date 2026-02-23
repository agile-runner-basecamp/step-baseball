package baseball;

public class Umpire {

    public int countStrike(BaseballNumber answer, BaseballNumber guess) {
        int strikeCount = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.digitAt(i) == guess.digitAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(BaseballNumber answer, BaseballNumber guess) {
        int ballCount = 0;
        for (int i = 0; i < answer.size(); i++) {
            int guessDigit = guess.digitAt(i);
            if (contains(answer, guessDigit) && answer.digitAt(i) != guessDigit) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public Judgement judge(BaseballNumber answer, BaseballNumber guess) {
        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);
        return new Judgement(strikeCount, ballCount);
    }

    private boolean contains(BaseballNumber answer, int targetDigit) {
        for (int i = 0; i < answer.size(); i++) {
            if (answer.digitAt(i) == targetDigit) {
                return true;
            }
        }
        return false;
    }
}
