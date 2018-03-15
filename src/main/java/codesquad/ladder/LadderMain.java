package codesquad.ladder;

import codesquad.ladder.controller.LadderController;
import codesquad.ladder.view.ResultView;

public class LadderMain {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.ladderGameStart();
        ResultView.printLadder(ladderController);

    }
}