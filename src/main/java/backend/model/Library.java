package backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "basketnlibrary")
public class Library extends AbstractEntity{

    @Column(name = "Accouts_ID")
    private String acc_ID;
    @Column(name = "Products_ID")
    private String prod_ID;
    @Column(name = "purchased")
    private Boolean purchased;

    public String getAcc_ID() {
        return acc_ID;
    }

    public void setAcc_ID(String acc_ID) {
        this.acc_ID = acc_ID;
    }

    public String getProd_ID() {
        return prod_ID;
    }

    public void setProd_ID(String prod_ID) {
        this.prod_ID = prod_ID;
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }
}
