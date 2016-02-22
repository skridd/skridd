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
package com.skridd.server.rs.jaxb.json;

import com.skridd.server.rs.jaxb.model.MetricList;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MetricListMarshaller {

    Marshaller marshaller;

    public MetricListMarshaller() throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(MetricList.class);
        marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
    }

    public String createJson(MetricList metricList) throws JAXBException {
        marshaller.marshal(metricList, System.out);
        java.io.StringWriter sw = new StringWriter();
        marshaller.marshal(metricList, sw);
        return sw.toString();
    }
}
