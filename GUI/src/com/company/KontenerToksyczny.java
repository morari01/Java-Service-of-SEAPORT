package com.company;

public class KontenerToksyczny extends KontenerCiezki {
    private String ChemicznyMaterialSypki;
    private int PojemnoscLitry;
    public String MaterialCiekly;

    public KontenerToksyczny(Nadawca nadawca, String tara,Zabiezpeczenia zabiezpieczenia, int wagaNetto, int wagaBrutto,
                             Certyfikat certyfikat,int iloscDniPrzechowywania, int Pojemnosc, String MaterialSypki) {
        super(nadawca, tara, zabiezpieczenia, wagaNetto, wagaBrutto, certyfikat, iloscDniPrzechowywania,Pojemnosc);
        this.ChemicznyMaterialSypki=MaterialSypki;

    }

    public KontenerToksyczny(Nadawca nadawca, String tara, Zabiezpeczenia zabiezpieczenia, int wagaNetto, int wagaBrutto,
                             Certyfikat certyfikat,int iloscDniPrzechowywania, int Pojemnosc, String MaterialCiekly, int pojemnoscLitry){
        super(nadawca, tara, zabiezpieczenia, wagaNetto, wagaBrutto, certyfikat, iloscDniPrzechowywania, Pojemnosc);
        this.MaterialCiekly=MaterialCiekly;
        this.PojemnoscLitry=pojemnoscLitry;

    }

    public String getChemicznyMaterialSypki() {
        return ChemicznyMaterialSypki;
    }

    public String getMaterialCiekly() {
        return MaterialCiekly;
    }

    public int getPojemnoscLitry() {
        return PojemnoscLitry;
    }

    @Override
    public String toString(){
        if(ChemicznyMaterialSypki!=null){
            return "-------------------\n" + getNumer() + " Kontener dla materialow toksycznych(sypkich): \nNadawca: " + getNadawca() + ", \ntara: " + getTara() +
                    ", \nzabiezpiecznie: "+ getZabiezpeczenia() + ", \nwaga Netto: "+ getWagaNetto() +
                    ", \nwaga Brutto: "+ getWagaBrutto() + ", \ncertyfikat: "+ getCertyfikatName() +
                    ", \ndni przechowywania: " + getIloscDniPrzechowywania() +
                    ", \npojemnosc(m3): "+ getPojemnosc() + ", \nmaterial sypki: "+ getChemicznyMaterialSypki();
        }
        else
            return "-------------------\n" + getNumer() + " Kontener dla materialow toksycznych(cieklych): \nNadawca: " + getNadawca() + ", \ntara: " + getTara() +
                    ", \nzabiezpiecznie: "+ getZabiezpeczenia() + ", \nwaga Netto: "+ getWagaNetto() +
                    ", \nwaga Brutto: "+ getWagaBrutto() + ", \ncertyfikat: "+ getCertyfikatName() +
                    ", \ndni przechowywania: " + getIloscDniPrzechowywania() +
                    ", \npojemnosc(m3): "+ getPojemnosc() + ", \nmaterial ciekly: "+ getMaterialCiekly()
                    + ", \npojemnosc(L): "+ getPojemnoscLitry();
    }
}
