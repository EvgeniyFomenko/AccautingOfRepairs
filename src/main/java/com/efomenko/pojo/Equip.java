package com.efomenko.pojo;


import javafx.beans.property.*;

import java.time.LocalDate;

public class Equip {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty serialNumber;
    private StringProperty status;
    private StringProperty description;
    private StringProperty dateStart;
    private StringProperty dateFinish;

    public Equip( Integer id, String name, String serialNumber, String status, String description,String dateStart,String dateFinish){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.serialNumber =new SimpleStringProperty(serialNumber);
        this.status = new SimpleStringProperty(status);
        this.description = new SimpleStringProperty(description);
        this.dateStart = new SimpleStringProperty(dateStart);
        this.dateFinish = new SimpleStringProperty (dateFinish);
    }
    public Equip(){
        this.name = new SimpleStringProperty("null");
        this.serialNumber =new SimpleStringProperty("null");
        this.status = new SimpleStringProperty("null");
        this.description = new SimpleStringProperty("null");
        this.dateStart = new SimpleStringProperty("null");
        this.dateFinish = new SimpleStringProperty ("null");
    }




    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSerialNumber() {
        return serialNumber.get();
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getDateStart() {
        return dateStart.get();
    }

    public void setDateStart(String dateStart) {
        this.dateStart.set(dateStart);
    }

    public String getDateFinish() {
        return dateFinish.get();
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish.set(dateFinish);
    }
}
