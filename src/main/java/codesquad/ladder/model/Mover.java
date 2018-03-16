package codesquad.ladder.model;

public class Mover {

    private int row;
    private int col;
    private String direction;

    public Mover(int row, int col, String direction){
        this.row = row;
        this.col = col;
        this.direction = direction;
    }

    public void oneStepMove(Ladder ladder) {
        switch (this.direction){
            case "down":
                if (ladder.getLadderValue(this.row, this.col - 1)) { this.col--; this.direction = "left"; break; }
                if (ladder.getLadderValue(this.row, this.col)) { this.col++; this.direction = "right"; break; }
                if (ladder.getLadderValue(this.row, this.col - 1) && ladder.getLadderValue(this.row, this.col)) { this.row++; this.direction = "down"; break; }

            case "left":
                if (ladder.getLadderValue(this.row, this.col - 1)) { this.col--; this.direction = "left"; break; }
                if (!ladder.getLadderValue(this.row, this.col - 1)) { this.row++; this.direction = "down"; break; }

            case "right":
                if (ladder.getLadderValue(this.row, this.col)) { this.col++; direction = "right"; break; }
                if (!ladder.getLadderValue(this.row, this.col)) { this.row++; direction = "down"; break; }
        }
    }

    public void directionSwitchAndMove(Ladder ladder) {
        int maxRightIndex = ladder.getLadderForm().get(1).getPoints().size();
        switch (this.direction){
            case "down":
                if (this.col == 0 && ladder.getLadderValue(this.row, this.col)) { this.col++; this.direction = "right"; break; }
                if (this.col == 0 && !ladder.getLadderValue(this.row, this.col)) { row++; this.direction = "down"; break; }
                if (this.col == maxRightIndex && ladder.getLadderValue(row, this.col - 1)) { this.col--; this.direction = "left"; break; }
                if (this.col == maxRightIndex && !ladder.getLadderValue(row, this.col - 1)) { this.row++; this.direction = "down"; break; }

            case "left":
                if (this.col == 0) { this.row++; this.direction = "down"; break; }

            case "right":
                if (this.col == maxRightIndex) { this.row++; this.direction = "down"; break; }
        }
    }

    public int getRow() {
        return this.row;
    }

    public String getDirection() {
        return this.direction;
    }

    public int getCol() {
        return this.col;
    }
}
