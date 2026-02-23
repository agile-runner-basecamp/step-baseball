package baseball;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String readInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }
}
