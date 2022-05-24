package com.example.demowww;

import javax.persistence.*;

@Entity
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false,insertable = false)
    private Long id;
    @Column(name = "Title")
    private String Title;
    @Column(name = "Description")
    private String Description;
    @Column(name = "Date")
    private String Date;
    @Column(name = "kat_id")
    // @ForeignKey
    private int Kategoria_id;

    public Long getId(){
        return id;
    }

    protected Info() {

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getKategoria_id() {
        return Kategoria_id;
    }

    public void setKategoria_id(int kategoria_id) {
        Kategoria_id = kategoria_id;
    }

    public Info(String title, String description, String date) {
        Title = title;
        Description = description;
        Date = date;
    }
}
