package codesquad.ladder.controller;

import codesquad.ladder.model.Ladder;
import codesquad.ladder.model.Line;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderUtilsTest {

    @Test
    public void findLadderResultTest() {
        ArrayList<Line> ladderForm = new ArrayList<Line>();
        ladderForm.add(new Line(new ArrayList<>(Arrays.asList(true, false, true, false))));
        ladderForm.add(new Line(new ArrayList<>(Arrays.asList(false, false, true, false))));
        ladderForm.add(new Line(new ArrayList<>(Arrays.asList(false, true, false, false))));
        Ladder ladder = new Ladder(ladderForm);

        assertEquals(2, LadderUtils.findLadderResult(0, ladder));
        assertEquals(0, LadderUtils.findLadderResult(1, ladder));
        assertEquals(1, LadderUtils.findLadderResult(2, ladder));
        assertEquals(3, LadderUtils.findLadderResult(3, ladder));
        assertEquals(4, LadderUtils.findLadderResult(4, ladder));
    }
}

