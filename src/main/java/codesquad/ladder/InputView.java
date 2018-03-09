package codesquad.ladder;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int getNumPeople() {
        System.out.println("사람은 몇 명 인가요? >> ");
        return scanner.nextInt();
    }

    public static int getNumLadder() {
        System.out.println("사다리는 몇 개 인가요? >> ");
        return scanner.nextInt();
    }
}