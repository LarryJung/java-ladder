package codesquad.ladder;

public class ResultView {

    private static final String LADDER_NAME = "## LADDER";

    private static final String FRAME = "|";

    private static final String LADDER_LINE = "-";

    private static final String LADDER_SPACE = " ";

    private static String ladderUnit(boolean isLine) {
        return (isLine) ? FRAME+LADDER_LINE : FRAME+LADDER_SPACE;
    }

    private static void printLadderUnit(String ladderUnit){
        System.out.printf(ladderUnit);
    }

    private static void printLadderHorizontal(boolean[] ladderOneLine) {
        for (int i = 0; i < ladderOneLine.length; i++) {
            printLadderUnit(ladderUnit(ladderOneLine[i]));
        }
        System.out.printf(FRAME);
    }

    public static void printLadder(Ladder ladder) {
        System.out.println();
        System.out.println(LADDER_NAME);
        for (int i = 0; i < ladder.getLadderForm().length; i++) {
            printLadderHorizontal(ladder.getLadderForm()[i].getPoints());
            System.out.println();
        }
    }
}
