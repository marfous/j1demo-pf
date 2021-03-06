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
package javaone.con3638.primegobeyond;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

@Named(value = "mapBean")
@RequestScoped
public class MapBean implements Serializable {

    private MapModel emptyModel;
    
    private String title;
    private double lat;
    private double lng;

    public MapBean() {
        emptyModel = new DefaultMapModel();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }
    
    public void checkin() {
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();        
        
        pushContext.push("/check-in", new CheckIn(title, lat, lng));
    }

}
