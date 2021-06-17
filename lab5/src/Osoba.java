package Zad1;
//Jakub Samulski 260407
public class Osoba {
    private String nazwisko;
    private String imie;
    private  int rokUrodzenia;

    public Osoba(String nazwisko, String imie, int rokUrodzenia) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
    }

    @Override
    public String toString() {
        return nazwisko+ " "+imie+ " "+rokUrodzenia;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }
}
