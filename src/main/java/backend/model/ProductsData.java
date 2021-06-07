package backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "products")
public class ProductsData extends AbstractEntity {

    @Column(name = "Name")
    private String name;
    @Column(name = "DateRelese")
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy")
    private Date releseDate;
    @Column(name = "Duration")
    private int durat;
    @ManyToOne
    @JoinColumn(name = "age_restriction_ID", foreignKey = @ForeignKey(name = "fk_Products_Raring1") )
    private AgeRestrictionData age_restr_id;

    @Column(name = "Views")
    private int viewsCount;
    @Column(name = "TrailerFile")
    private String trailer;
    @Column(name = "country")
    private String country;
    @Column(name = "description")
    private String decription;
    @Column(name = "PosterFile")
    private String poster;
    @Column(name = "Price")
    private double price;
    @Column(name = "Rating")
    private double  rate;


    public ProductsData(String id){
        super(id);
    }
    public ProductsData(){}


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getAge_restr_id() {
        return age_restr_id.getName();
    }

    public void setAge_restr_id(String age_restr_id) {
        this.age_restr_id = new AgeRestrictionData(age_restr_id);
        this.age_restr_id.setName(age_restr_id);

    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

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
