package codesquad.ladder;

public class ResultView {

    private static void printLadderUnit(boolean isLine) {
        if (isLine) {
            System.out.printf("|-");
        } else {
            System.out.printf("| ");
        }
    }

    private static void printLadderHorizontal(boolean[] ladderOneLine) {
        for (int i = 0; i < ladderOneLine.length; i++) {
            printLadderUnit(ladderOneLine[i]);
        }
        System.out.printf("|");
    }

    public static void printLadder(Ladder ladder) {
        System.out.println();
        System.out.println("## LADDER ");
        for (int i = 0; i < ladder.getLadderForm().length; i++) {
            printLadderHorizontal(ladder.getLadderForm()[i].getPoints());
            System.out.println();
        }
    }
}
