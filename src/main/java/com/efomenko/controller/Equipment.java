package com.efomenko.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Equipment {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty serialNumber;
    private StringProperty status;
    private StringProperty description;
    private StringProperty dateStart;
    private StringProperty dateFinish;
    public Equipment (Integer id, String name,String status, String serialNumber, String description, String dateStart, String dateFinish){
        this.id = new SimpleIntegerProperty(this,"ID", id);
        this.name= new SimpleStringProperty(this,"Name", name);
        this.serialNumber = new SimpleStringProperty(this,"S/N",serialNumber);
        this.status = new SimpleStringProperty(this,"Status",status);
        this.description = new SimpleStringProperty(this,"Description",description);
        this.dateStart = new SimpleStringProperty(this,"StartDate",dateStart);
        this.dateFinish = new SimpleStringProperty(this,"FinishDate",dateFinish);
    }
    /*----------ID--------------*/
    public void setId(Integer value){
        id.set(value);
    }
    public Integer getId(){
        return id.get();
    }
    public IntegerProperty idProperty(){
        return id;
    }
    /*--------------Name-------------------------*/
    public void setName(String value){
        name.set(value);
    }
    public String getName(){
        return name.get();
    }
    public StringProperty nameProperty(){
        return name;
    }
    /*---------------SerialNumber------------------------*/
    public void setSerialNumber(String value){
        serialNumber.set(value);
    }
    public String getSerialNumber(){
        return serialNumber.get();
    }
    public StringProperty serialNumberProperty(){
        return serialNumber;
    }
    /*---------------status------------------------*/
    public void setStatus(String value){
        status.set(value);
    }
    public String getStatus(){
        return status.get();
    }
    public StringProperty statusProperty(){
        return status;
    }
    /*------------------Describtion---------------------*/
    public void setDescribtion(String value){
        description.set(value);
    }
    public String getDescription(){
        return description.get();
    }
    public StringProperty stringProperty(){
        return description;
    }
    /*-----------------dateStart----------------------*/
    public void setDateStart(String value){
        dateStart.set(value);
    }
    public String getDateStart(){
        return dateStart.get();
    }
    public StringProperty dateStartProperty(){
        return dateStart;
    }
    /*-----------------dateFinish----------------------*/
    public void setDateFinish(String value){
        dateFinish.set(value);
    }
    public String getDateFinish(){
        return dateFinish.get();
    }
    public StringProperty dateFinishProperty(){
        return dateFinish;
    }
    /*---------------------------------------*/
    @Override
    public String toString(){
        return "Equipment [id="+id.get()+", name="+ name.get()+", Serial Number=" + serialNumber.get() +", Status"+status.get()
        +", Describtion"+ description.get()+", StartDate="+dateStart.get()+", FinishDate"+dateFinish.get()+"]";
    }

}
