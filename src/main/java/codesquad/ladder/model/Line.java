package codesquad.ladder.model;

import codesquad.ladder.controller.LadderUtils;

import java.util.ArrayList;

public class Line {

    private ArrayList<Boolean> points;

    private static final int FIRST_INDEX = 0;

    private static final int ONE_BEFORE_INDEX = 1;

    // 생성자 1
    public Line (ArrayList<Boolean> points) { this.points = points; }
    // 생성자 2
    public Line(int numHorizonLine) {
        this.points = makeLineAtHorizon(numHorizonLine);
    }

    // 한 줄 블리언 배열 반환
    private ArrayList<Boolean> makeLineAtHorizon(int numHorizonLine) {
        points = new ArrayList<Boolean>(numHorizonLine);
        for (int i = 0; i < numHorizonLine; i++) {
            points.add(assignEachPoint(points, i));
        }
        return points;
    }

    // 블리언 하나 할당
    private static boolean assignEachPoint(ArrayList<Boolean> points, int index) {
        if (index == FIRST_INDEX) return LadderUtils.randomBoolean();
        return checkBeforeValueAndReturn(points, index);
    }

    // 왼쪽 1칸 전 값 확인 후 값 할당
    private static boolean checkBeforeValueAndReturn(ArrayList<Boolean> points, int index) {
        if (isBeforeValueTrue(points, index)) return false;
        return LadderUtils.randomBoolean();
    }

    // 왼쪽 1칸 전 값이 true인지 false인지 확인
    static boolean isBeforeValueTrue(ArrayList<Boolean> points, int index) {
        if (points.get(index - ONE_BEFORE_INDEX)) return true;
        return false;
    }

    public ArrayList<Boolean> getPoints() {
        return this.points;
    }

    public boolean getPoint(int i) {
        return points.get(i);
    }
}