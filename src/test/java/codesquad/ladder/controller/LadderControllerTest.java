package codesquad.ladder.controller;

import codesquad.ladder.model.Player;
import codesquad.ladder.model.exceptions.DuplicetedNameException;
import codesquad.ladder.model.exceptions.InvalidNameSizeException;
import codesquad.ladder.model.exceptions.InvalidPlayerNameException;
import codesquad.ladder.model.exceptions.InvalidSizeLadderException;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class LadderControllerTest {

    @Test(expected = InvalidPlayerNameException.class)
    public void playerNameCheckReturnTest1() {
        String[] playerNames = "pobi,pobi,honux,jk".split(",");
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(playerNames));
        LadderController.playerNameCheckReturn(playerNames);
    }

    @Test(expected = InvalidPlayerNameException.class)
    public void playerNameCheckReturnTest2() {
        String[] playerNames = "pobi,cronggg,honux,jk".split(",");
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(playerNames));
        LadderController.playerNameCheckReturn(playerNames);
    }

    @Test
    public void playerNameCheckReturnTest3() {
        String[] playerNames = "pobi,crong,honux,jk".split(",");
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(playerNames));
        assertEquals(names, LadderController.playerNameCheckReturn(playerNames));
    }

    @Test(expected = InvalidPlayerNameException.class)
    public void nameFinalCheckTest1() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("podf");
        names.add("honuxx");
        names.add("crong");

        LadderController.nameFinalCheck(names);
    }

    @Test
    public void nameFinalCheckTest2() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("podf");
        names.add("honux");
        names.add("crong");

        assertEquals(true, LadderController.nameFinalCheck(names));
    }

    @Test(expected = InvalidNameSizeException.class)
    public void nameMaxSizeCheckTest1() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("podf");
        names.add("honuxxx");
        names.add("crong");

        LadderController.nameMaxSizeCheck(names);
    }

    @Test
    public void nameMaxSizeCheckTest2() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("pobi");
        names.add("honux");
        names.add("crong");

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
        ArrayList<String> names = new ArrayList<String>();
        names.add("pobi");
        names.add("honux");
        names.add("crong");

        assertEquals(true, LadderController.duplicatedNameCheck(names));
    }

    @Test(expected = DuplicetedNameException.class)
    public void duplicatedNameCheckTest2() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("pobi");
        names.add("pobi");
        names.add("crong");

        LadderController.duplicatedNameCheck(names);
    }

    @Test
    public void makePlayersTest1() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("pobi");
        names.add("crong");

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("pobi"));
        players.add(new Player("crong"));



        assertEquals(true, players.get(0).getName().equals(LadderController.makePlayers(names).get(0).getName()));
        assertEquals(true, players.get(1).getName().equals(LadderController.makePlayers(names).get(1).getName()));
    }

    @Test
    public void makePlayersTest2() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("honux");
        names.add("crong");
        names.add("pobi");

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
        ;
    }

}
