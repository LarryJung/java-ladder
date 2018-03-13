package codesquad.ladder;

public class Ladder {

    private Line[] ladderForm;

    private int lineSize;

    public Ladder(int numPeople, int sizeLadder, int lineSize) {
        int numHorizonLine = numPeople - 1;
        this.ladderForm = makeLadderForm(numHorizonLine, sizeLadder);
        this.lineSize = lineSize;
    }

    private Line[] makeLadderForm(int numHorizonLine, int sizeLadder) {
        Line[] ladderForm = new Line[sizeLadder];
        for (int i = 0; i < sizeLadder; i++) {
            ladderForm[i] = new Line(numHorizonLine);
        }
        return ladderForm;
    }

    public Line[] getLadderForm() {
        return this.ladderForm;
    }

    public int getLineSize() {
        return this.lineSize;
    }
}