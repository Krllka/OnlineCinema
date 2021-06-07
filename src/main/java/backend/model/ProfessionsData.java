package backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "professions")
public class ProfessionsData extends AbstractEntity{
    @Column(name = "Name")
    String name;

    public ProfessionsData() {

    }
    public ProfessionsData(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
