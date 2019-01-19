package com.dudy;

import com.dudy.entity.Point;
import com.dudy.repository.PointRepository;
import com.dudy.repository.RouteRepository;
import com.dudy.service.EntityService;
import com.dudy.service.EntityServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EgoryApplicationTests {

	@TestConfiguration
	static class PointServiceImplTestContextConfiguration {

		@Bean
		public EntityService entityService() {
			return new EntityServiceImpl();
		}
	}

	@Autowired
	private EntityService entityService;

	@MockBean
	private PointRepository pointRepository;

	@Before
	public void setUp() {
		Point testPoint = new Point("Słonecznik", 76, 20,40, null);

		Mockito.when(pointRepository.findByName(testPoint.getName()))
				.thenReturn(testPoint);
	}

	@Test
	public void testFindByName() {
		String name = "Słonecznik";
		Point found = pointRepository.findByName(name);

		assertThat(found.getName())
				.isEqualTo(name);
	}
}
