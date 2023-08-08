package Entities;

import Interfaces.CountInterface;

public class Sale extends Box implements CountInterface {
    protected String product;
    protected int count;
    protected double price;
    protected int units;


    public Sale() {
    }

    public Sale(String product, double price, int units) {
        this.product = product;
        this.price = price;
        this.units = units;



    }

    public Sale(String date, double total, String description, String product, double price, int units) {
        super(date, total, description);
        this.product = product;
        this.price = price;
        this.units = units;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }






    @Override
    public String toString() {
        return units + " "+ product + " " +  "  Precio unitario: $" + price ;
    }

    @Override
    public int createId() {
        return this.count +1 ;
    }
}
