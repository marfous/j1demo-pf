package javaone.con3638.pfscaffolding.jsfs;

import javaone.con3638.pfscaffolding.entities.Car;
import javaone.con3638.pfscaffolding.sbs.CarFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;

@Named(value = "carController")
@SessionScoped
public class CarController extends AbstractController<Car> implements Serializable {

    @Inject
    private CarFacade ejbFacade;

    public CarController() {
        super(Car.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
