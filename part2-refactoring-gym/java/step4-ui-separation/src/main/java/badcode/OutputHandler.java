package badcode;

public class OutputHandler {
    // 출력할 메시지 생성
    public String printResult(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();

        if (ballCount > 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }

        return sb.toString().trim();
    }

    public String printErrorMessage() {
        return "[ERROR] 숫자는 3자리여야 합니다.";
    }
}
