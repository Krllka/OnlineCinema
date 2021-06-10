package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "orders_has_products")
public class ProductsInOrder extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "Orders_ID", foreignKey = @ForeignKey(name = "fk_Orders_has_Products_Orders1_idx") )
    private Order order;
    @ManyToOne
    @JoinColumn(name = "Products_ID", foreignKey = @ForeignKey(name = "fk_Orders_has_Products_Products1_idx") )
    private ProductsData prod;
    @Column(name = "Price")
    private double price;

    public  ProductsInOrder(){
        super();
    }
    public  ProductsInOrder(String id){
        super(id);
    }


    public String getOrder() {
        return order.getId();
    }
    public void setOrder(String order) {
        this.order = new Order(order);
    }

    public String getProduct() {
        return prod.getName();
    }
    public ProductsData getProductObj() {
        return prod;
    }

    public void setProduct(String  prod) {

        this.prod = new ProductsData(prod);
        this.prod.setName(prod);
    }
    public void setProduct(ProductsData  prod) {
            this.prod = prod;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
