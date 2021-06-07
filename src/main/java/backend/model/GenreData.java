package backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "genre")
public class GenreData extends AbstractEntity{

    @Column(name = "Name")
    private String name;
    @Column(name  = "Description")
    private String description;

    public GenreData(String str){
        super(str);
    }
    public GenreData(){}

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
