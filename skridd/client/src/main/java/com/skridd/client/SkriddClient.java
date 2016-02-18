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
import java.net.URI;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkriddClient {
    
    static Logger LOGGER = LoggerFactory.getLogger(SkriddClient.class);

    WebTarget target;

    public SkriddClient(String baseURI) {
        ClientConfig config = new ClientConfig();
        javax.ws.rs.client.Client client = ClientBuilder.newClient(config);

        target = client.target(getURI(baseURI));
    }

    private static URI getURI(String baseURI) {
        return UriBuilder.fromUri(baseURI).build();
    }

    public WebTarget getTarget() {
        return target;
    }

    /**
     * Send a POST request with updated performance metrics
     * @param metricName
     * @param metricValue 
     */
    public void postMetricUpdate(String metricName, String metricValue) {
        Form form = new Form();
        form.param(Constants.POST_METRIC_NAME, metricName);
        form.param(Constants.POST_METRIC_VALUE, metricValue);
        Response response
                = target.path("metric").path("post").request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                        Response.class);
    }

}
