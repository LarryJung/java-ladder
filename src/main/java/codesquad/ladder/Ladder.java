package codesquad.ladder;

public class Ladder {

    private Line[] ladderForm;

    public Ladder(int numPeople, int sizeLadder) {
        int numHorizonLine = numPeople - 1;
        this.ladderForm = makeLadderForm(numHorizonLine, sizeLadder);
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
}