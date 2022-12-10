package Exercises;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> Employeelist = new ArrayList<>();

    public ArrayList<Employee> getEmployeelist() {
        return Employeelist;
    }

    public void setEmployeelist(ArrayList<Employee> employeelist) {
        Employeelist = employeelist;
    }

    public void addEmployee(Employee employee) {
        System.out.println("[INFO] Dodano pracownika: " + employee.getImie() + " do listy");
        Employeelist.add(employee);
    }

    public void printEmployees() {
        for (Employee employee : Employeelist) {
            employee.toString();
        }
    }

    public float getSum() {
        float sum = 0;

        for (Employee employee : this.Employeelist) {
            sum += employee.getWyplata();
        }
        return sum;
    }

    public float getAvr() {
        return getSum() / getEmployeelist().size();
    }


}