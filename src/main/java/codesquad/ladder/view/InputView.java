package codesquad.ladder.view;

import java.util.*;

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

    public static String[] getString() {
        try {
            return scanner.nextLine().split(",");
        } catch (InputMismatchException e) {
            System.out.println("please put a string type");
            return null;
        }
    }


}