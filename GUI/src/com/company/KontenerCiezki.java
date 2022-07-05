package com.company;

public class KontenerCiezki extends Kontener{
    private final int pojemnosc; //m3

    public KontenerCiezki(Nadawca nadawca, String tara,Zabiezpeczenia zabiezpieczenia, int wagaNetto, int wagaBrutto,
                          Certyfikat certyfikat,int iloscDniPrzechowywania, int Pojemnosc) {
        super(nadawca, tara, zabiezpieczenia, wagaNetto, wagaBrutto, certyfikat, iloscDniPrzechowywania);
        this.pojemnosc=Pojemnosc;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    @Override
    public String toString(){
        return "-------------------\n" + getNumer() + " Kontener Ciezki: \nNadawca: " + getNadawca() + ", \ntara: " + getTara() +
                ", \nzabiezpiecznie: "+ getZabiezpeczenia() + ", \nwaga Netto: "+ getWagaNetto() +
                ", \nwaga Brutto: "+ getWagaBrutto() + ", \ncertyfikat: "+ getCertyfikatName() +
                ", \ndni przechowywania: " + getIloscDniPrzechowywania()+
                ", \npojemnosc(m3): "+ getPojemnosc();
    }
}
