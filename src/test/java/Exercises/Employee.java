package Exercises;

public class Employee {
    private String imie;
    private String nazwisko;
    private float wyplata;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public float getWyplata() {
        return wyplata;
    }

    public void setWyplata(float wyplata) {
        this.wyplata = wyplata;
    }

    public Employee(String imie, String nazwisko, float wyplata) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wyplata = wyplata;
    }

    @Override
    public String toString() {
        System.out.println("Salary for " + this.imie + " " + this.nazwisko + " is " + this.wyplata);
        return super.toString();
    }
}
