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

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderAddressComponent;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author mertcaliskan
 */
@Named(value = "mapsBean")
@RequestScoped
public class MapsBean implements Serializable {

    final String DEFAULT_LOCATION = "37.06250000000001,-95.67706800000002";
    private Location selectedAddress;
    private String selectedLocation = DEFAULT_LOCATION;
    private MapModel markerModel = new DefaultMapModel();
    private int zoomLevel = 4;

    public void handleLocationSelect(SelectEvent event) {
        zoomLevel = 8;
        Location location = (Location) event.getObject();
        selectedLocation = location.getLatitude()+ "," + location.getLongitude();

        markerModel.addOverlay(new Marker(
                new LatLng(location.getLatitude().doubleValue(), location.getLongitude().doubleValue()),
                location.getAddress()));
    }

    public List<Location> completeAddress(String address) throws InvalidKeyException {
        final Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("en").getGeocoderRequest();
        GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
        List<GeocoderResult> results = geocoderResponse.getResults();

        List<Location> locations = new ArrayList<>();

        for (int i = 0; i < results.size(); i++) {
            GeocoderResult result = results.get(i);
            List<GeocoderAddressComponent> addressComponents = result.getAddressComponents();

            Location location = new Location();
            location.setAddress(result.getFormattedAddress());
            location.setLongitude(result.getGeometry().getLocation().getLng());
            location.setLatitude(result.getGeometry().getLocation().getLat());
            locations.add(location);
        }

        return locations;
    }

    public Location getSelectedAddress() {
        return selectedAddress;
    }

    public void setSelectedAddress(Location selectedAddress) {
        this.selectedAddress = selectedAddress;
    }

    public String getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(String selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public MapModel getMarkerModel() {
        return markerModel;
    }

    public void setMarkerModel(MapModel markerModel) {
        this.markerModel = markerModel;
    }

    public int getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(int zoomLevel) {
        this.zoomLevel = zoomLevel;
    }
}
