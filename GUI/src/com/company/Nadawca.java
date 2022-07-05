package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Nadawca {
    private final String Imie;
    private final String Nazwisko;
    private String PESEL;
    private String Adres;


    public Nadawca(String Imie, String Nazwisko, String pesel, String adres){
        this.Imie=Imie;
        this.Nazwisko=Nazwisko;
        this.PESEL=pesel;
        if(PESEL.length()!=11) System.err.println("ERROR:PESEL MUSI MIEC 11 ZNAKOW");
        this.Adres=adres;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public String getImie() {
        return Imie;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getAdres() {
        return Adres;
    }

    public LocalDate getDateBirth(){
        String year = Character.toString(PESEL.charAt(0))+Character.toString(PESEL.charAt(1));
        if(Integer.parseInt(year)>=22){
            year = "19"+year;
        } else year = "20"+year;

        String month = Character.toString(PESEL.charAt(2))+Character.toString(PESEL.charAt(3));
        String day = Character.toString(PESEL.charAt(4))+Character.toString(PESEL.charAt(5));
        LocalDate date = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
        return date;
    }



    @Override
    public String toString(){
        return "Nadawca: "+ Imie + " " + Nazwisko + " , adres: "+ getAdres() + " , data urodzenia: "+ getDateBirth();
    }
}
