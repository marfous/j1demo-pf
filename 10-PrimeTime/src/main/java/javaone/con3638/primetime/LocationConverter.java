/*
 * Copyright (C) 2013 Martin Fousek & Mert Caliskan
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
package javaone.con3638.primetime;

import java.math.BigDecimal;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("locationConverter")
public class LocationConverter  implements Converter {

    public Object getAsObject(final FacesContext fc, final UIComponent component, final String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        else {
            Location location = new Location();

            String[] locAddressSplit = value.split("##");
            location.setAddress(locAddressSplit[0]);

            String[] locLatLongSplit = locAddressSplit[1].split("@@");
            location.setLatitude(new BigDecimal(locLatLongSplit[0]));
            location.setLongitude(new BigDecimal(locLatLongSplit[1]));
            
            return location;
        }
    }

    public String getAsString(final FacesContext fc, final UIComponent component, final Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return value.toString();
        }
    }
}