package web.model;


public class Employee {
    private String firstName;
    private String secondName;
    private String position;
    private String department;
    private String mail;

    public Employee() {}

    public Employee(String firstName, String secondName, String position, String department, String mail) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.position = position;
        this.department = department;
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
