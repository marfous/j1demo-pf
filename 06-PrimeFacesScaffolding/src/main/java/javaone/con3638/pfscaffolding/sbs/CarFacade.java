/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaone.con3638.pfscaffolding.sbs;

import javaone.con3638.pfscaffolding.entities.Car;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
@Stateless
public class CarFacade extends AbstractFacade<Car> {
    @PersistenceContext(unitName = "javaone.con3638.pfscaffolding_06-PrimeFacesScaffolding_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarFacade() {
        super(Car.class);
    }

}
