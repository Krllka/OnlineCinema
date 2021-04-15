package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "sex")
public class SexData extends AbstractEntity {


    @Column(name = "Name")
    private String name;

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }
}
