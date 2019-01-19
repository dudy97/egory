package com.dudy;

import com.dudy.controller.MainController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by admin on 19.01.2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {
    @Autowired
    private MainController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testIndex() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("index");
    }

    @Test
    public void testGuidePanel() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/demo/guide",
                String.class)).contains("Guide panel");
    }

    @Test
    public void testCustomerPanel() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/demo/customer",
                String.class)).contains("Customer panel");
    }

    @Test
    public void testPointForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/demo/new-point",
                String.class)).contains("Point form");
    }

    @Test
    public void testRoutesPage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/demo/routes-page",
                String.class)).contains("Routes Page");
    }
}
