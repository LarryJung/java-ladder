package codesquad.ladder;

import java.util.ArrayList;

public class Line {

    private ArrayList<Boolean> points;

    private static final int FIRST_INDEX = 0;

    private static final int ONE_BEFORE_INDEX = 1;

    public Line(int numHorizonLine) {
        this.points = makeLineAtHorizon(numHorizonLine);
    }

    private ArrayList<Boolean> makeLineAtHorizon(int numHorizonLine) {
        points = new ArrayList<Boolean>(numHorizonLine);
        for (int i = 0; i < numHorizonLine; i++) {
            points.add(assignEachPoint(points, i));
        }
        return points;
    }

    private boolean assignEachPoint(ArrayList<Boolean> points, int index) {
        if (index == FIRST_INDEX) return LadderUtils.randomBoolean();
        return checkBeforeValue(points, index);
    }

    private boolean checkBeforeValue(ArrayList<Boolean> points, int index) {
        if (points.get(index - ONE_BEFORE_INDEX)) return false;
        return LadderUtils.randomBoolean();
    }

    public ArrayList<Boolean> getPoints() {
        return this.points;
    }
}