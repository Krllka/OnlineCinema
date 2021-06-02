package backend.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity{
    @Column(name = "Date")
    private Date date;
    @Column(name = "TotalPrice")
    private double price;
    @Column(name = "Accouts_ID")
    private String client;
    @ManyToOne
    @JoinColumn(name = "OrderStatus_ID", foreignKey = @ForeignKey(name = "fk_Orders_Order Status1_idx") )
    private OrderStatus status;

    public Date getAcc_ID() {
        return date;
    }

    public void setAcc_ID(Date acc_ID) {
        this.date = acc_ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getStatus() {
        return status.getName();
    }

    public void setStatus(String status) {
        this.status = new OrderStatus(status);
        this.status.setName(status);

    }
}
