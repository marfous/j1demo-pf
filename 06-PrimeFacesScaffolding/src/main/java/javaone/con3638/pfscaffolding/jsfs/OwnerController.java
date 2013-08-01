package javaone.con3638.pfscaffolding.jsfs;

import javaone.con3638.pfscaffolding.entities.Owner;
import javaone.con3638.pfscaffolding.sbs.OwnerFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;

@Named(value = "ownerController")
@SessionScoped
public class OwnerController extends AbstractController<Owner> implements Serializable {

    @Inject
    private OwnerFacade ejbFacade;

    public OwnerController() {
        super(Owner.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
