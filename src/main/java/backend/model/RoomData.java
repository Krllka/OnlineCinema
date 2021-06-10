package backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class RoomData extends AbstractEntity{
    @Column(name = "Name")
    private String name;
    @Column(name = "description")
    private String decription;
    @Column(name = "password")
    private String pass;

    public RoomData(){}
    public RoomData(String s){super(s);}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
