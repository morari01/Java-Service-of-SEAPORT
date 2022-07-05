package com.company;

public class KontenerChlodniczy extends KontenerCiezki{
    private final int TemperaturaKontrolowana;
    int iloscDniPrzechowywania;


    public KontenerChlodniczy(Nadawca nadawca, String tara, Zabiezpeczenia zabiezpieczenia, int wagaNetto,
                              int wagaBrutto, Certyfikat certyfikat,int iloscDniPrzechowywania, int Pojemnosc, int temperaturaKontrolowana) {
        super(nadawca, tara, zabiezpieczenia, wagaNetto, wagaBrutto, certyfikat,iloscDniPrzechowywania, Pojemnosc);
        this.TemperaturaKontrolowana=temperaturaKontrolowana;
        this.iloscDniPrzechowywania=iloscDniPrzechowywania;
    }

    public int getTemperaturaKontrolowana() {
        return TemperaturaKontrolowana;
    }

    @Override
    public String toString(){
        return "-------------------\n" + getNumer() + " Kontener Chlodniczy: \nNadawca: " + getNadawca() + ", \ntara: " + getTara() +
                ", \nzabiezpiecznie: "+ getZabiezpeczenia() + ", \nwaga Netto: "+ getWagaNetto() +
                ", \nwaga Brutto: "+ getWagaBrutto() + ", \ncertyfikat: "+ getCertyfikatName() +
                ", \ndni przechowywania: " + getIloscDniPrzechowywania()+
                ", \npojemnosc(m3): "+ getPojemnosc() + ", \ntemperatura: " + getTemperaturaKontrolowana();
    }
}
