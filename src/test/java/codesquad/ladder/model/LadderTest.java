package codesquad.ladder.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderTest {

    @Test
    public void traceTest(){
        ArrayList<Line> ladderForm = new ArrayList<>();
        ladderForm.add(new Line(new ArrayList<>(Arrays.asList(true, false, false, true))));
        ladderForm.add(new Line(new ArrayList<>(Arrays.asList(false, true, false, true))));
        ladderForm.add(new Line(new ArrayList<>(Arrays.asList(true, false, false, true))));
        ladderForm.add(new Line(new ArrayList<>(Arrays.asList(true, false, false, false))));
        Ladder ladder = new Ladder(ladderForm);

        assertEquals(2, ladder.trace(0));
        assertEquals(0, ladder.trace(1));
        assertEquals(1, ladder.trace(2));
        assertEquals(4, ladder.trace(3));
        assertEquals(3, ladder.trace(4));
    }
}
