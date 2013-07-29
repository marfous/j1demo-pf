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
package javaone.con3638.jsfscaffolding.jsf.sbs;

import javaone.con3638.jsfscaffolding.entities.Owner;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marfous
 */
@Stateless
public class OwnerFacade extends AbstractFacade<Owner> {
    @PersistenceContext(unitName = "javaone.con3638.jsfscaffolding_06-JsfPrimeFacesScaffolding_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OwnerFacade() {
        super(Owner.class);
    }

}
