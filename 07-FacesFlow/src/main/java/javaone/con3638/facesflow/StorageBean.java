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
package javaone.con3638.facesflow;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author marfous
 */
@Named(value = "storageBean")
@SessionScoped
public class StorageBean extends PersonBean implements Serializable {

    @Inject
    @Named(value = "personBean")
    PersonBean personBean;

    /** Holds information whether the registration wizard was already used. */
    private AtomicBoolean isStorageUsed = new AtomicBoolean(false);

    public void storeData() {
        setGivenname(personBean.getGivenname());
        setSurname(personBean.getSurname());
        setStreet(personBean.getStreet());
        setCity(personBean.getCity());
        isStorageUsed.set(true);
    }

    public void restoreData() {
        personBean.setGivenname(getGivenname());
        personBean.setSurname(getSurname());
        personBean.setStreet(getStreet());
        personBean.setCity(getCity());
    }

    public void handleLoad() {
        // if we are comming from the avatar chooser, let's restore data
        if (personBean.getAvatar() != null && !personBean.getAvatar().isEmpty()) {
            restoreData();
        }
    }

    public AtomicBoolean isStorageUsed() {
        return isStorageUsed;
    }

}
