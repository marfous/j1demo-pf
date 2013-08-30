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
package javaone.con3638.facesflowlibrary;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

/**
 * Avatar bean used by avatarChooser flow.
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
@Named(value = "avatarBean")
@FlowScoped("avatarChooser")
public class AvatarBean {

    private String firstName;
    private String secondName;
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName != null ? firstName : "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName != null ? secondName : "";
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

}
