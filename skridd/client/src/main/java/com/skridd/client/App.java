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

import com.skridd.client.system.Cpu;
import com.skridd.server.Constants;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    
    static Logger LOGGER = LoggerFactory.getLogger(App.class);

 
    public static void main(String[] args) throws IOException {
        BasicConfigurator.configure();
        SkriddClient skriddClient = new SkriddClient(Constants.BASE_URI);
        String plainAnswer
                = skriddClient.getTarget().path("connectivity").request()
                        .accept(MediaType.TEXT_PLAIN).get(String.class);
        LOGGER.debug(plainAnswer);
    }

}
