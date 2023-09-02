package Dao.dto;

public class SaleDto extends  BoxDto{
    protected int product_id;

    protected double price;
    protected int units;

    public SaleDto() {
    }

    public SaleDto(int product_id, double price, int units) {
        this.product_id = product_id;
        this.price = price;
        this.units = units;
    }

    public SaleDto(String date, double total, int product_id, double price, int units) {
        super(date, total);
        this.product_id = product_id;
        this.price = price;
        this.units = units;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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
        return
             "codigo "+product_id + " Cantidad "+units +" Precio unitario $"+ price +" Total:  "+  total ;
    }
}
