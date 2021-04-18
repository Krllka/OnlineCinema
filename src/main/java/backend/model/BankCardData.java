package backend.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bankcard")
public class BankCardData extends AbstractEntity {

    @Column(name = "Accounts_ID")
    private int acc_id;
    @Column(name = "Number")
    private String number;
    @Column(name = "Banks_ID")
    private String bank;
    @Column(name = "Month_Year")
    private Date date;

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
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
