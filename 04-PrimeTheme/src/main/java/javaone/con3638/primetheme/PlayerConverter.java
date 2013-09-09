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

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "player")
public class PlayerConverter implements Converter {

    public static List<Player> playerDB;

    static {
        playerDB = new ArrayList<Player>();

        playerDB.add(new Player("Messi", 10, "messi.jpg", "CF"));
        playerDB.add(new Player("Bojan", 9, "bojan.jpg", "CF"));
        playerDB.add(new Player("Iniesta", 8, "iniesta.jpg", "CM"));
        playerDB.add(new Player("Villa", 7, "villa.jpg", "CF"));
        playerDB.add(new Player("Xavi", 6, "xavi.jpg", "CM"));
        playerDB.add(new Player("Puyol", 5, "puyol.jpg", "CB"));
        playerDB.add(new Player("Afellay", 20, "afellay.jpg", "AMC"));
        playerDB.add(new Player("Abidal", 22, "abidal.jpg", "LB"));
        playerDB.add(new Player("Alves", 2, "alves.jpg", "RB"));
        playerDB.add(new Player("Pique", 3, "pique.jpg", "CB"));
        playerDB.add(new Player("Keita", 15, "keita.jpg", "DM"));
        playerDB.add(new Player("Adriano", 21, "adriano.jpg", "LB"));
        playerDB.add(new Player("Valdes", 1, "valdes.jpg", "GK"));
    }

    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (Player p : playerDB) {
                    if (p.getNumber() == number) {
                        return p;
                    }
                }
                
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
            }
        }

        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Player) value).getNumber());
        }
    }
}
