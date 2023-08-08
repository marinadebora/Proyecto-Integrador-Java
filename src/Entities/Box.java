package Entities;

import java.util.Date;

public abstract class Box {
protected String date = new Date().toString();
protected  double total;
protected  String description;



    public Box() {
    }

    public Box(String date, double total, String description) {
        this.date = date;
        this.total = total;
        this.description = description;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public   double calculateTotal(double price,double amount){
        this.total= price * amount;
        return this.total;
    };

}
