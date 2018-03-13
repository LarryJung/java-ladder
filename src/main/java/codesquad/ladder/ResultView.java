package codesquad.ladder;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final int NAME_SIZE_CORRECTION = 1;

    private static final String FRAME = "|";

    private static final String LADDER_LINE_UNIT = "-";

    private static final String LADDER_SPACE_UNIT = " ";

    private static String ladderUnit(Ladder ladder, boolean isLine) {
        String ladderLine = IntStream.range(0, ladder.getLineHorizonLength()).mapToObj(i -> LADDER_LINE_UNIT).collect(Collectors.joining(""));
        String ladderSpace = IntStream.range(0, ladder.getLineHorizonLength()).mapToObj(i -> LADDER_SPACE_UNIT).collect(Collectors.joining(""));
        return (isLine) ? FRAME + ladderLine : FRAME + ladderSpace;
    }

    private static void printLadderUnit(String ladderUnit) {
        System.out.printf(ladderUnit);
    }

    private static void printLadderHorizontal(Ladder ladder, ArrayList<Boolean> ladderOneLine) {
        for (int i = 0; i < ladderOneLine.size(); i++) {
            printLadderUnit(ladderUnit(ladder, ladderOneLine.get(i)));
        }
        System.out.printf(FRAME);
    }

    private static void printPlayerNames(LadderController ladderController) {
        String printNameSize = "%-" + Integer.toString(ladderController.getLadder().getLineHorizonLength() + NAME_SIZE_CORRECTION) + "s";
        for (Player player : ladderController.getPlayers()) {
            System.out.printf(String.format(printNameSize, player.getName()));
        }
        System.out.println();
    }

    public static void printLadder(LadderController ladderController) {
        System.out.println();
        printPlayerNames(ladderController);
        Ladder ladder = ladderController.getLadder();
        for (int i = 0; i < ladder.getLadderForm().size(); i++) {
            printLadderHorizontal(ladder, ladder.getLadderForm().get(i).getPoints());
            System.out.println();
        }
    }
}
