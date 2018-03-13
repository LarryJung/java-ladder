package codesquad.ladder;

import java.util.ArrayList;

public class Ladder {

    private ArrayList<Line> ladderForm;

    private int lineSize;

    public Ladder(int numPeople, int sizeLadder, int lineSize) {
        int numHorizonLine = numPeople - 1;
        this.ladderForm = makeLadderForm(numHorizonLine, sizeLadder);
        this.lineSize = lineSize;
    }

    private ArrayList<Line> makeLadderForm(int numHorizonLine, int sizeLadder) {
        ArrayList<Line> ladderForm = new ArrayList<Line>(sizeLadder);
        for (int i = 0; i < sizeLadder; i++) {
            ladderForm.add(new Line(numHorizonLine));
        }
        return ladderForm;
    }

    public ArrayList<Line> getLadderForm() {
        return this.ladderForm;
    }

    public int getLineSize() {
        return this.lineSize;
    }
}