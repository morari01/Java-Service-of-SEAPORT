package com.company;

import java.util.ArrayList;

public class Port {
    private Statek statek;
    private Kontener kontener;
    private String Nazwa;
    private int numer;
    static int count;

    ArrayList<Statek> statekList;

    public Port(String Nazwa)  {
        this.Nazwa=Nazwa;
        this.numer=++count;
        this.statekList=new ArrayList<>();
    }

    public void addStatek(Statek statek){
        this.statekList.add(statek);
    }

    public void deleteStatek(Statek statek){
        this.statekList.remove(statek);
    }

    public String getNazwa() {
        return Nazwa;
    }

    @Override
    public String toString() {
        return numer+ " Nazwa Portu: " + getNazwa() ;
    }
}
