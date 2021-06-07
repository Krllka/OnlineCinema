package backend.model;

import backend.View.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public abstract class AbstractEntity {
    @JsonView(Views.Entity.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public  AbstractEntity(){
    }
    public AbstractEntity(String id){
        this.id = id;
    }
}
