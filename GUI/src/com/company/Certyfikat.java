package com.company;

//https://www.rina.org/en/intermodal

public enum Certyfikat {
    ADR("ADR","1.8","European Agreement Concerning the International Carriage of Dangerous Goods by Road"),
    CSC("CSC","4.8","International Convention for Safe Containers"),
    IMDG("IMDG","2.0","International Maritime Dangerous Goods Code"),
    ISO("ISO","2.4","International Maritime Dangerous Goods Code"),
    RID("RID","1.8","International Regulations Concerning the Carriage of Dangerous Goods by Rail");


    private final String [] certyfikat = new String [3];

    Certyfikat(String Nazwa, String standart, String Opis){
        this.certyfikat[0]=Nazwa;
        this.certyfikat[1]=standart;
        this.certyfikat[2]=Opis;
    }

    public String getNazwa() {
        return this.certyfikat[0];
    }
    public String getStandart() {
        return this.certyfikat[1];
    }
    public String getOpis() {
        return this.certyfikat[2];
    }


    @Override
    public String toString(){
        return "Certyfikat: "+ getNazwa() + ", standart: "+getStandart()+ ", opis: "+ getOpis();
    }
}
