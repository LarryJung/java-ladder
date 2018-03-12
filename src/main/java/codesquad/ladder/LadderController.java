package codesquad.ladder;

import codesquad.ladder.exceptions.InvalidNumPeopleException;
import codesquad.ladder.exceptions.InvalidSizeLadderException;

public class LadderController {

    private static final int MIN_SIZE_LADDER = 2;

    private static final int MIN_NMU_PEOPLE = 2;

    private Ladder ladder;

    public int numPeopleValidCheck(int numPeople) throws InvalidNumPeopleException {
        if (numPeople < MIN_NMU_PEOPLE) {
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

    public LadderController() {
        int numPeople = getNumPeople();
        int sizeLadder = getSizeLadder();
        this.ladder = new Ladder(numPeople, sizeLadder);
    }

    public void startGame() {
        ResultView.printLadder(this.ladder);
    }
}
