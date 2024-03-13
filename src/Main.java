//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Иванов Иван Иванович", 100000, 1);
        employees[1] = new Employee("Иванов Петр Иванович", 50000, 2);
        employees[2] = new Employee("Иванов Сергей Иванович", 60000, 3);
        employees[3] = new Employee("Иванов Андрей Иванович", 70000, 4);
        employees[4] = new Employee("Иванов Алексей Иванович", 80000, 5);
        employees[5] = new Employee("Иванов Максим Иванович", 90000, 1);
        employees[6] = new Employee("Иванов Павел Иванович", 45000, 2);
        employees[7] = new Employee("Иванов Владислав Иванович", 55000, 3);
        employees[8] = new Employee("Иванов Станислав Иванович", 65000, 4);
        employees[9] = new Employee("Иванов Яков Иванович", 75000, 5);

        printEmployees();
        printFullName();
        System.out.println("Сумма зарплат всех сотрудников: " + calculateTotalSalary() + " рублей.");;
        findMinimalSalaryEmployee();
        findMaximalSalaryEmployee();
        System.out.println("Средняя зарплата всех сотрудников: " + calculateAverageSalary() + " рублей.");
    }

    private static void printEmployees() {
        for (int i = 0; i < employees.length; i++) {

        System.out.println(employees[i].toString());
    }
    }

    private static void printFullName() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getFullName() + ".");
        }
    }
    private static int calculateTotalSalary() {
        int totalSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            totalSalary = totalSalary + employees[i].getSalary();
        }
        //System.out.println("Сумма зарплат всех сотрудников за месяц = " + totalSalary + " рублей.");
        return totalSalary;
    }
    private static void findMinimalSalaryEmployee() {
        int loserSalary = employees[0].getSalary();
        Employee loserEmployee = new Employee("",1,1);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < loserSalary) {
                loserSalary = employees[i].getSalary();
                loserEmployee = employees[i];
            }
        }
        System.out.println("Сотрудник с минимальной заработной платой " + loserEmployee.getSalary() + " рублей : " + loserEmployee.getFullName() + ".");
    }
    private static void findMaximalSalaryEmployee() {
        int bestSalary = employees[0].getSalary();
        Employee bestEmployee = new Employee("",1,1);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= bestSalary) {
                bestSalary = employees[i].getSalary();
                bestEmployee = employees[i];
            }
        }
        System.out.println("Сотрудник с максимальной заработной платой " + bestEmployee.getSalary() + " рублей : " + bestEmployee.getFullName() + ".");
    }

    private static int calculateAverageSalary() {
        int averageSalary = 0;
        averageSalary = calculateTotalSalary() / employees.length;
        //System.out.println(averageSalary);
        return averageSalary;
    }
}