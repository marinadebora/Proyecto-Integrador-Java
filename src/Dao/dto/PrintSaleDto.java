package Dao.dto;


public class PrintSaleDto {
  private int units;
  private int product_id;
  private String name;
  private String brand;
  private  Double price;

  public PrintSaleDto() {
  }

  public PrintSaleDto( int units, int product_id, String name, String brand, Double price) {
    this.units = units;
    this.product_id = product_id;
    this.name = name;
    this.brand = brand;
    this.price = price;
  }

  public int getUnits() {
    return units;
  }

  public void setUnits(int units) {
    this.units = units;
  }

  public int getProduct_id() {
    return product_id;
  }

  public void setProduct_id(int product_id) {
    this.product_id = product_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }


  @Override
  public String toString() {
    return units +" "+ name +" (" + product_id +") "+ brand + " " + "$ " + price ;
  }
}
