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

import java.io.Serializable;
import javax.validation.constraints.Size;

public class Car implements Serializable {

    public String model;
    public int year;
    public String manufacturer;
    
    @Size(min = 2, max = 5)
    public String color;
    
    public int price;

    public Car() {
    }
    
    public Car(String model, int year, String manufacturer, String color) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.color = color;
    }

    public Car(String model, int year, String manufacturer, String color, int price) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.color = color;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Car)) {
            return false;
        }

        Car compare = (Car) obj;

        return compare.model.equals(this.model);
    }

    @Override
    public int hashCode() {
        int hash = 1;

        return hash * 31 + model.hashCode();
    }
}
