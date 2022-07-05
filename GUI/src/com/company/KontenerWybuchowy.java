package com.company;

public class KontenerWybuchowy extends KontenerCiezki{
    private final String NazwaMaterialuWyb;

    public KontenerWybuchowy(Nadawca nadawca, String tara, Zabiezpeczenia zabiezpieczenia, int wagaNetto, int wagaBrutto,
                             Certyfikat certyfikat, int iloscDniPrzechowywania,int Pojemnosc, String MaterialWybuchowy) {
        super(nadawca, tara, zabiezpieczenia, wagaNetto, wagaBrutto, certyfikat, iloscDniPrzechowywania, Pojemnosc);
        this.NazwaMaterialuWyb=MaterialWybuchowy;
    }

    public String getNazwaMaterialuWyb() {
        return NazwaMaterialuWyb;
    }

    @Override
    public String toString(){
        return "-------------------\n" + getNumer() + " Kontener dla materialow wybuchowych: \nNadawca: " + getNadawca() + ", \ntara: " + getTara() +
                ", \nzabiezpiecznie: "+ getZabiezpeczenia() + ", \nwaga Netto: "+ getWagaNetto() +
                ", \nwaga Brutto: "+ getWagaBrutto() + ", \ncertyfikat: "+ getCertyfikatName() +
                ", \ndni przechowywania: " + getIloscDniPrzechowywania() +
                ", \npojemnosc(m3): "+ getPojemnosc() + ", \nmaterial wybuchowy: " + getNazwaMaterialuWyb();
    }
}
