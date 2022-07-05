package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Magazyn implements MagazynWagon {

    public final int maxIloscKontenerow;
    ArrayList<Kontener> listaPrzechowywanychKontenerow;
    ArrayList<Kontener> ostrzezenia;


    public Magazyn(int maxIloscKontenerow){
       this.maxIloscKontenerow=maxIloscKontenerow;
        this.listaPrzechowywanychKontenerow= new ArrayList<>(maxIloscKontenerow);
        this.ostrzezenia = new ArrayList<>();
    }

    public int getMaxIloscKontenerow() {
        return maxIloscKontenerow;
    }

    @Override
    public void magazunyjKontener(Kontener kontener){
        this.listaPrzechowywanychKontenerow.add(kontener);
    }

   /* public String CheckSize(ArrayList<Kontener> k) {
        String mes = null;
        if(k.size()>this.listaPrzechowywanychKontenerow.size()) {
            mes = "Ilosc kontenerow w magazynie przekraca max mozliwa liczbe";
        }
        else mes = "ok";
        return mes;
    }*/


    public void zMagazynuDoStatku(Statek statek, Kontener kontener) {
        boolean success = false;
        Kontener tmp = null;
        for(Kontener k : this.listaPrzechowywanychKontenerow){
            if(k.getNumer() == kontener.getNumer()){
                tmp=k;
                success=true;
            }
        }
        if(success){
            statek.zaladujKontener(tmp);
            this.listaPrzechowywanychKontenerow.remove(tmp);
        }
        else System.out.println("W magazynie nie ma konteneru numer: "+ kontener.getNumer());
    }


    public void aktualnyStanMagazynu(){
        for(Kontener k : this.listaPrzechowywanychKontenerow)
            System.out.println( "Numer konteneru: "+k.getNumer()+", Nadawca: "+k.getNadawca()+", Waga: "+k.getWagaBrutto()+'\n');

    }

    @Override
    public void utylizujKontener(Kontener kontener){
        this.listaPrzechowywanychKontenerow.remove(kontener);
    }


    @Override
    public String toString(){
        return "Maksymalna Ilosc kontenerow: "+ maxIloscKontenerow + ",\n " + listaPrzechowywanychKontenerow;
    }


    public int przechowywanieWybuchowych(){
        return 5;
    }

    public int przechowywanieToksycznych(){
        return 10;
    }

    public int przechowywanieToksycznychSypkich(){
        return 14;
    }



    //todo nie dziala
    public void sprawdzWaznoscKontenera() throws IrresponsibleSenderWithDangerousGoods {
        UplywCzasu u = new UplywCzasu(this.listaPrzechowywanychKontenerow, this);
        //Kontener tmp = null;
        KontenerToksyczny t=null;


        for(Kontener k : this.listaPrzechowywanychKontenerow) {
            System.out.println("Sprawdzam waznosc przechowywania kontenera, numer: "+ k.getNumer() + " , typ konteneru: " + k.getClass().getSimpleName() + " ,ilosc dni przechowywania : " + k.getIloscDniPrzechowywania());

            if(k.getClass().getSimpleName().equals("KontenerWybuchowy")){
                if((przechowywanieWybuchowych()-k.getIloscDniPrzechowywania()<0)
                        &&(u.getCzas().getDayOfMonth()<this.przechowywanieWybuchowych())){
                    this.ostrzezenia.add(k);
                    utylizujKontener(k);
                    k.createListOstrezen(this.ostrzezenia);
                }
            }

            else if(k.getClass().getSimpleName().equals("KontenerToksyczny")){
                t= (KontenerToksyczny)k;
                if (t.getChemicznyMaterialSypki()==null) {
                    if((przechowywanieWybuchowych() - t.getIloscDniPrzechowywania() < 0)
                            && (u.getCzas().getDayOfMonth() < this.przechowywanieToksycznych())) {
                        ostrzezenia.add(k);
                        utylizujKontener(k);
                        k.createListOstrezen(this.ostrzezenia);
                    }
                }

                else {
                    if((przechowywanieWybuchowych() - t.getIloscDniPrzechowywania() < 0)
                            && (u.getCzas().getDayOfMonth() < this.przechowywanieToksycznychSypkich())) {
                        ostrzezenia.add(k);
                        utylizujKontener(k);
                        k.createListOstrezen(this.ostrzezenia);
                    }
                }
            }
            else System.out.println("*Zwykly kontainer*");

        }




    }

}
