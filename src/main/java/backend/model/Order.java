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
    @ManyToOne
    @JoinColumn(name = "Accouts_ID", foreignKey = @ForeignKey(name = "fk_Orders_Accouts1_idx") )
    private AccountData client;
    @ManyToOne
    @JoinColumn(name = "OrderStatus_ID", foreignKey = @ForeignKey(name = "fk_Orders_Order Status1_idx") )
    private OrderStatus status;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setClient(AccountData client) {
        this.client = client;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClient() {
        return client.getName();
    }

    public void setClient(String client) {
        this.client = new AccountData(client);
        this.client.setName(client);
    }

    public String getStatus() {
        return status.getName();
    }

    public void setStatus(String status) {
        this.status = new OrderStatus(status);
        this.status.setName(status);

    }
}
