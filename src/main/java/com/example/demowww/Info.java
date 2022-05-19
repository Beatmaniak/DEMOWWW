package com.example.demowww;

public class Info {
    private String Title;
    private String Description;
    private String Date;
    private int Kategoria_id;

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
