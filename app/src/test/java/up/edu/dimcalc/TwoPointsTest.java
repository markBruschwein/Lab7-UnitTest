package up.edu.dimcalc;

import android.graphics.Point;
import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bruschwe18 on 3/2/2016.
 */
public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void testGetPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 0);
        assertEquals(p1.y, 0);
        assertEquals(p2.x, 0);
        assertEquals(p2.y, 0);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void testSetPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 5);
        assertEquals(p1.y, -3);
        assertEquals(p2.x, -3);
        assertEquals(p2.y, 5);
    }

    @Test
    public void testRandomValue() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertNotEquals(p1.x, 0);
        assertNotEquals(p1.y, 0);
        assertNotEquals(p2.x, 0);
        assertNotEquals(p2.y, 0);
    }

    @Test
    public void testSetOrigin() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        testPoints.setOrigin(0);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertEquals(p1.x, 0);
        assertEquals(p1.y, 0);
        assertEquals(p2.x, -3);
        assertEquals(p2.y, 5);

    }

    @Test
    public void testCopy() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);

        testPoints.copy(0, 1);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertTrue(p2.x == 5);
        assertTrue(p2.y == -3);



    }

    @Test
    public void testDistance() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 0, 0);
        testPoints.setPoint(1, 1, 1);

        double distance = testPoints.distance();
        double known =  Math.sqrt(2);

        assertTrue(known == distance);
    }

    @Test
    public void testSlope() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 0, 0);
        testPoints.setPoint(1, 2, 1);
        double expected = 0.5;
        double slope = testPoints.slope();

        assertTrue(slope == expected);

    }

}