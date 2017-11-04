package pl.gda.pg.eti.kask.javaee.jsf.view;

import pl.gda.pg.eti.kask.javaee.jsf.ElfService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import pl.gda.pg.eti.kask.javaee.jsf.entities.Elf;
import pl.gda.pg.eti.kask.javaee.jsf.entities.Forest;

@ViewScoped
@ManagedBean
public class ListForests implements Serializable {

    @ManagedProperty("#{elfService}")
    private ElfService elfService;

    public void setElfService(ElfService elfService) {
        this.elfService = elfService;
    }
    private List<Forest> forests;
    
    public List<Forest> getForests() {
        if (forests == null) {
            forests = elfService.findAllLasy();
        }
        return forests;
    }

    public String removeElf(Elf elf) {
        elfService.removeElf(elf);
        return "list_elves?faces-redirect=true";
    }
    
    public String removeForest(Forest forest) {
        elfService.removeForest(forest);
        forests.remove(forest);
        return "list_elves?faces-redirect=true";
    }
}
