package com.kainos.ea.employees;

public class TechnicalEmployee extends Employee{
    private String cv;
    private String photo;

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
