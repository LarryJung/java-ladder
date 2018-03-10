package codesquad.ladder;

public class LadderMain {
    public static void main(String[] args) {
        int numPeople = InputView.getNumPeople();
        int sizeLadder = InputView.getSizeLadder();

        Ladder ladder = new Ladder(numPeople, sizeLadder);
        ResultView.printLadder(ladder);
    }
}