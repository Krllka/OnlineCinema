package backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "awards")
public class Awards extends AbstractEntity{
    @Column(name = "Name")
    private String name;
    @Column(name  = "Nomination")
    private String nominat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNominat() {
        return nominat;
    }

    public void setNominat(String nominat) {
        this.nominat = nominat;
    }
}
