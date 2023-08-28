package Models;

import java.util.Date;

public abstract class Box {
protected String date = new Date().toString();
protected  double total;




    public Box() {
    }

    public Box(String date, double total) {
        this.date = date;
        this.total = total;


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




    public   double calculateTotal(double price,double amount){
        this.total= price * amount;
        return this.total;
    }

}
