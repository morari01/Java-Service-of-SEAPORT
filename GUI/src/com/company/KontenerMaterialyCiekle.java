package com.company;

public class KontenerMaterialyCiekle extends Kontener{
    private final int PojemnoscL;

    public KontenerMaterialyCiekle(Nadawca nadawca, String tara, Zabiezpeczenia zabiezpieczenia, int wagaNetto,
                                   int wagaBrutto, Certyfikat certyfikat,int iloscDniPrzechowywania, int pojemnoscLitry) {
        super(nadawca, tara, zabiezpieczenia, wagaNetto, wagaBrutto, certyfikat,iloscDniPrzechowywania);
        this.PojemnoscL=pojemnoscLitry;
    }

    public int getPojemnoscL() {
        return PojemnoscL;
    }

    @Override
    public String toString(){
        return "-------------------\n" + getNumer() + " Kontener dla materialow cieklych: \nNadawca: " + getNadawca() + ", \ntara: " + getTara() +
                ", \nzabiezpiecznie: "+ getZabiezpeczenia() + ", \nwaga Netto: "+ getWagaNetto() +
                ", \nwaga Brutto: "+ getWagaBrutto() + ", \ncertyfikat: "+ getCertyfikatName() +
                ", \ndni przechowywania: " + getIloscDniPrzechowywania() +
                ", \npojemnosc(L): "+ getPojemnoscL();


    }
}
