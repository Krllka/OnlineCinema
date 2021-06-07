package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "products_has_awards")
public class Prod_Awards extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_Products_has_Awards_Products1_idx") )
    private GenreData prod;
    @ManyToOne
    @JoinColumn(name = "Awards_ID", foreignKey = @ForeignKey(name = "fk_Products_has_Awards_Awards1_idx") )
    private Awards award;

    public GenreData getProd() {
        return prod;
    }

    public void setProd(GenreData prod) {
        this.prod = prod;
    }

    public Awards getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = new Awards();
        this.award.setName(award);
    }

    public  boolean equals(Prod_Awards awards){
        return this.award.getId().equals(awards.award.getId())
                &   this.prod.getId().equals(awards.prod.getId());
    }
}
