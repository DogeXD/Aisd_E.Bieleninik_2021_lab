package Zad1;

public class Student {
    private int nrIndeksu;
    private String nazwisko;
    private String imie;
    private double ocena;

    public Student(int nrIndeksu, String nazwisko, String imie, double ocena) {
        this.nrIndeksu = nrIndeksu;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.ocena = ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public double getOcena() {
        return ocena;
    }

    @Override
    public String toString() {
        return nrIndeksu +" "+  nazwisko +" "+  imie  +" "+ ocena;
    }
}
