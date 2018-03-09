package codesquad.ladder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static boolean isInvalidInputNum(int num) {
        return num < 2;
    }

    private static Scanner scanner = new Scanner(System.in);

    public static int getNumPeople() {
        int numPeople = 1;
        System.out.println("시작 시 엔터를 눌러주세요.");
        while (isInvalidInputNum(numPeople)) {
            try {
                scanner.nextLine(); // this is about \n scanner error
                System.out.println("사람은 몇 명 인가요? 2이상의 값을 입력해 주세요.\n>>");
                numPeople = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자 값을 넣어주세요.");
            }
        }
        return numPeople;
    }

    public static int getNumLadder() {
        int numLadder = 1;
        while (isInvalidInputNum(numLadder)) {
            try {
                scanner.nextLine(); // this is about \n scanner error
                System.out.println("사다리는 몇 개 인가요? 2이상의 값을 입력해 주세요.\n>>");
                numLadder = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자 값을 넣어주세요.");
            }
        }
        return numLadder;
    }
}
