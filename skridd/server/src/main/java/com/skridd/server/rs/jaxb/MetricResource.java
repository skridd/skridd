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

package com.skridd.server.rs.jaxb;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path( "metric" )
public class MetricResource {
    
    static Logger LOGGER = LoggerFactory.getLogger(MetricResource.class);
    
    /**
     * Update a metric of the client machine performance
     * @param name Metric name
     * @param value Metric value
     * @return 
     */
    @GET
    @Path( "/update/{name}/{value}" )
    public String getResponse( @PathParam( "name" ) String name
            ,@PathParam( "value" ) String value) {
        return "Update" 
                + " metric " + name
                + " to value " + value;
    }
    
}
