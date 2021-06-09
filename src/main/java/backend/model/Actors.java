package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "actors")
public class Actors extends AbstractEntity{

    @Column(name = "Name")
    String name;
    @ManyToOne
    @JoinColumn(name = "professions_ID", foreignKey = @ForeignKey(name = "fk_actors_professions_idx"))
    private ProfessionsData prof;
    public  Actors(){}
    public  Actors(String s){
        super(s);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfessionsData getSex() {
        return prof;
    }

    public void setSex(ProfessionsData sex) {
        this.prof = prof;
    }
}
