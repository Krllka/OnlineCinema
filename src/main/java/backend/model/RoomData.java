package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class RoomData extends AbstractEntity{
    @Column(name = "Name")
    private String name;
    @Column(name = "description")
    private String decription;
    @Column(name = "password")
    private String pass;
    @ManyToOne
    @JoinColumn(name = "Prod_ID", foreignKey = @ForeignKey(name = "Prod_ID") )
    private ProductsData prod;

    public ProductsData getProdObj() {
        return prod;
    }
    public String getProd() {
        return prod.getId();
    }

    public void setProd(ProductsData prod) {
        this.prod = prod;
    }
    public void setProd(String prod) {
        this.prod = new ProductsData(prod);
    }

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
