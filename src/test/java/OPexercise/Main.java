package OPexercise;

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("Jan", "Kowalski", 4);
        Employee e2 = new Employee("Edyta", "Testowa", 4);
        Employee e3 = new Employee("Jakub", "Wielki", 4);
        Employee e4 = new Employee("Kazimierz", "Walezy", 4);

        Company company = new Company();

        company.addEmployee(e1);
        company.addEmployee(e2);
        company.addEmployee(e3);
        company.addEmployee(e4);

        System.out.println("[SUM] : " + company.getSum());
        System.out.println("[AVG] : " + company.getAvr());

        company.printEmployees();
    }
}