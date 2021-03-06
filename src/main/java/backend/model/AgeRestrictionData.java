package backend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "age_restriction")
public class AgeRestrictionData extends AbstractEntity{
    @Column(name = "Name")
    String name;
    @Column(name = "Description")
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AgeRestrictionData(String id){ super(id);}
    public AgeRestrictionData(){}
}
