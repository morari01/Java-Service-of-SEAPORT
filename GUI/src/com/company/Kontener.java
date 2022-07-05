package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kontener {
    int iloscDniPrzechowywania;
    private final Nadawca Nadawca;
    private final String tara;
    private final Zabiezpeczenia zabiezpeczenia;
    private final int wagaNetto;
    private final int wagaBrutto;
    private final Certyfikat certyfikat;
    private final int numer;


    static int count;

    public Kontener(Nadawca nadawca, String tara, Zabiezpeczenia zabiezpieczenia, int wagaNetto, int wagaBrutto, Certyfikat certyfikat,
                    int dniPrzechowywania){
        this.Nadawca=nadawca;
        this.tara=tara;
        this.zabiezpeczenia =zabiezpieczenia;
        this.wagaNetto=wagaNetto; //kg
        this.wagaBrutto=wagaBrutto;
        this.certyfikat=certyfikat;
        this.iloscDniPrzechowywania=dniPrzechowywania;
        this.numer=++count;
    }

    public String getNadawca() {
        return Nadawca.getImie()+" "+Nadawca.getNazwisko();
    }

    public String getTara() {
        return tara;
    }

    public int getNumer() {
        return numer;
    }

    public int getWagaBrutto() {
        return wagaBrutto;
    }

    public int getWagaNetto() {
        return wagaNetto;
    }

    public int getIloscDniPrzechowywania() {
        return iloscDniPrzechowywania;
    }

    //gettery dla klasy Zabiezpeczenia
    public String getZabiezpeczenia() {
        return zabiezpeczenia.getNazwa();
    }
    public String getZabiezpeczeniaOpis() {
        return zabiezpeczenia.getOpis();
    }

    //gettery dla klasy Certyfikat
    public String getCertyfikatName() {
        return certyfikat.getNazwa();
    }
    public String getCertyfikatStandart() {
        return certyfikat.getStandart();
    }
    public String getCertyfikatOpis() {
        return certyfikat.getOpis();
    }


    public ArrayList<Kontener> ostrezenia;

    public void createListOstrezen(ArrayList<Kontener> k) throws IrresponsibleSenderWithDangerousGoods {
        this.ostrezenia = k;
        for(Kontener kontener : k){
            if(k.size()>=2)
            System.out.println(kontener.getNadawca() + " dostal ostrzezenie");
        }
        throw new IrresponsibleSenderWithDangerousGoods();
    }

    @Override
    public String toString(){
        return "-------------------\n" + getNumer() + " Kontener: \nNadawca: " + getNadawca() + ", \ntara: " + getTara() +
                ", \nzabiezpiecznie: "+ getZabiezpeczenia() + ", \nwaga Netto: "+ getWagaNetto() +
                ", \nwaga Brutto: "+ getWagaBrutto() + ", \ncertyfikat: "+ getCertyfikatName() +
                ", \ndni przechowywania: " + getIloscDniPrzechowywania();
    }

}
