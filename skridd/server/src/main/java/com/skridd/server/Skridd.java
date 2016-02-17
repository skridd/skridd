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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum Skridd {
    INSTANCE;
    public final Object INIT_LOCK = new Object();
    
    private String hostname;
    private String hostAddress;
    
    /**
     * 
     * @throws UnknownHostException 
     */
    void init() throws UnknownHostException{
        synchronized(INIT_LOCK) {
            InetAddress ip;
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            hostAddress = ip.getHostAddress();
            Logger.getLogger(Skridd.class.getName())
                    .log(Level.INFO, "Hostname is " + hostname 
                            + "\nHost address is " + hostAddress);
        }
    }

    public String getHostname() {
        return hostname;
    }

    public String getHostAddress() {
        return hostAddress;
    }
    

}
