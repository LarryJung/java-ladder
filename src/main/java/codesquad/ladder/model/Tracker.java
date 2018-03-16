package codesquad.ladder.model;

public class Tracker {

    private int row; // row number
    private int col; // column number
    private String direction;

    public Tracker(int col) {
        this.col = col;
        this.row = 0; // initialize
        this.direction = "down"; // initialize
    }

    public void move(Ladder ladder) {
        Mover mover = new Mover(this.row, this.col, this.direction);
        while (this.row < ladder.getLadderForm().get(1).getPoints().size()) {
            try {
                mover.oneStepMove(ladder);
                this.row = mover.getRow();
                this.col = mover.getCol();
                this.direction = mover.getDirection();
            } catch (IndexOutOfBoundsException e) {
                mover.directionSwitchAndMove(ladder);
                this.row = mover.getRow();
                this.col = mover.getCol();
                this.direction = mover.getDirection();
            }
        }
    }

    public int getCol() {
        return this.col;
    }

    /* I want to use like this.
    Tracker tracker = new Tracker(initialize);
    tracker.move(ladder);
    int result = tracker.getCol();
    * */
}
