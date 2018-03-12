package codesquad.ladder;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int getNumber() {
        try {
            int number = Integer.parseInt(scanner.nextLine());
            return number;
        } catch (Exception e) {
            System.out.println("Input must be integer. try again");
            return getNumber();
        }
    }
}