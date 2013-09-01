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

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Stores person data into the session to be able to recover them again.
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
@Named(value = "storageBean")
@SessionScoped
public class StorageBean extends PersonBean implements Serializable {

    @Inject
    @Named(value = "personBean")
    PersonBean personBean;

    /** Holds information whether the registration wizard was already used. */
    private final AtomicBoolean isStorageUsed = new AtomicBoolean(false);

    public void storeData() {
        setFirstName(personBean.getFirstName());
        setSecondName(personBean.getSecondName());
        setStreet(personBean.getStreet());
        setCity(personBean.getCity());
        setAvatar(personBean.getAvatar());
        isStorageUsed.set(true);

        // this is hack to prevent second flow (avatarChooser) to be called back
        //   since no flow is finished without calling its return node 
        redirectAway();
    }

    public void restoreData() {
        personBean.setFirstName(getFirstName());
        personBean.setSecondName(getSecondName());
        personBean.setStreet(getStreet());
        personBean.setCity(getCity());
        personBean.setAvatar(getAvatar());
    }

    public AtomicBoolean isStorageUsed() {
        return isStorageUsed;
    }

    private void redirectAway() {
        try {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(StorageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
