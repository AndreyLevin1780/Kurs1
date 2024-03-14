//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        double salaryGrowthPercentage = 20;
        double salaryGrowthPercentageByDepartament = 10;
        int departamentNumber = 2;
        double controlSalary = 90000;

        employees[0] = new Employee("Иванов Иван Иванович", 100000,1);
        employees[1] = new Employee("Иванов Петр Иванович", 50000, 2);
        employees[2] = new Employee("Иванов Сергей Иванович", 60000, 3);
        employees[3] = new Employee("Иванов Андрей Иванович", 70000, 4);
        employees[4] = new Employee("Иванов Алексей Иванович", 80000, 5);
        employees[5] = new Employee("Иванов Максим Иванович", 90000, 1);
        employees[6] = new Employee("Иванов Павел Иванович", 45000, 2);
        employees[7] = new Employee("Иванов Владислав Иванович", 55000, 3);
        employees[8] = new Employee("Иванов Станислав Иванович", 65000, 4);
        employees[9] = new Employee("Иванов Яков Иванович", 75000, 5);

        printEmployees(); //Полная печать
        printFullName(); //Печать только ФИО
        System.out.println("Сумма зарплат всех сотрудников: " + calculateTotalSalary() + " рублей."); //Сумма зарплат
        findMinimalSalaryEmployee(); //Сотрудник с минимальной з.п.
        findMaximalSalaryEmployee(); //Сотрудник с максимальной з.п.
        System.out.println("Средняя зарплата всех сотрудников: " + calculateAverageSalary() + " рублей."); //З.п. всех сотрудников

        adjustSalary(salaryGrowthPercentage); //Индексация з.п.
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Зарплата сотрудника " + employees[i].getFullName() + " после индексации составит: " + employees[i].getSalary() + " рублей.");
        }

        findMinimalSalaryEmployeeByDepartament(departamentNumber); //Сотрудник с минимальной з.п. по отделу
        findMaximalSalaryEmployeeByDepartament(departamentNumber); //Сотрудник с максимальной з.п. по отделу
        System.out.println("Сумма зарплат всех сотрудников в отделе " + departamentNumber + " " + calculateTotalSalarybyDepartament(departamentNumber) + " рублей."); //Сумма зарплат по отделу
        System.out.println("Средняя зарплата всех сотрудников в отделе " + departamentNumber + " " + calculateAverageSalaryByDepartament(departamentNumber) + " рублей."); //Средняя з.п. по отделу
        adjustSalaryByDepartament(salaryGrowthPercentageByDepartament, departamentNumber); //Индексация з.п. по отделу
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departamentNumber) {
                System.out.println("Зарплата сотрудника " + employees[i].getFullName() + " из отдела " + departamentNumber + " после индексации составит: " + employees[i].getSalary() + " рублей.");
            }
        }
        printEmployeesByDepartament(departamentNumber); //Печать всех данных сотрудников по отделу
        printEmployeesWithLessSalary(controlSalary); //Печать все сотрудников с з.п. меньше контрольной
        printEmployeesWithMoreSalary(controlSalary); //Печать все сотрудников с з.п. больше контрольной

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

    private static double calculateTotalSalary() {
        double totalSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            totalSalary = totalSalary + employees[i].getSalary();
        }
        return totalSalary;
    }

    private static void findMinimalSalaryEmployee() {
        double loserSalary = employees[0].getSalary();
        Employee loserEmployee = new Employee("", 1, 1);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < loserSalary) {
                loserSalary = employees[i].getSalary();
                loserEmployee = employees[i];
            }
        }
        System.out.println("Сотрудник с минимальной заработной платой " + loserEmployee.getSalary() + " рублей : " + loserEmployee.getFullName() + ".");
    }

    private static void findMaximalSalaryEmployee() {
        double bestSalary = employees[0].getSalary();
        Employee bestEmployee = new Employee("", 1, 1);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= bestSalary) {
                bestSalary = employees[i].getSalary();
                bestEmployee = employees[i];
            }
        }
        System.out.println("Сотрудник с максимальной заработной платой " + bestEmployee.getSalary() + " рублей : " + bestEmployee.getFullName() + ".");
    }

    private static double calculateAverageSalary() {
        double averageSalary = 0;
        averageSalary = calculateTotalSalary() / employees.length;
        return averageSalary;
    }

    private static void adjustSalary(double salaryGrowthPercentage) {
        double salaryGrowthCoefficient = salaryGrowthPercentage / 100 + 1; //Процент повышения / 100 + 1(100%)
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() * salaryGrowthCoefficient);
        }
    }

    private static void findMinimalSalaryEmployeeByDepartament(int departamentNumber) {
        double loserSalary = 0;
        Employee loserEmployee = new Employee("", 1, 1);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departamentNumber) {
                loserSalary = employees[i].getSalary();
                loserEmployee = employees[i];
                break;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departamentNumber && employees[i].getSalary() < loserEmployee.getSalary()) {
                loserSalary = employees[i].getSalary();
                loserEmployee = employees[i];
            }
        }
        System.out.println("Сотрудник с минимальной заработной платой в отделе " + departamentNumber +
                           " с зарплатой " + loserEmployee.getSalary() + " рублей : " +
                           loserEmployee.getFullName() + ".");
    }

    private static void findMaximalSalaryEmployeeByDepartament(int departamentNumber) {
        double bestSalary = 0;
        Employee BestEmployee = new Employee("", 1, 1);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departamentNumber) {
                bestSalary = employees[i].getSalary();
                BestEmployee = employees[i];
                break;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departamentNumber && employees[i].getSalary() >= BestEmployee.getSalary()) {
                bestSalary = employees[i].getSalary();
                BestEmployee = employees[i];
            }
        }
        System.out.println("Сотрудник с максимальной заработной платой в отделе " + departamentNumber +
                " с зарплатой " + BestEmployee.getSalary() + " рублей : " +
                BestEmployee.getFullName() + ".");
    }

    private static double calculateTotalSalarybyDepartament(int departamentNumber) {
        double totalSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departamentNumber) {
                totalSalary = totalSalary + employees[i].getSalary();
            }
        }
            return totalSalary;
    }

    private static double calculateAverageSalaryByDepartament(int departamentNumber) {
        double averageSalaryByDepartament = 0;
        int amountOfEmployeesInDepartament = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departamentNumber) {
                amountOfEmployeesInDepartament++;
            }
            averageSalaryByDepartament = calculateTotalSalarybyDepartament(departamentNumber) / amountOfEmployeesInDepartament;
        }
            return averageSalaryByDepartament;
    }
    private static void adjustSalaryByDepartament(double salaryGrowthPercentageByDepartament, int departamentNumber) {
        double salaryGrowthCoefficient = salaryGrowthPercentageByDepartament / 100 + 1; //Процент повышения / 100 + 1(100%)
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departamentNumber) {
                employees[i].setSalary(employees[i].getSalary() * salaryGrowthCoefficient);
            }
        }
    }

    private static void printEmployeesByDepartament(int departamentNumber) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departamentNumber) {
                System.out.println("ID = " + employees[i].getId() + ", ФИО: " + employees[i].getFullName() + ", Зарплата: " + employees[i].getSalary());
            }
        }
    }
    private static void printEmployeesWithLessSalary (double controlSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < controlSalary) {
                System.out.println("ID = " + employees[i].getId() + ", ФИО: " + employees[i].getFullName() + ", Зарплата: " + employees[i].getSalary());
            }
        }
    }
    private static void printEmployeesWithMoreSalary (double controlSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= controlSalary) {
                System.out.println("ID = " + employees[i].getId() + ", ФИО: " + employees[i].getFullName() + ", Зарплата: " + employees[i].getSalary());
            }
        }
    }
}