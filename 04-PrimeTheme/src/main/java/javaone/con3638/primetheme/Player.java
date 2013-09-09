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
package javaone.con3638.primetheme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player implements Serializable {

    private String name;
    private int number;
    private String photo;
    private String position;
    private String nationality;
    private String height;
    private String weight;
    private Date birth;
    private List<Stats> stats = new ArrayList<Stats>();

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int number, String photo) {
        this.name = name;
        this.number = number;
        this.photo = photo;
    }

    public Player(String name, int number, String photo, String position) {
        this.name = name;
        this.number = number;
        this.photo = photo;
        this.position = position;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    public int getAllGoals() {
        int sum = 0;

        for (Stats s : stats) {
            sum += s.getGoals();
        }

        return sum;
    }

    public int getAllAssists() {
        int sum = 0;

        for (Stats s : stats) {
            sum += s.getAssists();
        }

        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Player)) {
            return false;
        }

        return ((Player) obj).getNumber() == this.number;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        return hash * 31 + name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}