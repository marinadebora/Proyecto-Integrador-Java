package Dao.dto;

public class BoxDto {
    protected String date ;
    protected  double total;

    public BoxDto() {
    }

    public BoxDto(String date, double total) {
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
