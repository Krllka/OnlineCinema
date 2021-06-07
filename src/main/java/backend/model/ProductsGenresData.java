package backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "products_has_genre")
public class ProductsGenresData extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "Genre_ID", foreignKey = @ForeignKey(name = "fk_Products_has_Genre_Genre1_idx") )
    private GenreData genre;
    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_Products_has_Genre_Products1_idx") )
    private ProductsData prod;

    public GenreData getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = new GenreData(genre);
        this.genre.setName(genre);
    }

    public ProductsData getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = new ProductsData(prod);
        this.prod.setName(prod);
    }
    public boolean equals(ProductsGenresData genre){
        return  this.genre.getId().equals(genre.getGenre().getId())
                & this.prod.getId().equals(genre.getProd().getId());
    }

}
