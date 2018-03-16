package codesquad.ladder.view;

import codesquad.ladder.controller.LadderController;
import codesquad.ladder.model.Ladder;
import codesquad.ladder.model.Player;
import codesquad.ladder.model.Prize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final int NAME_SIZE_CORRECTION = 1;

    private static final String FRAME = "|";

    private static final String LADDER_LINE_UNIT = "-";

    private static final String LADDER_SPACE_UNIT = " ";

    private static final int LADDER_HORIZONTAL_LINE_UNIT = 5;

    // 사다리 출력
    public static void printLadder(LadderController ladderController) {

        Ladder ladder = ladderController.getLadder();
        System.out.println();
        printString(makePlayerNames(ladderController.getPlayers()));
        System.out.println();
        for (int i = 0; i < ladder.getLadderForm().size(); i++) {
            printString(makeLadderHorizontalLine(ladder.getLadderForm().get(i).getPoints()));
            System.out.println();
        }
        printString(makePrizeNames(ladderController.getPrizes()));
        System.out.println();
    }

    // 플레이어 이름 스트링 반환
    static String makePlayerNames(ArrayList<Player> players) {
        StringBuilder playerNames = new StringBuilder();
        String printNameSize = "%-" + Integer.toString(LADDER_HORIZONTAL_LINE_UNIT + NAME_SIZE_CORRECTION) + "s"; // %-6s
        for (Player player : players) {
            playerNames.append(String.format(printNameSize, player.getName()));
        }
        return playerNames.toString();
    }

    // 플레이어 이름 스트링 반환
    static String makePrizeNames(ArrayList<Prize> prizes) {
        StringBuilder playerNames = new StringBuilder();
        String printNameSize = "%-" + Integer.toString(LADDER_HORIZONTAL_LINE_UNIT + NAME_SIZE_CORRECTION) + "s"; // %-6s
        for (Prize prize : prizes) {
            playerNames.append(String.format(printNameSize, prize.getName()));
        }
        return playerNames.toString();
    }

    // 사다리 한 라인 스트링 반환
    static String makeLadderHorizontalLine(ArrayList<Boolean> ladderOneLine) {
        String ladderHorizontalLine = IntStream.range(0, ladderOneLine.size()).mapToObj(i -> ladderUnit(ladderOneLine.get(i))).collect(Collectors.joining(""));
        return ladderHorizontalLine+FRAME;
    }

    // 사다리 라인 유닛 스트링 반환
    static String ladderUnit(boolean isLine) {
        String ladderLine = IntStream.range(0, LADDER_HORIZONTAL_LINE_UNIT).mapToObj(i -> LADDER_LINE_UNIT).collect(Collectors.joining(""));
        String ladderSpace = IntStream.range(0, LADDER_HORIZONTAL_LINE_UNIT).mapToObj(i -> LADDER_SPACE_UNIT).collect(Collectors.joining(""));
        return (isLine) ? FRAME + ladderLine : FRAME + ladderSpace;
    }

    // 스트링 출력 메소드
    private static void printString(String str) { System.out.printf(str); }

    public static void printResults(LadderController ladderController) {
        System.out.println("What result you want to see? (exit = q)");
        String resultName = InputView.getString();
        switch (resultName) {
            case "all":
                viewAllResult(ladderController);
                break;
            case "q":
                System.out.println("Bye~");
                System.exit(0);
            default:
                findResult(resultName, ladderController);
                break;
        }
    }

    private static void viewAllResult(LadderController ladderController) {
        System.out.println("All Results");
        Iterator<Player> keys = ladderController.getMap().keySet().iterator();
        while( keys.hasNext() ){
            Player key = keys.next();
            System.out.println(String.format("%s : %s", key.getName(), ladderController.getMap().get(key).getName()));
        }
        printResults(ladderController);
    }

    private static void findResult(String resultName, LadderController ladderController){
        try{
            Player key = new Player(resultName);
            Prize value = ladderController.getMap().get(new Player(resultName));
            System.out.println(String.format("%s : %s", key.getName(), value.getName()));
            printResults(ladderController);
        } catch (RuntimeException e){
            System.out.println("please put the right Name. try again.");
            printResults(ladderController);
        }
    }
}


