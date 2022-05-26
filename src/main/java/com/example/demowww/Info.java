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

    @Column(name="Category")
    private String Category;

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

    public String getCategory(){ return Category;}

    public void setCategory(String category){Category=category;}

    public Info(String title, String description, String date,String category) {
        Title = title;
        Description = description;
        Date = date;
        Category=category;
    }
}
