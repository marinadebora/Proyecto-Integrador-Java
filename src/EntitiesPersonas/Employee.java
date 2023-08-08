package EntitiesPersonas;

import EntitiesPersonas.Person;

public class Employee extends Person {
    protected int ID;
    protected String address;

    public Employee() {
    }

    public Employee(String name, String lastName, int phone, String email, int accountNumber, int ID, String address) {
        super(name, lastName, phone, email, accountNumber);
        this.ID = ID;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
