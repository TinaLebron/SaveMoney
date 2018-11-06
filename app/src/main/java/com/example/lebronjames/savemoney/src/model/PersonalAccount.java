package com.example.lebronjames.savemoney.src.model;

public class PersonalAccount {
    private int id;
    private int saving;
    private String date;
    private int total;

    public PersonalAccount() {}

    public PersonalAccount(int saving, String date) {
        this.saving = saving;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
