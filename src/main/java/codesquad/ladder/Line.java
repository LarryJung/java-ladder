package codesquad.ladder;

public class Line {

    private boolean[] points;

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
        if (index == 0) return LadderUtils.randomBoolean();
        return checkBeforeValue(points, index);
    }

    private boolean checkBeforeValue(boolean[] points, int index) {
        if (points[index - 1]) return false;
        return LadderUtils.randomBoolean();
    }

    public boolean[] getPoints() {
        return this.points;
    }
}