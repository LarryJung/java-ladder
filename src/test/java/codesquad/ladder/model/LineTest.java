package codesquad.ladder.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LineTest {

    @Test
    public void isBeforeValueTrueTest(){
        ArrayList<Boolean> points = new ArrayList<Boolean>();
        points.add(true);
        points.add(false);
        assertEquals(true, Line.isBeforeValueTrue(points, 1));
    }
}
