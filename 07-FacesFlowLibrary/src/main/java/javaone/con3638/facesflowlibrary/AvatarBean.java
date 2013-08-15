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
 *
 * @author marfous
 */
@Named(value = "avatarBean")
@FlowScoped("avatarChooser")
public class AvatarBean {

    private String name;
    private String flowTarget;
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlowTarget() {
        return flowTarget;
    }

    public void setFlowTarget(String flowTarget) {
        this.flowTarget = flowTarget;
    }

}
