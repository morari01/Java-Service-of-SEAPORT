package com.company;
import java.util.Comparator;

public class ComparatorMagazynow implements Comparator<Kontener>{
    @Override
    public int compare(Kontener o1, Kontener o2) {
        int value1= String.valueOf(o1.iloscDniPrzechowywania).compareTo(String.valueOf(o2.iloscDniPrzechowywania));
        if (value1 == 0) {
            return o1.getNadawca().compareTo(o2.getNadawca());
        }
        return value1;
    }
}
