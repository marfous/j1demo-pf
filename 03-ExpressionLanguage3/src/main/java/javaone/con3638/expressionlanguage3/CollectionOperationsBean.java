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
package javaone.con3638.expressionlanguage3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author marfous
 */
@Named("cob")
@RequestScoped
public class CollectionOperationsBean {

    public boolean isString(Object o) {
        return o instanceof String;
    }

    public boolean isInteger(Object o) {
        return o instanceof Integer;
    }

    public void logToConsole(Object o) {
        Logger.getGlobal().log(Level.INFO, "Logging value from the EL: {0}", o);
    }
}
