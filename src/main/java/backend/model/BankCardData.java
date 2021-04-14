package backend.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "BANKCARD")
public class BankCardData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Accouts_ID")
    private int id;
    @Column(name = "number")
    private String number;
    @Column(name = "Banks_ID")
    private String bank;
    @Column(name = "Month/Year")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
