package ModelsPeople;

public class Suppliers extends People {
    protected String company;
    protected int cuit;

    public Suppliers() {
    }

    public Suppliers(String name, String lastName, int phone, String email, int accountNumber, String company, int cuit) {
        super(name, lastName, phone, email, accountNumber);
        this.company = company;
        this.cuit = cuit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
}
