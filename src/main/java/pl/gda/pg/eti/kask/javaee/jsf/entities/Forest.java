package pl.gda.pg.eti.kask.javaee.jsf.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "elfy")
@EqualsAndHashCode(exclude = "elfy")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "forests")
@NamedQuery(name = "Forest.findAll", query = "SELECT f FROM Forest f")
public class Forest implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tree_number")
    private int treeNumber;

    @OneToMany(mappedBy = "forest", orphanRemoval = true)
    private List<Elf> elfy;

}
