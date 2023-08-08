package EntitiesPersonas;

public class Person {
    protected String name;
    protected String LastName;
    protected int phone;
    protected String email;
    protected int accountNumber;

    public Person() {
    }

    public Person(String name, String lastName, int phone, String email, int accountNumber) {
        this.name = name;
        LastName = lastName;
        this.phone = phone;
        this.email = email;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
