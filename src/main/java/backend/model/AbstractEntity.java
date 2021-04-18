package backend.model;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public  AbstractEntity(){
    }
    public AbstractEntity(int id){
        this.id = id;
    }
}
