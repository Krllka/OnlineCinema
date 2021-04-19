package backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "products")
public class ProductsData extends AbstractEntity {

    @Column(name = "Name")
    private String name;
    @Column(name = "DateRelese")
    private Date releseDate;
    @Column(name = "Duration")
    private int durat;
    @Column(name = "Rating_ID")
    private int rating_id;
    @Column(name = "Views")
    private int viewsCount;
    @Column(name = "TrailerFile")
    private String trailer;
    @Column(name = "PosterFile")
    private String  poster;
    @Column(name = "Price")
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleseDate() {
        return releseDate;
    }

    public void setReleseDate(Date releseDate) {
        this.releseDate = releseDate;
    }

    public int getDurat() {
        return durat;
    }

    public void setDurat(int durat) {
        this.durat = durat;
    }

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
