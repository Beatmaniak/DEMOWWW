package com.example.demowww;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_data")
public class User implements UserDetails {
    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SN",updatable = false)
    private Long sn;
    @Column(name = "Name")
    @Size(min=3,max=20,message = "Name has to be between 3 to 20 characters long")
    //@NotBlank(message = "Field must not be empty")
    private String name;
    @Column(name = "surname")
    @Size(min=3,max=50,message = "Surname has to be between 3 to 50 characters long")
    //@NotBlank(message = "Field must not be empty")
    private String surname;
    @Column(name = "login")
    @Size(min=3,max=20,message = "Login has to be between 3 to 20 characters long")
    //@NotBlank(message = "Field must not be empty")
    private String login;
    @Column(name = "password")
    @Size(min=5,message = "Password has to be at least 5 characters long")
    //@NotBlank(message = "Field must not be empty")
    private String password;
    @Column(name = "age")
    //@Range(min=18, max=999)
    //@NotEmpty(message="Field must not be empty")
    private int age;
    @Column(name = "AccNotLocked")
    private boolean notLocked;

    public User(Long sn, String name, String surname, String login, String password,int age,boolean notLocked) {
        this.sn = sn;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.age = age;
        this.notLocked = notLocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() && isNotLocked() == user.isNotLocked() && Objects.equals(getSn(), user.getSn()) && Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSn(), getName(), getSurname(), getLogin(), getPassword(), getAge(), isNotLocked());
    }

    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return notLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
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

    public boolean isNotLocked() {
        return notLocked;
    }

    public void setNotLocked(boolean notLocked) {
        this.notLocked = notLocked;
    }
}
