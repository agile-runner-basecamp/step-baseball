package baseball;

public class OutputPrinter {
    public void printInputMessage() {
        System.out.println("숫자를 입력해 주세요 : ");
    }

    public void printBallStrike(int ball, int strike) {

        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }

    public void printGameClear() {
        System.out.println("게임을 계속 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
