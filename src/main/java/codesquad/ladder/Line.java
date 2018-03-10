package codesquad.ladder;

public class Line {

    private boolean[] points;

    private static final int FIRST_INDEX = 0;

    private static final int ONE_BEFORE_INDEX = 1;

    public Line(int numHorizonLine) {
        this.points = makeLineAtHorizon(numHorizonLine);
    }

    private boolean[] makeLineAtHorizon(int numHorizonLine) {
        points = new boolean[numHorizonLine];
        for (int i = 0; i < numHorizonLine; i++) {
            points[i] = assignEachPoint(points, i);
        }
        return points;
    }

    private boolean assignEachPoint(boolean[] points, int index) {
        if (index == FIRST_INDEX) return LadderUtils.randomBoolean();
        return checkBeforeValue(points, index);
    }

    private boolean checkBeforeValue(boolean[] points, int index) {
        if (points[index - ONE_BEFORE_INDEX]) return false;
        return LadderUtils.randomBoolean();
    }

    public boolean[] getPoints() {
        return this.points;
    }
}