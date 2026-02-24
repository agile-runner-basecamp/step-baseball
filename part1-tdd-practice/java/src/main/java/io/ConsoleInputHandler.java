package io;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    public static final Scanner SCANNER = new Scanner(System.in);
    public String inputUserNum(){
        String num = SCANNER.next();
        return num;
    }

    public String inputRestartNum(){
        String num = SCANNER.next();
        return num;
    }
}
