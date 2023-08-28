package Dao.dto;

public class SaleDto extends  BoxDto{
    protected String product;

    protected double price;
    protected int units;

    public SaleDto() {
    }

    public SaleDto(String product, double price, int units) {
        this.product = product;
        this.price = price;
        this.units = units;
    }

    public SaleDto(String date, double total, String product, double price, int units) {
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
        return "Fecha: "+ date+ "\nCantidad: "+ units+ " Producto: "+product+ " Precio unitario "+ price+ "\nTotal "+ total ;
    }
}
