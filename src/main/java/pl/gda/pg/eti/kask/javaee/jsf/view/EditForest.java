package pl.gda.pg.eti.kask.javaee.jsf.view;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import pl.gda.pg.eti.kask.javaee.jsf.ElfService;
import pl.gda.pg.eti.kask.javaee.jsf.entities.Forest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;

@ViewScoped
@ManagedBean(name = "editForest")
@Log
public class EditForest implements Serializable {

    @ManagedProperty("#{elfService}")
    private ElfService elfService;

    @Getter
    @Setter
    private int forestId;

    @Getter
    @Setter
    private Forest forest;


    public void setElfService(ElfService elfService) {
        this.elfService = elfService;
    }

    public void init() {
        if (forest == null && forestId != 0) {
            forest = elfService.findForest(forestId);
        } else if (forest == null && forestId == 0) {
            forest = new Forest();
        }
        if (forest == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error/404.xhtml");
            } catch (IOException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        }
    }

    public String saveForest() {
        elfService.saveForest(forest);
        return "list_elves?faces-redirect=true";
    }
}
