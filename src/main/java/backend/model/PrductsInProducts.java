package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "orders_has_products")
public class PrductsInProducts extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "Orders_ID", foreignKey = @ForeignKey(name = "fk_Orders_has_Products_Orders1_idx") )
    private Order client;
    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_Orders_has_Products_Products1_idx") )
    private ProductsData product;
    @Column(name = "Price")
    private double price;

}
