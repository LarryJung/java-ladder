package codesquad.ladder;

import java.util.ArrayList;

public class Ladder {

    private ArrayList<Line> ladderForm;

    private int lineHorizonLength;

    public Ladder(int numPeople, int sizeLadder, int lineHorizonLength) {
        int numHorizonLine = numPeople - 1;
        this.ladderForm = makeLadderForm(numHorizonLine, sizeLadder);
        this.lineHorizonLength = lineHorizonLength;
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

    public int getLineHorizonLength() {
        return this.lineHorizonLength;
    }
}