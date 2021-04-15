package backend.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table( name = "accounts")
public class AccountData  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name  = "BitrthDay")
    private Date age;
    @Column(name  = "Sex_ID")
    private int Sex;
    @Column(name  = "mail")
    private String mail;
    @Column(name  = "password")
    private String password;

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountData() {

    }

    public AccountData(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }






}