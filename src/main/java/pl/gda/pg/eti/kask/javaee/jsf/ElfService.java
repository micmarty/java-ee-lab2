package pl.gda.pg.eti.kask.javaee.jsf;

import java.io.Serializable;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import lombok.extern.java.Log;
import pl.gda.pg.eti.kask.javaee.jsf.entities.Elf;
import pl.gda.pg.eti.kask.javaee.jsf.entities.Forest;


@ManagedBean
@ViewScoped
@Log
public class ElfService implements Serializable {

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction utx;

    public ElfService() {
    }
    
    public List<Elf> findAllElfy() {
        return em.createNamedQuery("Elf.findAll").getResultList();
    }

    public Elf findElf(int id) {
        return em.find(Elf.class, id);
    }
    
    public void removeElf(Elf elf) {
        try {
            utx.begin();
            elf = em.merge(elf);
            em.remove(elf);
            utx.commit();
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
            try {
                utx.rollback();
            } catch (Exception ex1) {
                log.log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void saveElf(Elf elf) {
        try {
            utx.begin();
            if (elf.getId() == null) {
                em.persist(elf);
            } else {
                em.merge(elf);
            }
            utx.commit();
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
            try {
                utx.rollback();
            } catch (Exception ex1) {
                log.log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public List<Forest> findAllLasy() {
        return em.createNamedQuery("Forest.findAll").getResultList();
    }

    public Forest findForest(int id) {
        return em.find(Forest.class, id);
    }
    
    public void removeForest(Forest forest) {
        try {
            utx.begin();
            forest = em.merge(forest);
            em.remove(forest);
            utx.commit();
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
            try {
                utx.rollback();
            } catch (Exception ex1) {
                log.log(Level.SEVERE, null, ex1);
            }
        }
    }    
    
    public void saveForest(Forest forest) {
        try {
            utx.begin();
            if (forest.getId() == null) {
                em.persist(forest);
            } else {
                em.merge(forest);
            }
            utx.commit();
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
            try {
                utx.rollback();
            } catch (Exception ex1) {
                log.log(Level.SEVERE, null, ex1);
            }
        }
    }
    
//    public void saveForest(Forest forest) {
//        if (forest.getId() == 0) {
//            if(forests.isEmpty()) {
//                forest.setId(1);
//            } else {
//                forest.setId(forests.lastKey() + 1);
//            }
//        }
//        forests.put(forest.getId(), forest);
//    }
    
//    public void removeForest(Forest forest) {
//        forests.remove(forest.getId());
//    }
}
