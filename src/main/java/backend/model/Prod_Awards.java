package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "products_has_awards")
public class Prod_Awards extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_Products_has_Awards_Products1_idx") )
    private ProductsData prod;
    @ManyToOne
    @JoinColumn(name = "Awards_ID", foreignKey = @ForeignKey(name = "fk_Products_has_Awards_Awards1_idx") )
    private Awards award;

    public Prod_Awards(){}
    public Prod_Awards(Awards award, ProductsData prod){
        this.award = award;
        this.prod = prod;
    }

    public ProductsData getProd() {
        return prod;
    }

    public void setProd(ProductsData prod) {
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
