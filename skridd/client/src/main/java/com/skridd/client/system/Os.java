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
package com.skridd.client.system;

public class Os {
    
    public static final int OS_TYPE_UNKNOWN = 0;
    public static final int OS_TYPE_WINDOWS = 1;
    
    private static final String NAME_PREFIX_WINDOWS = "windows";
    
    public static String getOsName(){
        return System.getProperty("os.name");
    }
    
    public static int getOsType(){
        int type=0;
        if ( getOsName().toLowerCase().startsWith(NAME_PREFIX_WINDOWS)) {
            type=OS_TYPE_WINDOWS;
        }
        return type;
    }
}
