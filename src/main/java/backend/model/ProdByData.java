package backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "prod_by")
public class ProdByData extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name = "Actors_ID", foreignKey = @ForeignKey(name = "fk_Prod.By_actorss1"))
    private Actors prof;
    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_Prod.By_Products1_idx"))
    private ProductsData prod;


    public String getProf() {
        return prof.getName();
    }

    public void setProf(Actors prof) {
        this.prof = prof;
    }
    public void setProf(String prof) {
        this.prof = new Actors(prof);
        this.prof.setName(prof);
    }
    @JsonIgnore
    public ProductsData getProdObj() {
        return prod;
    }

    public String getProd() {
        return prod.getName();
    }

    public void setProd(ProductsData prod) {
        this.prod = prod;
    }
    public void setProd(String prod) {
        this.prod = new ProductsData(prod);
        this.prod.setName(prod);
    }
}
