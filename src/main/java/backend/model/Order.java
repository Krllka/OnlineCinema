package backend.model;

import backend.View.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity{
    @JsonView(Views.Entity.class)
    @Column(name = "Date")
    private Date date;
    @JsonView(Views.Entity.class)
    @Column(name = "TotalPrice")
    private double price;
    @JsonView(Views.Entity.class)
    @ManyToOne
    @JoinColumn(name = "Accouts_ID", foreignKey = @ForeignKey(name = "fk_Orders_Accouts1_idx") )
    private AccountData client;
    @JsonView(Views.Entity.class)
    @ManyToOne
    @JoinColumn(name = "OrderStatus_ID", foreignKey = @ForeignKey(name = "fk_Orders_Order Status1_idx") )
    private OrderStatus status;

    public Order(){}
    public Order(String id) {super(id);}
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

    public AccountData getClientObj() {
        return client;
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
