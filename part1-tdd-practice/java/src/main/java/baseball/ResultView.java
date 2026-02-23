package baseball;

public class ResultView {
    public void printTurnResult(TurnResult turnResult) {
        System.out.println(turnResult.result());
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
