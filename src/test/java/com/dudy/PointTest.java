package com.dudy;

import com.dudy.entity.Point;
import com.dudy.entity.Region;
import com.dudy.entity.Route;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by admin on 16.01.2019.
 */
public class PointTest {
    Point point;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() throws Exception
    {
        point = new Point();
    }
    @Test
    public void testPoint() throws Exception
    {
        String name = "Rysy";
        int height = 1200;
        double longitude = 44.4;
        double latitude = 20.1;
        String description = "Najwyzszy szczyt w Polsce";
        Point testPoint = new Point(name, height,longitude,latitude,description);

        assertEquals(name,testPoint.getName());
        assertEquals(height,testPoint.getHeight());
        assertEquals(longitude,testPoint.getLongitude(),DELTA);
        assertEquals(latitude,testPoint.getLatitude(),DELTA);
        assertEquals(description,testPoint.getDescription());

    }
    @Test
    public void getHeight() throws Exception
    {
        int height = 2500;
        point.setHeight(height);

        assertEquals(height, point.getHeight());
    }

    @Test
    public void getName() throws Exception
    {
        String name = "test";
        point.setName(name);

        assertEquals(name, point.getName());
    }

    @Test
    public void getLongitude() throws Exception
    {
        double longitude = 25.4;
        point.setLongitude(longitude);

        assertEquals(longitude, point.getLongitude(),DELTA);
    }

    @Test
    public void getLatitude() throws Exception
    {
        double latitude = 50.4;
        point.setLatitude(latitude);

        assertEquals(latitude, point.getLatitude(),DELTA);
    }

    @Test
    public void getRegion() throws Exception
    {
        Region testRegion = new Region("Karkonosze");
        point.setRegion(testRegion);

        assertEquals(testRegion, point.getRegion());
    }

    @Test
    public void getRoutes() throws Exception
    {
        Route route1 = new Route();
        route1.setName("trasa1");

        Route route2 = new Route();
        route2.setName("trasa2");

        ArrayList<Route> foods = new ArrayList<>(2);
        foods.add(route1);
        foods.add(route2);

        point.setRoutes(foods);

        assertEquals(foods, point.getRoutes());
    }
}
