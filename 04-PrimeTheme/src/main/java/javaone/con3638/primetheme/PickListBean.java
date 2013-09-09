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
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.TransferEvent;

import org.primefaces.model.DualListModel;

@Named(value = "pickListBean")
@SessionScoped
public class PickListBean implements Serializable {

    private DualListModel<Player> players;

    public PickListBean() {
        //Players
        List<Player> source = new ArrayList<>();
        List<Player> target = new ArrayList<>();

        source.add(new Player("Messi", 10, "messi.jpg"));
        source.add(new Player("Iniesta", 8, "iniesta.jpg"));
        source.add(new Player("Villa", 7, "villa.jpg"));
        source.add(new Player("Alves", 2, "alves.jpg"));
        source.add(new Player("Xavi", 6, "xavi.jpg"));
        source.add(new Player("Puyol", 5, "puyol.jpg"));

        players = new DualListModel<>(source, target);
    }

    public DualListModel<Player> getPlayers() {
        return players;
    }

    public void setPlayers(DualListModel<Player> players) {
        this.players = players;
    }

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((Player) item).getName()).append("<br />");
        }

        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}