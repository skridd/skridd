/*
 * Copyright (C) 2016 Serban Gilvitu <serban.gilvitu.dev@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.skridd.client;

import com.skridd.server.Constants;
import java.net.UnknownHostException;
import javax.ws.rs.client.WebTarget;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SkriddClientIT {

    HttpServer server;

    public SkriddClientIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws UnknownHostException {
//        server = Skridd.startServer(Constants.TEST_URI);
    }

    @After
    public void tearDown() throws InterruptedException {
//        server.shutdown();
    }

    /**
     * Test of getTarget method, of class SkriddClient.
     */
    @Test
    public void testGetTarget() {
        System.out.println("getTarget");
        SkriddClient instance = new SkriddClient(Constants.BASE_URI);
        WebTarget result = instance.getTarget();
        assertNotNull(result);
    }

    /**
     * Test of postMetricUpdate method, of class SkriddClient.
     */
    @Test
    public void testPostMetricUpdate() throws InterruptedException {
        System.out.println("postMetricUpdate");
        String metricName = "cpu";
        String metricValue = "35";
        System.out.println("->create client");
        SkriddClient instance = new SkriddClient(Constants.BASE_URI);
        System.out.println("->post metrics");
        instance.postMetricUpdate(metricName, metricValue);
    }
    

}
