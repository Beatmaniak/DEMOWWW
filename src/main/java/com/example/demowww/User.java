package com.example.demowww;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name = "user_data")
public class User {
    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SN")
    private int sn;
    @Column(name = "Name")
    @Size(min=3,max=20,message = "Name has to be between 3 to 20 characters long")
    @NotBlank(message = "Field must not be empty")
    private String name;
    @Column(name = "surname")
    @Size(min=3,max=50,message = "Surname has to be between 3 to 50 characters long")
    @NotBlank(message = "Field must not be empty")
    private String surname;
    @Column(name = "login")
    @Size(min=3,max=20,message = "Login has to be between 3 to 20 characters long")
    @NotBlank(message = "Field must not be empty")
    private String login;
    @Column(name = "password")
    @Size(min=5,message = "Password has to be at least 5 characters long")
    @NotBlank(message = "Field must not be empty")
    private String password;
    @Column(name = "age")
    @Min(value=18,message = "To create and account you must to be 18 or above")
    @NotBlank(message = "Field must not be empty")
    private int age;

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
