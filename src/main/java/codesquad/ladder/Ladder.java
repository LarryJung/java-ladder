package codesquad.ladder;

public class Ladder {
    private int numPeople;
    private Line[] ladderForm;

    public Ladder(int numPeople, int numLadder) {
        this.ladderForm = makeLadderForm(numPeople-1, numLadder);
        this.numPeople = numPeople;
    }

    private Line[] makeLadderForm(int numHorizonLine, int numLadder) {
        Line[] ladderForm = new Line[numLadder];
        for (int i = 0; i < numLadder; i++) {
            ladderForm[i] = new Line(numHorizonLine);
        }
        return ladderForm;
    }

    public Line[] getLadderForm() {
        return this.ladderForm;
    }
}