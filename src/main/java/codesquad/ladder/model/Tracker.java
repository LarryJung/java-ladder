package codesquad.ladder.model;

import java.util.Objects;

public class Tracker {
    private int col;

    Tracker(int col) {
        this.col = col;
    }

    private int colMoveInBody(int col, Line line) {
        int index = col;
        if (line.getPoint(index - 1)) col--;
        if (line.getPoint(index)) col++;
        return col;
    }

    private int colMoveAtFirstFrame(Line line) {
        if (line.getPoint(0)) col++;
        return col;
    }

    private int colMoveAtLastFrame(Line line) {
        if (line.getPoint(line.getPoints().size() - 1)) col--;
        return col;
    }

    public Tracker nextTrack(Line line) {
        try {
            return new Tracker(colMoveInBody(this.col, line));
        } catch (IndexOutOfBoundsException e) {
            if (this.col == 0) {
                return new Tracker(colMoveAtFirstFrame(line));
            }
            return new Tracker(colMoveAtLastFrame(line));
        }
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tracker) {
            Tracker tracker = (Tracker) o;
            return (col == tracker.col);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col);
    }
}
