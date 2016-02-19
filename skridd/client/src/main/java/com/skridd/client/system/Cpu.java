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

import com.skridd.client.SkriddClient;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Pattern;
import static java.util.stream.Collectors.toList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cpu {

    static Logger LOGGER = LoggerFactory.getLogger(Cpu.class);

    final static String WIN_USAGE_CMD = "wmic cpu get loadpercentage";

    public static Float getCpuUsage() throws IOException {
        Float usage = null;
        java.lang.Process p = null;
        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        if (Os.getOsType() == Os.OS_TYPE_WINDOWS) {
            p = rt.exec(WIN_USAGE_CMD);
            java.io.InputStream is = p.getInputStream();
            java.io.BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
            Pattern pattern = Pattern.compile("[\\d\\.]+");
            List<String> usageList = reader.lines()
                    .filter( pattern.asPredicate() ).collect(toList());
            // if there is no numeric value in the output, the usage is 0
            usage = (usageList.isEmpty())? 0:Float.parseFloat( usageList.get(0) );
        }
        return usage;
    }
}
