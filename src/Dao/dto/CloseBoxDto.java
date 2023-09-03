package Dao.dto;

public class CloseBoxDto {
  double price;
  double total;

  public CloseBoxDto() {
  }

  public CloseBoxDto(double price) {
    this.price = price;

  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getTotal() {
    return this.total + total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
}
