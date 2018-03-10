package codesquad.ladder;

import codesquad.ladder.exceptions.InvalidNumPeopleException;
import codesquad.ladder.exceptions.InvalidSizeLadderException;
import java.util.Scanner;

public class InputView {

    private static int NUM_PEOPLE;

    private static int SIZE_LADDER;

    private static final int MIN_PEOPLE_NUMBER = 2;

    private static final int MIN_LADDER_SIZE = 2;

    private static Scanner scanner = new Scanner(System.in);

    public static int getNumPeople(){
        try {
            System.out.println("사람은 몇 명 인가요? 2이상의 값을 입력해 주세요.\n>>");
            NUM_PEOPLE = Integer.parseInt(scanner.nextLine());
            if (NUM_PEOPLE < MIN_PEOPLE_NUMBER) {
                throw new InvalidNumPeopleException();
            }
        } catch (Exception e) {
            getNumPeople();
        }
        return NUM_PEOPLE;
    }

    public static int getSizeLadder(){
        try {
            System.out.println("사다리는 몇 개 인가요? 2이상의 값을 입력해 주세요.\n>>");
            SIZE_LADDER = Integer.parseInt(scanner.nextLine());
            if (SIZE_LADDER < MIN_LADDER_SIZE) {
                throw new InvalidSizeLadderException();
            }
        } catch (Exception e) {
            getSizeLadder();
        }
        return SIZE_LADDER;
    }
}

