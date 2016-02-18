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

public class Constants {
    
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:9797/skridd/";
    public static final String TEST_URI = "http://localhost:9898/skridd/";

    //Response codes
    public final static int RESPONSE_OK=200;
    
    //POST params
    public static final String POST_METRIC_NAME="metric_name";
    public static final String POST_METRIC_VALUE="metric_value";
    
}
