package com.company;

//https://www.containerhandbuch.de/chb_e/stra/index.html

public enum Zabiezpeczenia {
    SlidingLoading("SlidingLoading",
            "The sliding loading method allows cargo to move in the direction " +
            "of impact as a result of the jolting forces that occur during rail transportation. With this method, " +
            "jolting energy is absorbed by friction work."),
    RigidLoading("RigidLoading",
            "The term rigid loading comes from the loading guidelines published by " +
            "the UIC (International Rail Union) and is used as a blanket term to cover both compact loading and " +
            "individual securing.");


     final String [] zabiezpieczenie = new String [2];

    Zabiezpeczenia(String Nazwa, String Opis){
        this.zabiezpieczenie[0]=Nazwa;
        this.zabiezpieczenie[1]=Opis;
    }

    public String getNazwa() {
        return this.zabiezpieczenie[0];
    }
    public String getOpis() {
        return this.zabiezpieczenie[2];
    }


    @Override
    public String toString(){
        return "Zabiezpieczenie: "+ getNazwa() + ", opis: "+ getOpis();
    }

}
