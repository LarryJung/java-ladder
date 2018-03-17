package codesquad.ladder.model;

import java.util.ArrayList;

public class Ladder {

    private ArrayList<Line> ladderForm;

    // 생성자1
    public Ladder(ArrayList<Line> ladderForm) {
        this.ladderForm = ladderForm;
    }

    // 생성자2
    public Ladder(int numPeople, int sizeLadder) {
        int numHorizonLine = numPeople - 1;
        this.ladderForm = makeLadderForm(numHorizonLine, sizeLadder);
    }

    // 사다리 크기 인자 받아서 라인 ArrayList 반환
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

    public int trace(int col) {
        Tracker tracker = new Tracker(col);
        for (Line line : this.ladderForm) {
            tracker = tracker.nextTrack(line);
        }
        return tracker.getCol();
    }
}