package backend.model;

import javax.persistence.*;

@MappedSuperclass
public class AbstractEntity {
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
    AbstractEntity(){

    }
    AbstractEntity(int id){
        super();
        this.id = id;
    }
}
