package com.dudy;

import com.dudy.entity.Point;
import com.dudy.repository.MountainGroupRepository;
import com.dudy.repository.PointRepository;
import com.dudy.repository.RegionRepository;
import com.dudy.repository.RouteRepository;
import com.dudy.service.EntityService;
import com.dudy.service.EntityServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by admin on 16.01.2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityServiceImplTest {
    @Autowired
    EntityService entityService;

    @Mock
    PointRepository pointRepository;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        entityService = new EntityServiceImpl();
    }


    @Test
    public void getPointsTest() throws Exception
    {
        Point point = new Point();
        point.setId(90);
        HashSet pointData = new HashSet();
        pointData.add(point);

        when(pointRepository.findAll()).thenReturn(pointData);

        System.out.println("Znaleziono w point repository"+pointRepository.findAll());

        assertEquals(pointData.size(), 1);
        verify(pointRepository, times(1)).findAll();
        verify(pointRepository, never()).findById(anyInt());
    }
}
