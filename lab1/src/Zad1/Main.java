package Zad1;

public class Main {
    public static void main(String[] args){
        Studenci studenci = new Studenci();
        studenci.wczytaj();
        studenci.wyswietl();
        studenci.sredniaOcenPozytywnych();
        studenci.nieZaliczyli();
        studenci.zmienOcene("Samulski","Jakub",4.0);
        studenci.zmienOcene("Mickiewicz","Adam",5.5);
        studenci.wyswietl();
        studenci.sredniaOcenPozytywnych();
        studenci.nieZaliczyli();
        studenci.zapisz();

    }
}
