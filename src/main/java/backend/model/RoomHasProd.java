package backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "rooms_has_products")
public class RoomHasProd extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "Rooms_ID", foreignKey = @ForeignKey(name = "fk_Rooms_has_Products_Products1_idx") )
    private RoomData room;
    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_Rooms_has_Products_Rooms1_idx") )
    private ProductsData prod;

    public RoomHasProd(){}
    public RoomHasProd(String s){super(s);}

    public RoomData getRoom() {
        return room;
    }

    public void setRoom(RoomData room) {
        this.room = room;
    }
    public void setRoom(String room) {
        this.room = new RoomData(room);
    }

    public String getProd() {
        return prod.getId();
    }
    @JsonIgnore
    public ProductsData getProdObj() {
        return prod;
    }

    public void setProd(ProductsData prod) {
        this.prod = prod;
    }
    public void setProd(String prod) {
        this.prod = new ProductsData(prod);
    }
}
