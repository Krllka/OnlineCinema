package backend.model;


import backend.View.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table( name = "accounts")
public class AccountData extends AbstractEntity {
    @JsonView(Views.Entity.class)
    @Column(name = "Login")
    private String name;
    @Column(name  = "BirthDay")
    @JsonView(Views.Entity.class)
    private Date age;
    @JsonView(Views.Entity.class)
    @ManyToOne
    @JoinColumn(name = "sex_ID", foreignKey = @ForeignKey(name = "fk_Accouts_Sex"))
    private SexData Sex;
    @JsonView(Views.Entity.class)
    @Column(name  = "mail")
    private String mail;
    @JsonView(Views.Entity.class)
    @Column(name  = "password")
    private String password;
    @JsonView(Views.Entity.class)
    @Column(name  = "admin")
    private Boolean admin;

    public  AccountData(){}
    public  AccountData(String str){
        super(str);
    }

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

    public Boolean chekPass(String pass){ return this.password.equals(pass);}

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