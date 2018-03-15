package codesquad.ladder;

import codesquad.ladder.controller.LadderController;
import codesquad.ladder.view.ResultView;

public class LadderMain {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ResultView.printLadder(ladderController);
//
//        String s1 = new String("asdf");
//        String s2 = new String("asdf");
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//        System.out.println(s1==s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(Integer.toHexString(System.identityHashCode(s1)));
//        System.out.println(Integer.toHexString(System.identityHashCode(s2)));
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());
    }
}