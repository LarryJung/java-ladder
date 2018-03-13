package codesquad.ladder;

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


    private static String getString(){
        try {
            System.out.println("사용자의 이름을 입력해 주세요.(구분자 ,)");
            return scanner.nextLine();
        } catch (InputMismatchException e){
            System.out.println("please put a string type");
        } return "";
    }


}