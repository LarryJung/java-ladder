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
    public void nameCheckReturnTest1() {
        String[] names = {"pobi","pobi","honux","jk"};
        LadderController.namesCheckReturn(names);
    }

    @Test(expected = InvalidNamesException.class)
    public void nameCheckReturnTest2() {
        String[] names = {"pobi","cronggg","honux","jk"};
        LadderController.namesCheckReturn(names);
    }

    @Test
    public void nameCheckReturnTest3() {
        String[] names = {"pobi", "crong", "honux", "jk"};
        List<String> playerNames = Arrays.asList("pobi", "crong", "honux", "jk");
        assertEquals(playerNames, LadderController.namesCheckReturn(names));
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

    @Test
    public void makePrizesTest1() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("sad", "happy"));
        ArrayList<Player> prizes = new ArrayList<>(Arrays.asList(new Player("sad"), new Player("happy")));

        assertEquals(true, prizes.get(0).getName().equals(LadderController.makePrizes(names).get(0).getName()));
        assertEquals(true, prizes.get(1).getName().equals(LadderController.makePrizes(names).get(1).getName()));
    }

    @Test
    public void makePrizesTest2() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("happy", "sad", "hello"));
        ArrayList<Player> prizes = new ArrayList<Player>();
        prizes.add(new Player("happy"));
        prizes.add(new Player("sad"));
        prizes.add(new Player("bye")); // index 2 wrong

        assertEquals(false, prizes.get(2).getName().equals(LadderController.makePrizes(names).get(2).getName()));
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

}
