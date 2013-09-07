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
package javaone.con3638.htmlfriendlymarkup.bv;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * All validation rules are defined by the bean's fields.
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
@Named
@SessionScoped
public class BeanValidatedRegistrationBean implements Serializable {

    // We are showing localized Bean Validation messages. Take a look inside the main/resources directory.
    @Size(min = 1, message = "{NameMandatory}")
    private String name;

    @Size(min = 1, message = "{TelephoneMandatory}")
    @Pattern(regexp = "[0-9]+", message = "{TelephoneNotNumber}")
    private String tel;

    @Size(min = 1, message = "{EmailMandatory}")
    // Custom simple Bean Validation rule
    @Email
    private String email;

    @Size(min = 1, message = "{AvatarMandatory}")
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProgress() {
        int progress = 0;
        if (getName() != null && !getName().isEmpty()) progress++;
        if (getTel() != null && !getTel().isEmpty()) progress++;
        if (getEmail() != null && !getEmail().isEmpty()) progress++;
        return String.valueOf(progress);
    }

    public void savePerson() {
        String confirmation = MessageFormat.format(
                ResourceBundle.getBundle("Bundle").getString("successfulRegistration"),
                getName());
        FacesContext.getCurrentInstance().addMessage("status", new FacesMessage(confirmation));
        // save to DB
        reset();
    }

    public void reset() {
        setName(null);
        setTel(null);
        setEmail(null);
    }
    
}
