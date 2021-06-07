package backend.model;
import backend.View.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "basketnlibrary")
public class Library extends AbstractEntity{

    @JsonView(Views.Entity.class)
    @ManyToOne
    @JoinColumn(name = "Accouts_ID", foreignKey = @ForeignKey(name = "fk_Accouts_has_Products_Accouts1_idx") )
    private AccountData client;

    @JsonView(Views.Entity.class)
    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_BasketNLibrary_Products1_idx") )
    private ProductsData product;

    @JsonView(Views.Entity.class)
    @Column(name = "purchased")
    private Boolean purchased;

    public String getClient() {
        return client.getName();
    }

    public AccountData getClientObj() {
        return client;
    }

    public void setClient(String client) {
        this.client = new AccountData(client);
        this.client.setName(client);
    }


    public String getProduct() {
        return product.getName();
    }

    public ProductsData getProductObj() {
        return product;
    }

    public void setProduct(String product) {
        this.product = new ProductsData(product);
        this.product.setName(product);
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }
}
