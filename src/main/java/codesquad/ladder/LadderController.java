package codesquad.ladder;

import codesquad.ladder.exceptions.InvalidNumPeopleException;
import codesquad.ladder.exceptions.InvalidSizeLadderException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderController {

    private static final int MIN_SIZE_LADDER = 2;

    private static final int MIN_NUM_PEOPLE = 2;

    private Ladder ladder;

    private Player player;

    public LadderController() {
        int numPeople = getNumPeople();
        int sizeLadder = getSizeLadder();
        this.ladder = new Ladder(numPeople, sizeLadder);
    }

    public int numPeopleValidCheck(int numPeople) throws InvalidNumPeopleException {
        if (numPeople < MIN_NUM_PEOPLE) {
            throw new InvalidNumPeopleException();
        } return numPeople;
    }

    public int sizeLadderValidCheck(int sizeLadder) throws InvalidSizeLadderException {
        if (sizeLadder < MIN_SIZE_LADDER) {
            throw new InvalidSizeLadderException();
        } return sizeLadder;
    }

    public int getNumPeople(){
        System.out.println("Put number of people\n>>");
        try {
            return numPeopleValidCheck(InputView.getNumber());
        } catch (Exception e){
            System.out.println("number of people must be over 2. try again");
            return getNumPeople();
        }
    }

    public int getSizeLadder(){
        System.out.println("Put size of Ladder\n>>");
        try {
            return sizeLadderValidCheck(InputView.getNumber());
        } catch (Exception e){
            System.out.println("size of ladder must be over 2. try again");
            return getSizeLadder();
        }
    }

    private static void eachNameCheck(String str, List<String> list){
        if (!list.contains(str)) {
            list.add(str);
        }
    }

    private static boolean nameCheck(String[] names) {
        List<String> setlist = new ArrayList<String>();
        List<String> list = new ArrayList<String>(Arrays.asList(names));

        for (String str : list) {
            eachNameCheck(str, setlist);
        }
        return (setlist.size() == list.size());
    }

    public void startGame() {
        ResultView.printLadder(this.ladder);
    }
}
