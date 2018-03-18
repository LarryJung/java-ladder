package codesquad.ladder.model;

public class Tracker {
    private int col;

    Tracker(int col) {
        this.col = col;
    }

    int colMoveInBody(int col, Line line) {
        int index = col;
        if (line.getPoint(index - 1)) col--;
        if (line.getPoint(index)) col++;
        return col;
    }

    int colMoveAtFirstFrame(int col, Line line) {
        if (line.getPoint(0)) col++;
        return col;
    }

    int colMoveAtLastFrame(int col, Line line) {
        if (line.getPoint(line.getPoints().size() - 1)) col--;
        return col;
    }

    public Tracker nextTrack(Line line) {
        try {
            return new Tracker(colMoveInBody(this.col, line));
        } catch (IndexOutOfBoundsException e) {
            if (this.col == 0) {
                return new Tracker(colMoveAtFirstFrame(this.col, line));
            }
            return new Tracker(colMoveAtLastFrame(this.col, line));
        }
    }

    public int getCol() {
        return col;
    }
}
