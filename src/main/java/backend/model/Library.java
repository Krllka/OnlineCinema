package backend.model;
import javax.persistence.*;

@Entity
@Table(name = "basketnlibrary")
public class Library extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "Accouts_ID", foreignKey = @ForeignKey(name = "fk_Accouts_has_Products_Accouts1_idx") )
    private AccountData client;
    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_BasketNLibrary_Products1_idx") )
    private ProductsData product;
    @Column(name = "purchased")
    private Boolean purchased;

    public String getClient() {
        return client.getName();
    }

    public void setClient(String client) {
        this.client = new AccountData(client);
        this.client.setName(client);
    }

    public String getProduct() {
        return product.getName();
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
