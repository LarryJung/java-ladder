package codesquad.ladder.view;

import codesquad.ladder.model.Player;
import codesquad.ladder.model.Prize;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ResultViewTest {

    @Test
    public void makePlayerNamesTest(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("pobi"));
        players.add(new Player("crong"));
        players.add(new Player("honux"));
        players.add(new Player("jk"));

        String expectedNames = "pobi  crong honux jk    ";
        assertEquals(expectedNames, ResultView.makePlayerNames(players));
    }

    @Test
    public void makePrizeNamesTest(){
        ArrayList<Prize> prizes = new ArrayList<Prize>();
        prizes.add(new Prize("1"));
        prizes.add(new Prize("2"));
        prizes.add(new Prize("3"));
        prizes.add(new Prize("4"));

        String expectedNames = "1     2     3     4     ";
        assertEquals(expectedNames, ResultView.makePrizeNames(prizes));
    }

    @Test
    public void makeLadderHorizontalLineTest(){
        ArrayList<Boolean> ladderOneLine = new ArrayList<>(Arrays.asList(true, false, true));

        String expectedLine = "|-----|     |-----|";
        assertEquals(expectedLine, ResultView.makeLadderHorizontalLine(ladderOneLine));
    }

    @Test
    public void ladderUnitTest(){
        assertEquals("|-----", ResultView.ladderUnit(true));
        assertEquals("|     ", ResultView.ladderUnit(false));
    }
}
