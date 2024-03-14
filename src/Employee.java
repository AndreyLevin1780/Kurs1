public class Employee {

    private String fullName;
    private double salary;
    private int department;
    private int id;
    private static int counter = 1;

    public Employee(String fullName, double salary, int department) {
        this.id = counter++;
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "ID = " + id +
                ", ФИО = " + fullName +
                ", Зарплата = " + salary +
                ", Отдел = " + department + "."
                ;
    }
}
