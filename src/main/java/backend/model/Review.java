package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review extends AbstractEntity{
    @Column(name = "Text")
    private String text;
    @Column(name  = "Rating")
    private int rating;
    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_Review_Products1_idx") )
    private ProductsData prod;
    @ManyToOne
    @JoinColumn(name = "Accouts_ID", foreignKey = @ForeignKey(name = "fk_Review_Accouts1_idx") )
    private AccountData acc;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ProductsData getProd() {
        return prod;
    }

    public void setProd(ProductsData prod) {
        this.prod = prod;
    }
    public void setProd(String prod) {
        this.prod = new ProductsData(prod);
    }

    public AccountData getAcc() {
        return acc;
    }

    public void setAcc(AccountData acc) {
        this.acc = acc;
    }
    public void setAcc(String acc) {
        this.acc = new AccountData(acc);
    }
}
