package backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "prod_by")
public class ProdByData extends AbstractEntity{
    @Column(name = "Name")
    private String name;
    @Column(name  = "Birth")
    private Date age;
    @ManyToOne
    @JoinColumn(name = "professions_ID", foreignKey = @ForeignKey(name = "fk_Prod.By_professions1_idx"))
    private ProfessionsData prof;
    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_Prod.By_Products1_idx"))
    private ProductsData prod;
    @JsonIgnore
    public ProductsData getProd() {
        return prod;
    }


    public void setProd(String prod) {
        this.prod = new ProductsData(prod);
        this.prod.setName(prod);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public ProfessionsData getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = new ProfessionsData(prof);
        this.prof.setName(prof);
    }


}