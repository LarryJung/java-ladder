package codesquad.ladder;

public class Ladder {
    private int numPeople;
    private int numLadder;

    public Ladder(int numPeople, int numLadder) {
        this.numPeople = numPeople;
        this.numLadder = numLadder;
    }

    private boolean[][] makeLadderForm(int numHorizonLine, int numLadder) {
        boolean[][] ladderForm = new boolean[numLadder][numHorizonLine];
        for (int i = 0; i < numLadder; i++) {
            Line line = new Line(numHorizonLine);
            ladderForm[i] = line.getPoints();
        } return ladderForm;
    }

    public boolean[][] getLadderForm() {
        return makeLadderForm(this.numPeople-1, this.numLadder);
    }

}