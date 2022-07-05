package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Statek {
    private final int numer;
    private final String Name;
    private final String PortMacierzysty;
    private final String startLok;
    private final String endLok;
    private final int maxToksycznychKontenerow;
    private final int maxCiezkichKontenerow;
    private final int maxPodlaczeniaSieci;
    private final int maxWszystkich;
    private int maxLadownosc;

    ArrayList<Kontener> kontenerList;

    static int count;

    public Statek(String Nazwa, String PortMacierzysty, String LokalizacjaZrodlowa, String LokalizacjaDocelowa,
                  int maxLiczbaToksycznych, int maxCiezkich, int maxWymagajacychPodlaczenia,int maxLiczbaWszystkich,
                  int maxLadownoscStatku) {
        this.Name=Nazwa;
        this.PortMacierzysty =PortMacierzysty;
        this.startLok=LokalizacjaZrodlowa;
        this.endLok=LokalizacjaDocelowa;
        this.maxToksycznychKontenerow =maxLiczbaToksycznych;
        this.maxCiezkichKontenerow =maxCiezkich;
        this.maxPodlaczeniaSieci=maxWymagajacychPodlaczenia;
        this.maxWszystkich=maxLiczbaWszystkich;
        this.maxLadownosc=maxLadownoscStatku;
        this.numer=++count;
        checkContainerCount();
        this.kontenerList=new ArrayList<>();
    }

    public void setMaxLadownosc(int maxLadownosc) {
        this.maxLadownosc = maxLadownosc;
    }

    public String getName() {
        return Name;
    }

    public int getNumer() {
        return numer;
    }

    public String getPortMacierzysty() {
        return PortMacierzysty;
    }

    public String getStartLok() {
        return startLok;
    }

    public String getEndLok() {
        return endLok;
    }

    public int getMaxToksycznychKontenerow() {
        return maxToksycznychKontenerow;
    }

    public int getMaxCiezkichKontenerow() {
        return maxCiezkichKontenerow;
    }

    public int getMaxPodlaczeniaSieci() {
        return maxPodlaczeniaSieci;
    }

    public int getMaxWszystkich() {
        return maxWszystkich;
    }

    public int getMaxLadownosc() {
        return this.maxLadownosc;
    }

//sprawdza czy waga kontenerow nie przekraca max ladownosci statku
    public int checkWeight(Kontener k){
        int w=0;
        int znacz;
        //for(Kontener kk: kontenerList)
            w += k.getWagaBrutto();
        if(w>this.getMaxLadownosc()) znacz=-1;
        else znacz=1;
        return znacz;
    }

//sprawdza czy ilosc kontenerow nie przekraca max
    public void checkContainerCount() {
        if(getMaxToksycznychKontenerow()+getMaxCiezkichKontenerow()+getMaxPodlaczeniaSieci()>getMaxWszystkich())
            System.err.println("Liczba kontenerow przekraca max mozliwa liczbe");
    }


    public void zaladujKontener(Kontener kontener) {
        CheckToxic();
        if(checkWeight(kontener)==1){
            this.kontenerList.add(kontener);
            setMaxLadownosc(this.maxLadownosc-kontener.getWagaBrutto());
        }
        else System.err.println("(zaladuj kontener)\nDla statku: "+ numer + " Waga kontenera " +kontener.getNumer() +" przekraca max lagownosc statku.");
    }


    public void CheckToxic(){
        boolean count = true;
        int count_wyb = 0;
        int count_toxic = 0;
        for(Kontener k : this.kontenerList){
            if(k.getClass().getSimpleName().equals("KontenerWybuchowy")) count_wyb++;
            if(k.getClass().getSimpleName().equals("KontenerToksyczny")) count_toxic++;
        }
        if((count_toxic + count_wyb )> this.getMaxToksycznychKontenerow()) count = false;
        if(!count) System.out.println("Niepoprawna liczba toksycznych lub wybuchowych kontenerow dla statku: " + this.getNumer());
    }


    public void rozladujKontenerDoMagazynu(Kontener kontener, Magazyn magazyn){
        boolean exist = false;
        if(this.kontenerList.contains(kontener)) exist = true;

        if(exist){
            if(magazyn.listaPrzechowywanychKontenerow.size()<magazyn.getMaxIloscKontenerow()){
                this.kontenerList.remove(kontener);
                magazyn.listaPrzechowywanychKontenerow.add(kontener);
            }
            else System.err.println("Nie ma miejsca! Kontener: "+kontener.getNumer() + " nie moze byc dodany!");
        }
        else System.err.println("Na statku: " + this.getNumer()  + " nie ma konteneru: " + kontener.getNumer());
    }


    public void rozladujKontenerDoWagonu(Kontener kontener, Wagon wagon) {
        if(wagon.listaKontenerowWWagonie.size()<wagon.size){
            this.kontenerList.remove(kontener);
            wagon.listaKontenerowWWagonie.add(kontener);
        }
        else System.err.println("Nie ma miejsca! Kontener: "+kontener.getNumer() + " nie moze byc dodany!");
    }


    @Override
    public String toString(){
        return "-------------------\n"+getNumer() + " Statek: " + getName() + ", \nport macierzysty: " + getPortMacierzysty() +
                ", \nlokalizacja źródłowa: " + getStartLok() + ", \nlokalizacja docelowa: " + getEndLok() +
                ", \nmaxLiczbaToksycznychKontenerow: " + getMaxToksycznychKontenerow() +  ", \nmaxLiczbaCiezkichKontenerow: "
                + getMaxCiezkichKontenerow() +  ", \nmaxWymagajacychPodlaczenia: " + getMaxPodlaczeniaSieci() +
                ", \nmaxLiczbaWszystkichKontenerow: " + getMaxWszystkich() + ", \nmaxLadownoscStatku: " + getMaxLadownosc();
    }
}
