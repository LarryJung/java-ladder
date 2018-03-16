package codesquad.ladder.controller;

import codesquad.ladder.model.Ladder;
import codesquad.ladder.model.Line;
import codesquad.ladder.model.Player;
import codesquad.ladder.model.exceptions.DuplicetedNameException;
import codesquad.ladder.model.exceptions.InvalidNameSizeException;
import codesquad.ladder.model.exceptions.InvalidNamesException;
import codesquad.ladder.model.exceptions.InvalidSizeLadderException;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LadderControllerTest {

    @Test(expected = InvalidNamesException.class)
    public void playerNameCheckReturnTest1() {
        String[] playerNames = {"pobi","pobi","honux","jk"};
        LadderController.namesCheckReturn(playerNames);
    }

    @Test(expected = InvalidNamesException.class)
    public void playerNameCheckReturnTest2() {
        String[] playerNames = {"pobi","cronggg","honux","jk"};
        LadderController.namesCheckReturn(playerNames);
    }

    @Test
    public void playerNameCheckReturnTest3() {
        String[] playerNames = {"pobi", "crong", "honux", "jk"};
        List<String> names = Arrays.asList("pobi", "crong", "honux", "jk");
        assertEquals(names, LadderController.namesCheckReturn(playerNames));
    }

    @Test(expected = InvalidNamesException.class)
    public void nameFinalCheckTest1() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("pobi", "honuxx", "crong"));
        LadderController.nameFinalCheck(names);
    }

    @Test
    public void nameFinalCheckTest2() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("pobi", "honux", "crong"));
        assertEquals(true, LadderController.nameFinalCheck(names));
    }

    @Test(expected = InvalidNameSizeException.class)
    public void nameMaxSizeCheckTest1() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("pobi", "honuxxx", "crong"));
        LadderController.nameMaxSizeCheck(names);
    }

    @Test
    public void nameMaxSizeCheckTest2() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("pobi", "honux", "crong"));
        assertEquals(true, LadderController.nameMaxSizeCheck(names));
    }

    @Test
    public void eachNameSizeCheckTest1() {
        String name = "honux";
        assertEquals(true, LadderController.eachNameSizeCheck(name));
    }

    @Test(expected = InvalidNameSizeException.class)
    public void eachNameSizeCheckTest2() {
        String name = "oversix";
        LadderController.eachNameSizeCheck(name);
    }

    @Test
    public void duplicatedNameCheckTest1() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("pobi", "honux", "crong"));
        assertEquals(true, LadderController.duplicatedNameCheck(names));
    }

    @Test(expected = DuplicetedNameException.class)
    public void duplicatedNameCheckTest2() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("pobi", "pobi", "crong"));
        LadderController.duplicatedNameCheck(names);
    }

    @Test
    public void makePlayersTest1() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("pobi", "crong"));
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(new Player("pobi"), new Player("crong")));

        assertEquals(true, players.get(0).getName().equals(LadderController.makePlayers(names).get(0).getName()));
        assertEquals(true, players.get(1).getName().equals(LadderController.makePlayers(names).get(1).getName()));
    }

    @Test
    public void makePlayersTest2() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("honux", "crong", "pobi"));
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("honux"));
        players.add(new Player("crong"));
        players.add(new Player("jk")); // index 2 wrong

        assertEquals(false, players.get(2).getName().equals(LadderController.makePlayers(names).get(2).getName()));

    }

    @Test(expected = InvalidSizeLadderException.class)
    public void sizeLadderValidCheckReturnTest1() {
        int sizeLadder = 0;
        LadderController.sizeLadderValidCheckReturn(sizeLadder);
    }

    @Test
    public void sizeLadderValidCheckReturnTest2() {
        int sizeLadder = 1;
        assertEquals(sizeLadder, LadderController.sizeLadderValidCheckReturn(sizeLadder));
    }

    @Test
    public void findLadderResult2Test() {
        ArrayList<Line> ladderForm = new ArrayList<Line>();
        ladderForm.add(new Line(new ArrayList<>(Arrays.asList(true, false))));
        ladderForm.add(new Line(new ArrayList<>(Arrays.asList(false, false))));
        Ladder ladder = new Ladder(ladderForm);

        assertEquals(1, LadderController.findLadderResult2(0, ladder));
        assertEquals(0, LadderController.findLadderResult2(1, ladder));
        assertEquals(2, LadderController.findLadderResult2(2, ladder));
    }

}
