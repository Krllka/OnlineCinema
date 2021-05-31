package backend.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table( name = "accounts")
public class AccountData extends AbstractEntity {

    @Column(name = "Login")
    private String name;
    @Column(name  = "BirthDay")
    //@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date age;
    @ManyToOne
    @JoinColumn(name = "sex_ID", foreignKey = @ForeignKey(name = "fk_Accouts_Sex"))
    private SexData Sex;
    @Column(name  = "mail")
    private String mail;
    @Column(name  = "password")
    private String password;
    @Column(name  = "admin")
    private Boolean admin;

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return Sex.getName();
    }

    public void setSex(String sex) {
        this.Sex = new SexData(sex);
        this.Sex.setName(sex);
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
        super();
    }



    public void setSex(SexData sex) {
        Sex = sex;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }



}