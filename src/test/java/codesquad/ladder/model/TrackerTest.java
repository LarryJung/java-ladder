package codesquad.ladder.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TrackerTest {
    Tracker tracker;
    Line line;

    @Before
    public void setUp(){
        line = new Line(new ArrayList<>(Arrays.asList(true, false, false, true)));
        tracker = new Tracker(1);
    }
    @Test
    public void colMoveInBody_moveLeft(){
        assertEquals(0, tracker.colMoveInBody(1, line));
    }
    @Test
    public void colMoveInBody_moveRight(){
        assertEquals(4, tracker.colMoveInBody(3, line));
    }
    @Test
    public void colMoveInBody_moveDown(){
        assertEquals(2, tracker.colMoveInBody(2, line));
    }
    @Test
    public void colMoveAtLastFrame_moveLeft(){
        assertEquals(3, tracker.colMoveAtLastFrame(4, line));
    }
    @Test
    public void colMoveAtLastFrame_moveDown(){
        Line line2 = new Line(new ArrayList<>(Arrays.asList(true, false, false, false)));
        assertEquals(4, tracker.colMoveAtLastFrame(4, line2));
    }
    @Test
    public void colMoveAtFirstFrame_moveRight(){
        assertEquals(1, tracker.colMoveAtFirstFrame(0, line));
    }
    @Test
    public void colMoveAtFirstFrame_moveDown(){
        Line line3 = new Line(new ArrayList<>(Arrays.asList(false, false, false, true)));
        assertEquals(0, tracker.colMoveAtFirstFrame(0, line3));
    }
}
