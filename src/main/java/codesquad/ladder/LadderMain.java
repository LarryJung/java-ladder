package codesquad.ladder;

public class LadderMain {
    public static void main(String[] args) {
        int numPeople = InputView.getNumPeople();
        int numLadder = InputView.getNumLadder();

        Ladder ladder = new Ladder(numPeople, numLadder);
        ResultView.printLadder(ladder);
    }
}