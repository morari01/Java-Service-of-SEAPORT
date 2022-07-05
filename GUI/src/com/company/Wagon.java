package com.company;

import java.util.ArrayList;

public class Wagon implements MagazynWagon {
    int size;
    ArrayList<Kontener> listaKontenerowWWagonie;

    public Wagon(){
        this.size=10;
        this.listaKontenerowWWagonie= new ArrayList<>(size);
    }

    @Override
    public void magazunyjKontener(Kontener kontener) {
        this.listaKontenerowWWagonie.add(kontener);
    }

    @Override
    public void utylizujKontener(Kontener kontener){
        this.listaKontenerowWWagonie.remove(kontener);
    }


    public void aktualnyStanWagonu(){
        for(Kontener k : this.listaKontenerowWWagonie)
            System.out.println( "Numer konteneru: "+k.getNumer()+", Nadawca: "+k.getNadawca()+", Waga: "+k.getWagaBrutto()+'\n');
    }

    @Override
    public String toString(){
        return "\n"+listaKontenerowWWagonie;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //todo nie dziala
    public void sprawdzIloscKontenerow()  {
        for(Kontener k : this.listaKontenerowWWagonie) {

            System.out.println("Sprawdzam ilosc przechowywanych kontenerow:"+ listaKontenerowWWagonie.size());

            if(listaKontenerowWWagonie.size()>this.getSize()){
                System.out.println("Czekamy 30 sek na rozladowanie");
                utylizujKontener(k);
                setSize(this.listaKontenerowWWagonie.size()-1);
            }
        }
    }
}
