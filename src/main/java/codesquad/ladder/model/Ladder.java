package codesquad.ladder.model;

import java.util.ArrayList;

public class Ladder {

    private ArrayList<Line> ladderForm;

    public Ladder(int numPeople, int sizeLadder) {
        int numHorizonLine = numPeople - 1;
        this.ladderForm = makeLadderForm(numHorizonLine, sizeLadder);
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
}