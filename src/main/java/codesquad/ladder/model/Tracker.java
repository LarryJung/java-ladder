package codesquad.ladder.model;

import java.util.Objects;

public class Tracker {
    private int col;
    private int row;
    private String direction;

    Tracker(int col) {
        this(col, 0, "down");
    }

    private Tracker(int col, int row, String direction) {
        this.col = col;
        this.row = row;
        this.direction = direction;
    }

    public Tracker nextTrack(Line line) {
        try {
        switch (this.direction){
            case "down":
                if (this.col == 0 && line.getPoint(this.col)) { moveRight(); break ;}
                if (this.col == 0 && !line.getPoint(this.col)) { moveDown(); break ;}
                if (line.getPoint(this.col - 1)) { moveLeft(); break ; }
                if (line.getPoint(this.col)) { moveRight(); break ; }
                if (!line.getPoint(this.col - 1) && !line.getPoint(this.col)) { moveDown(); break ; }
            case "left":
                if (this.col == 0 && !line.getPoint(this.col)) { moveDown(); break ;}
                if (line.getPoint(this.col -1)) { moveLeft(); break ; }
                if (line.getPoint(this.col -1)) { moveDown(); break ; }
            case "right":
                if (this.col == line.getPoints().size() && !line.getPoint(this.col - 1)) { moveDown(); break ;}
                if (line.getPoint(this.col)) { moveRight(); break ;}
                if (line.getPoint(this.col)) { moveDown(); break ; }
        }
        return new Tracker(this.col, this.row, this.direction);
        } catch (IndexOutOfBoundsException e) {
            switch (this.direction){
            case "down":
                if (this.col == 0 && line.getPoint(this.col)) { moveRight(); break ;}
                if (this.col == 0 && !line.getPoint(this.col)) { moveDown(); break ;}
                if (this.col == line.getPoints().size() && line.getPoint(this.col - 1)) { moveLeft(); break ;}
                if (this.col == line.getPoints().size() && !line.getPoint(this.col - 1)) { moveDown(); break ;}
            case "left":
                if (this.col == 0 && !line.getPoint(this.col)) { moveDown(); break ;}
            case "right":
                if (this.col == line.getPoints().size() && !line.getPoint(this.col - 1)) { moveDown(); break ;}
            }
            return new Tracker(this.col, this.row, this.direction);
        }
    }

    public int getCol() {
        return col;
    }

    private void moveLeft(){
        this.col--;
        this.direction = "left";
    }

    private void moveRight(){
        this.col++;
        this.direction = "right";
    }

    private void moveDown(){
        this.row++;
        this.direction = "down";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tracker) {
            Tracker tracker = (Tracker) o;
            return (col == tracker.col) && (row == tracker.row) && direction.equals(((Tracker) o).direction);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row, direction);
    }


}
