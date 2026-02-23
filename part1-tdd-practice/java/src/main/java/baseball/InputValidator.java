package baseball;

import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner = new Scanner(System.in);
    private final OutputPrinter out;

    public InputValidator(OutputPrinter out){
        this.out = out;
    }

    public int inputHandler(){
        while(true){
            Integer input = readIntOrNull();

            if(input == null) continue;

            try{
                validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                out.printError(e.getMessage());
            }
        }
    }

    public int readRestartChoice() {
        while(true){
            Integer input = readIntOrNull();

            if(input == null) continue;

            if(input == 1 || input == 2){
                return input;
            }

            out.printError("1 또는 2를 입력해주세요.");
        }
    }

    private Integer readIntOrNull(){
        if(!scanner.hasNextInt()){
            scanner.next();
            out.printError("숫자만 입력해주세요.");
            return null;
        }
        return scanner.nextInt();
    }

    private void validate(Integer input) {
        // 세자리 수 검증
        if(input < 100 || input > 999){
            throw new IllegalArgumentException("세자리 수를 입력해주세요.");
        }

        // 중복된 숫자 있는지 검증
        int a = input / 100;
        int b = (input / 10) % 10;
        int c = input % 10;

        if(a == b || a == c || b == c){
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.");
        }
    }
}
