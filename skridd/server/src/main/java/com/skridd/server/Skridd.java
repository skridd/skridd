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
package com.skridd.server;

import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Skridd {

    INSTANCE;

    static Logger LOGGER = LoggerFactory.getLogger(Skridd.class);

    // Map containing the metrics
    Map metricMap = Collections.synchronizedMap(new HashMap<String, List<Float>>());
    final int MAP_MAX_SIZE = 10;
    final int LIST_MAX_SIZE = 10;

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
     * application.
     *
     * @param baseURI
     * @return Grizzly HTTP server.
     * @throws java.net.UnknownHostException
     */
    public static HttpServer startServer(String baseURI) throws UnknownHostException {
        // create a resource config that scans for JAX-RS resources and providers
        final ResourceConfig rc = new ResourceConfig().packages("com.skridd");
        Configuration.INSTANCE.init();
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(baseURI), rc);
    }

    public void updateMetric(String metricName, Float metricValue) {
        if (!metricMap.containsKey(metricName)) {
            if (metricMap.size() >= MAP_MAX_SIZE) {
                LOGGER.error("Maximum number of monitored metrics - exceeded");
            } else {
                List list = new ArrayList<Float>();
                list.add(metricValue);
                metricMap.put( metricName, list);
            }
        }
        else {
            List list = (List) metricMap.get(metricName);
            if ( list.size() >= LIST_MAX_SIZE) {
                list.remove(0);
            }
            list.add(metricValue);
        }
    }
    
    public List<Float> getMetricValues(String metricName) {
        List<Float> list = null;
        if (metricMap.containsKey(metricName)) {
            list = (List<Float>)metricMap.get(metricName);
        }
        return list;
    }
}
