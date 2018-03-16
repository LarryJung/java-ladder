package codesquad.ladder.controller;
import codesquad.ladder.model.Ladder;

public class LadderUtils {

    public static boolean randomBoolean() {
        return (Math.random() < 0.5) ? false : true;
    }

    public static int findLadderResult(int col, Ladder ladder){
        int row = 0;
        String direction = "down"; // initialize
        int maxRightIndex = ladder.getLadderForm().get(1).getPoints().size();
        while (row < ladder.getLadderForm().size()) {
            switch (direction) {
                case "down":
                    if (col == 0 && ladder.getLadderValue(row, col)) { col++; direction = "right"; break; }
                    if (col == 0 && !ladder.getLadderValue(row, col)) { row++; direction = "down"; break; }
                    if (col == maxRightIndex && ladder.getLadderValue(row, col - 1)) { col--; direction = "left"; break; }
                    if (col == maxRightIndex && !ladder.getLadderValue(row, col - 1)) { row++; direction = "down"; break; }
                    if (ladder.getLadderValue(row, col - 1)) { col--; direction = "left"; break; }
                    if (ladder.getLadderValue(row, col)) { col++; direction = "right"; break; }
                    if (ladder.getLadderValue(row, col - 1) && ladder.getLadderValue(row, col)) { row++; direction = "down"; break; }

                case "left":
                    if (col == 0) { row++; direction = "down"; break; }
                    if (ladder.getLadderValue(row, col - 1)) { col--; direction = "left"; break; }
                    if (!ladder.getLadderValue(row, col - 1)) { row++; direction = "down"; break; }

                case "right":
                    if (col == maxRightIndex) { row++; direction = "down"; break; }
                    if (ladder.getLadderValue(row, col)) { col++; direction = "right"; break; }
                    if (!ladder.getLadderValue(row, col)) { row++; direction = "down"; break; }
            }
        }
        return col;
    }
}
