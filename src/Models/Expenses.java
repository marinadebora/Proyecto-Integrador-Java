package Models;

public class Expenses extends Box   {
    protected  String expenseType;
    protected String addressee;
    protected double amount;

    public Expenses() {
    }

    public Expenses(String date, double total,  String expenseType, String addressee, double amount) {
        super(date, total);
        this.expenseType = expenseType;
        this.addressee = addressee;
        this.amount = amount;
    }

    public Expenses(String expenseType, String addressee, double amount) {
        this.expenseType = expenseType;
        this.addressee = addressee;
        this.amount = amount;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
