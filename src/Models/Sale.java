package Models;

public class Sale extends Box  {
    protected String product;

    protected double price;
    protected int units;
    int count;


    public Sale() {
    }

    public Sale(String product, double price, int units,int count) {
        this.product = product;
        this.price = price;
        this.units = units;



    }

    public Sale(String date, double total, String product, double price, int units) {
        super(date, total);
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



}
