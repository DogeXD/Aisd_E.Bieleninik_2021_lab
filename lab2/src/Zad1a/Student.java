package Zad1a;

public class Student {
    private int nrIndexu;
    private String nazwisko;
    private String imie;
    private double ocena;

    public Student(int nrIndexu, String nazwisko, String imie, double ocena) {
        this.nrIndexu = nrIndexu;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nrIndexu=" + nrIndexu +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", ocena=" + ocena +
                '}';
    }
    public void setOcena(double ocena){
        this.ocena = ocena;
    }
    public int getNrIndexu(){
        return this.nrIndexu;
    }
    public double getOcena(){
        return this.ocena;
    }
}
