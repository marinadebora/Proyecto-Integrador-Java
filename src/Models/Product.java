package Models;

public class Product {
  private String name;
  private String brand;
  private  Double price;

  public Product() {
  }

  public Product(String name, String brand, Double price) {
    this.name = name;
    this.brand = brand;
    this.price = price;
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
}
