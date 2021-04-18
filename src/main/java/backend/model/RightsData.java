package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "rights")
public class RightsData extends AbstractEntity{

    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;


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
}
