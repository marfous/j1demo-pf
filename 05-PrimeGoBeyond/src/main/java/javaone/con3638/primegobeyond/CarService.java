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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cars")
public class CarService {

    private final static String[] colors;
    private final static String[] brands;

    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";

        brands = new String[10];
        brands[0] = "Mercedes";
        brands[1] = "BMW";
        brands[2] = "Volvo";
        brands[3] = "Audi";
        brands[4] = "Renault";
        brands[5] = "Opel";
        brands[6] = "Volkswagen";
        brands[7] = "Chrysler";
        brands[8] = "Ferrari";
        brands[9] = "Ford";
    }
    private List<Car> cars;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Car> loadCars() {
        if (cars == null) {
            cars = populateCars(50);
        }

        return cars;
    }

    private List<Car> populateCars(int size) {
        List<Car> list = new ArrayList<Car>();
        for (int i = 0; i < size; i++) {
            list.add(new Car(getRandomVin(), getRandomBrand(), getRandomYear(), getRandomColor()));
        }

        return list;
    }

    private String getRandomVin() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }

    private String getRandomBrand() {
        return brands[(int) (Math.random() * 10)];
    }
}