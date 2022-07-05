package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {
    public static boolean exit = false;

    public static void main(String[] args) {
        ArrayList<Statek> statekList = new ArrayList<>();
        ArrayList<Kontener> kontenerArrayList = new ArrayList<>();
        ArrayList<Wagon> wagonArrayList = new ArrayList<>();
        ArrayList<Port> Port = new ArrayList<>();


//------NADAWCA
        Nadawca nadawca1 = new Nadawca("Jan", "Kowalski", "03022255554", "Marszalkowska 35");
        Nadawca nadawca2 = new Nadawca("Zhao", "Wen", "98102455554", "Hefang Street 505");
        Nadawca nadawca3 = new Nadawca("Dong", "Xingjuan", "86060955554", "Pingjuang Street 213");
        Nadawca nadawca4 = new Nadawca("Leo", "Johnson", "00121255554", "Evesham Rd 14");
        Nadawca nadawca5 = new Nadawca("Barlomej", "Kurowski", "90050355554", "Korotynskiego 191");


//------KONTENERY
        Kontener kontener1 = new Kontener(nadawca1, "40-DryVan", Zabiezpeczenia.RigidLoading, 3500, 4000, Certyfikat.ADR,10);
        Kontener kontener2 = new Kontener(nadawca4, "Cube400-500", Zabiezpeczenia.SlidingLoading, 4500,4501,Certyfikat.ISO, 60);
        Kontener kontener3 = new Kontener(nadawca2, "40-DryVan", Zabiezpeczenia.SlidingLoading, 100,120,Certyfikat.CSC, 20);
        Kontener kontener4 = new Kontener(nadawca4, "Cube400-500", Zabiezpeczenia.RigidLoading, 1200,1500,Certyfikat.RID, 11);
        Kontener kontener5 = new Kontener(nadawca5, "Cube-60", Zabiezpeczenia.SlidingLoading, 1340,1650,Certyfikat.IMDG, 14);

        KontenerMaterialyCiekle kontener6 = new KontenerMaterialyCiekle(nadawca1, "40-High Cube", Zabiezpeczenia.RigidLoading, 580, 700, Certyfikat.ADR, 2,60);
        KontenerMaterialyCiekle kontener7 = new KontenerMaterialyCiekle(nadawca3, "WideVan-100", Zabiezpeczenia.SlidingLoading, 180, 199, Certyfikat.IMDG, 72,70);
        KontenerMaterialyCiekle kontener8 = new KontenerMaterialyCiekle(nadawca1, "WideVan-100", Zabiezpeczenia.RigidLoading, 980, 1000, Certyfikat.ISO, 13,50);
        KontenerMaterialyCiekle kontener9 = new KontenerMaterialyCiekle(nadawca3, "Cube80", Zabiezpeczenia.RigidLoading, 600, 605, Certyfikat.ADR, 10,55);
        KontenerMaterialyCiekle kontener10 = new KontenerMaterialyCiekle(nadawca2, "470-High Cube", Zabiezpeczenia.SlidingLoading, 982, 989, Certyfikat.IMDG, 40,63);

        KontenerChlodniczy kontener11 = new KontenerChlodniczy(nadawca4, "WideVan-100", Zabiezpeczenia.RigidLoading, 3200, 3200, Certyfikat.ISO, 10, 20,9);
        KontenerChlodniczy kontener12 = new KontenerChlodniczy(nadawca3, "40-High Cube",Zabiezpeczenia.SlidingLoading, 200, 230, Certyfikat.IMDG, 2, 20,9);
        KontenerChlodniczy kontener13 = new KontenerChlodniczy(nadawca5, "Cube400-500", Zabiezpeczenia.RigidLoading, 400, 456, Certyfikat.ISO, 13, 20,9);
        KontenerChlodniczy kontener14 = new KontenerChlodniczy(nadawca5, "470-High Cube", Zabiezpeczenia.SlidingLoading, 1230, 1250, Certyfikat.CSC, 45, 20,9);
        KontenerChlodniczy kontener15 = new KontenerChlodniczy(nadawca5, "40-High Cube", Zabiezpeczenia.SlidingLoading, 5200, 5200, Certyfikat.ADR, 6, 20,9);

        KontenerCiezki kontener16 = new KontenerCiezki(nadawca4, "Cube400-500", Zabiezpeczenia.RigidLoading, 4000, 4100, Certyfikat.IMDG, 6,863);
        KontenerCiezki kontener17 = new KontenerCiezki(nadawca3, "Cube80", Zabiezpeczenia.SlidingLoading, 4100, 4400, Certyfikat.RID, 8,1772);
        KontenerCiezki kontener18 = new KontenerCiezki(nadawca2, "470-High Cube", Zabiezpeczenia.RigidLoading, 230, 265, Certyfikat.IMDG, 10,450);
        KontenerCiezki kontener19 = new KontenerCiezki(nadawca5, "40-High Cube", Zabiezpeczenia.RigidLoading, 1200,1500, Certyfikat.ISO, 4,5600);
        KontenerCiezki kontener20 = new KontenerCiezki(nadawca1, "40-High Cube", Zabiezpeczenia.RigidLoading, 4000, 4100, Certyfikat.CSC, 50,400);

        KontenerWybuchowy kontener21 = new KontenerWybuchowy(nadawca5, "40-DryVan", Zabiezpeczenia.RigidLoading, 5000, 5500, Certyfikat.RID, 60,66, "Kwas azotowy");
        KontenerWybuchowy kontener22 = new KontenerWybuchowy(nadawca3, "Cube-60", Zabiezpeczenia.RigidLoading, 5000, 6300, Certyfikat.ISO, 10,87, "trotyl");
        KontenerWybuchowy kontener23 = new KontenerWybuchowy(nadawca5, "470-High Cube", Zabiezpeczenia.SlidingLoading, 5000, 5900, Certyfikat.ADR, 5,40, "heksogen");
        KontenerWybuchowy kontener24 = new KontenerWybuchowy(nadawca4, "40-DryVan", Zabiezpeczenia.SlidingLoading, 230, 265, Certyfikat.IMDG, 3,500, "rtec");
        KontenerWybuchowy kontener25 = new KontenerWybuchowy(nadawca3, "470-High Cube", Zabiezpeczenia.SlidingLoading, 2300, 2600, Certyfikat.ISO, 4,30, "Pentryt");

        KontenerToksyczny kontener26 = new KontenerToksyczny(nadawca2, "Cube-60", Zabiezpeczenia.RigidLoading, 4321, 4561, Certyfikat.ADR,20, 150, "Nitrate");
        KontenerToksyczny kontener27 = new KontenerToksyczny(nadawca3, "470-High Cube", Zabiezpeczenia.RigidLoading, 230, 265, Certyfikat.ISO,15, 250, "Cadmium");
        KontenerToksyczny kontener28 = new KontenerToksyczny(nadawca3, "Cube-60", Zabiezpeczenia.SlidingLoading, 423, 490, Certyfikat.ISO,3, 350, "Asbestos");
        KontenerToksyczny kontener29 = new KontenerToksyczny(nadawca5, "40-DryVan", Zabiezpeczenia.SlidingLoading, 1200,1500, Certyfikat.IMDG,6, 900, "Glue", 30);
        KontenerToksyczny kontener30 = new KontenerToksyczny(nadawca1, "Cube400-500", Zabiezpeczenia.RigidLoading, 100, 120, Certyfikat.RID,8, 120, "Formaldehyde", 56);

        kontenerArrayList.add(kontener1);
        kontenerArrayList.add(kontener2);
        kontenerArrayList.add(kontener3);
        kontenerArrayList.add(kontener4);
        kontenerArrayList.add(kontener5);
        kontenerArrayList.add(kontener6);
        kontenerArrayList.add(kontener7);
        kontenerArrayList.add(kontener8);
        kontenerArrayList.add(kontener9);
        kontenerArrayList.add(kontener10);
        kontenerArrayList.add(kontener11);
        kontenerArrayList.add(kontener12);
        kontenerArrayList.add(kontener13);
        kontenerArrayList.add(kontener14);
        kontenerArrayList.add(kontener15);
        kontenerArrayList.add(kontener16);
        kontenerArrayList.add(kontener17);
        kontenerArrayList.add(kontener18);
        kontenerArrayList.add(kontener19);
        kontenerArrayList.add(kontener20);
        kontenerArrayList.add(kontener21);
        kontenerArrayList.add(kontener22);
        kontenerArrayList.add(kontener23);
        kontenerArrayList.add(kontener24);
        kontenerArrayList.add(kontener25);
        kontenerArrayList.add(kontener26);
        kontenerArrayList.add(kontener27);
        kontenerArrayList.add(kontener28);
        kontenerArrayList.add(kontener29);
        kontenerArrayList.add(kontener30);



//------STATKI
        Statek statek1 = new Statek("Marina", "Poland", "Gdansk", "Latvia",
                3, 3, 2, 9, 75000);
        Statek statek2 = new Statek("EvergreenLine", "SantaMonica-AS23", "Jebel ALi", "Port Klang",
                10, 2, 3, 15, 100000);
        Statek statek3 = new Statek("Titanic-2", "NY566", "New-York", "Southampton",
                4, 4, 1, 80, 70000);
        Statek statek4 = new Statek("USS Missouri", "USA", "Los Angeles","Shanghai",
                16,50,13,90,9600);
        Statek statek5 = new Statek("Aurora", "South Korea", "Busan", "Rotterdam",
                6, 41, 1, 56,46000);

        statek1.zaladujKontener(kontener1);
        statek1.zaladujKontener(kontener6);
        statek1.zaladujKontener(kontener11);
        statek1.zaladujKontener(kontener16);
        statek1.zaladujKontener(kontener21);
        statek1.zaladujKontener(kontener26);

        statek2.zaladujKontener(kontener2);
        statek2.zaladujKontener(kontener7);
        statek2.zaladujKontener(kontener12);
        statek2.zaladujKontener(kontener17);
        statek2.zaladujKontener(kontener22);
        statek2.zaladujKontener(kontener27);

        statek3.zaladujKontener(kontener3);
        statek3.zaladujKontener(kontener8);
        statek3.zaladujKontener(kontener13);
        statek3.zaladujKontener(kontener18);
        statek3.zaladujKontener(kontener23);
        statek3.zaladujKontener(kontener28);

        statek4.zaladujKontener(kontener4);
        statek4.zaladujKontener(kontener9);
        statek4.zaladujKontener(kontener14);
        statek4.zaladujKontener(kontener19);
        statek4.zaladujKontener(kontener24);
        statek4.zaladujKontener(kontener29);

        statek5.zaladujKontener(kontener5);
        statek5.zaladujKontener(kontener10);
        statek5.zaladujKontener(kontener15);
        statek5.zaladujKontener(kontener20);
        statek5.zaladujKontener(kontener25);
        statek5.zaladujKontener(kontener30);

        statekList.add(statek1);
        statekList.add(statek2);
        statekList.add(statek3);
        statekList.add(statek4);
        statekList.add(statek5);


//------WAGON
        Wagon wagon = new Wagon();

        statek1.rozladujKontenerDoWagonu(kontener1,wagon);
        statek2.rozladujKontenerDoWagonu(kontener17,wagon);
        statek5.rozladujKontenerDoWagonu(kontener30, wagon);
        wagon.magazunyjKontener(kontener6);
        wagon.magazunyjKontener(kontener15);
        wagon.magazunyjKontener(kontener13);
        wagon.magazunyjKontener(kontener24);
        wagonArrayList.add(wagon);


//------MAGAZYN
        Magazyn magazyn = new Magazyn(10);
        magazyn.magazunyjKontener(kontener6);
        magazyn.magazunyjKontener(kontener21);
        magazyn.magazunyjKontener(kontener11);
        magazyn.magazunyjKontener(kontener1);

        statek1.rozladujKontenerDoMagazynu(kontener16, magazyn);
        statek2.rozladujKontenerDoMagazynu(kontener22, magazyn);
        statek3.rozladujKontenerDoMagazynu(kontener8, magazyn);
        statek4.rozladujKontenerDoMagazynu(kontener14, magazyn);
        statek5.rozladujKontenerDoMagazynu(kontener5, magazyn);

        magazyn.zMagazynuDoStatku(statek2,kontener11);



//------PORT
        Port port = new Port("Port morski Gdańsk");
        port.addStatek(statek1);
        port.addStatek(statek2);
        port.addStatek(statek3);
        port.addStatek(statek4);
        port.addStatek(statek5);
        Port.add(port);

//------CZAS
        UplywCzasu uplywCzasu = new UplywCzasu(magazyn.listaPrzechowywanychKontenerow, magazyn, wagon);
        uplywCzasu.start();


//dzialanie programu z poziomu menu:
        Scanner scanner = new Scanner(System.in);
        int menu;
        int menu1;
        int menu7;
        while (!exit) {
            System.out.println("\nMENU GLOWNE:");
            System.out.println("WYBIERZ [0], aby zakończyć program");
            System.out.println("WYBIERZ [1], aby zładowania wskazanego kontenera ze statku na wagon kolejowy/do magazynu");
            System.out.println("WYBIERZ [2], aby załadowania na wskazany statek wskazanego kontenera");
            System.out.println("WYBIERZ [3], aby wyswietlic informacje o statku i znajdujących się na nim kontenerach");
            System.out.println("WYBIERZ [4], aby wyswietlic stan magazynu wraz z czasem pozostałym do utylizacji " +
                    "kontenerów przechowujących materiały wybuchowe lub materiały toksyczne");
            System.out.println("WYBIERZ [5], aby usunac kontener z magazynu");
            System.out.println("WYBIERZ [6], aby stworzyc nowy statek");
            System.out.println("WYBIERZ [7], aby stworzyc nowy kontener");
            System.out.println("WYBIERZ [8], aby usunac statek");
            System.out.println("WYBIERZ [9], aby usunac kontener");
            System.out.println("WYBIERZ [10], aby wysweltic liste statkow w portach");
            System.out.println("WYBIERZ [11], aby wysweltic liste wszystkich kontenerow");
            System.out.println("WYBIERZ [12], aby wyswetlic liste kontenerow w magazynie");
            System.out.println("WYBIERZ [13], aby wyswetlic liste kontenerow w wagonie");
            System.out.println("WYBIERZ [14], aby wstrzymac uplyw czasu");
            System.out.println("WYBIERZ [15], aby wyswietlic aktualny stan portu"); //zapisywanie do pliku

            menu = scanner.nextInt();

            switch (menu) {
                case 0: { // WYJSCIE
                    exit = true;
                }break;

                case 1: { //zładowania wskazanego kontenera ze statku na wagon kolejowy/do magazynu
                    System.out.println("[1] - zladuj na wagon kolejowy");
                    System.out.println("[2] - zladuj do magazynu");
                    menu1 = scanner.nextInt();

                    switch (menu1){
                        case 1:{
                            int numerKontenera;
                            int numerStatku;
                            System.out.println("Podaj numer Statku: ");
                            for(Statek s : statekList) System.out.println(s.getNumer()+ ", "+ s.getName());
                            numerStatku=scanner.nextInt();
                            boolean znajdzStatek= false;
                            boolean znalezionoKontener = false;
                            Statek tmp = null;
                            Kontener ktmp = null;
                            for(Statek s : statekList){
                                if(s.getNumer()==numerStatku){
                                    znajdzStatek = true;
                                    tmp=s;
                                }
                            }
                            if(znajdzStatek) {
                                System.out.println("Podaj numer kontenera: ");
                                for(Kontener kn : tmp.kontenerList)
                                    System.out.println(kn.getNumer()+ ", "+ kn.getWagaBrutto());
                                numerKontenera = scanner.nextInt();
                                for (Kontener kontener : kontenerArrayList) {
                                    if (kontener.getNumer() == numerKontenera) {
                                        znalezionoKontener = true;
                                        ktmp = kontener;
                                    }
                                }
                                if (znalezionoKontener) {
                                    for(Statek st : statekList){
                                        if(st.getNumer()==numerStatku)
                                            tmp=st;
                                    }
                                    tmp.rozladujKontenerDoWagonu(ktmp,wagon);
                                    System.out.println("Kontener: " + ktmp.getNumer() + " zladowano na wagon");
                                }
                                else System.out.println("Nie znaleziono konteneru");
                            }
                            else System.out.println("Nie ma statku");
                        }break;

                        case 2:{
                            int numerKontenera;
                            int numerStatku;
                            System.out.println("Podaj numer Statku: ");
                            for(Statek s : statekList) System.out.println(s.getNumer()+ ", "+ s.getName());
                            numerStatku=scanner.nextInt();
                            boolean znajdzStatek= false;
                            boolean znalezionoKontener = false;
                            Statek tmp = null;
                            Kontener ktmp = null;
                            for(Statek s : statekList){
                                if(s.getNumer()==numerStatku){
                                    znajdzStatek = true;
                                    tmp=s;
                                }
                            }
                            if(znajdzStatek) {
                                System.out.println("Podaj numer kontenera: ");
                                for(Kontener kn : tmp.kontenerList)
                                    System.out.println(kn.getNumer()+ ", "+ kn.getWagaBrutto());
                                numerKontenera = scanner.nextInt();
                                for (Kontener kontener : kontenerArrayList) {
                                    if (kontener.getNumer() == numerKontenera) {
                                        znalezionoKontener = true;
                                        ktmp = kontener;
                                    }
                                }
                                if (znalezionoKontener) {
                                    for(Statek st : statekList){
                                        if(st.getNumer()==numerStatku)
                                        tmp=st;
                                    }
                                    tmp.rozladujKontenerDoMagazynu(ktmp,magazyn);
                                        System.out.println("Kontener: " + ktmp.getNumer() + " zladowano do magazynu");
                                }
                                else System.out.println("Nie znaleziono konteneru");
                            }
                            else System.out.println("Nie ma statku");
                        }break;
                    }
                }break;

                case 2: {//załadowania na wskazany statek wskazanego kontenera
                    int numerStatku;
                    int numerKontenera;
                    System.out.println("Podaj numer Statku: ");
                    for(Statek s : statekList) System.out.println(s.getNumer()+ ", "+ s.getName());
                    numerStatku=scanner.nextInt();
                    boolean znajdzStatek= false;
                    boolean znalezionoKontener = false;
                    Statek tmp = null;
                    Kontener ktmp = null;
                    for(Statek s : statekList){
                        if(s.getNumer()==numerStatku){
                            znajdzStatek = true;
                            tmp=s;
                        }
                    }
                    if(znajdzStatek) {
                        System.out.println("Podaj numer kontenera: ");
                        numerKontenera = scanner.nextInt();
                        for (Kontener kontener : kontenerArrayList) {
                            if (kontener.getNumer() == numerKontenera) {
                                znalezionoKontener = true;
                                ktmp = kontener;
                            }
                        }
                        if (znalezionoKontener) {
                            for(Statek st : statekList){
                                if (st.getNumer() == numerStatku) {
                                    tmp=st;
                                }
                            }
                            tmp.zaladujKontener(ktmp);
                            System.out.println("Kontener: " + ktmp.getNumer() + " zladowano na statek: "+ tmp.getNumer());
                        }
                        else System.out.println("Nie znaleziono konteneru");
                    }
                    else System.out.println("Nie ma statku");
                }break;

                case 3: { //wyswietlic informacje o statku i znajdujących się na nim kontenerach
                    System.out.println("Podaj numer statku:");
                    for(Statek s : statekList){
                        System.out.println(s.getNumer() + ", " + s.getName());
                    }
                    int nr;
                    nr = scanner.nextInt();
                    boolean znalezionoStatek = false;
                    System.out.println("*Statek: " + nr);
                    for (Statek s : statekList) {
                        if (s.getNumer() == nr) {
                            znalezionoStatek = true;
                            break;
                        }
                    }
                    if(znalezionoStatek){
                        for(Statek tmp : statekList) {
                            if(tmp.getNumer()==nr && (!statekList.isEmpty()))
                                tmp.kontenerList.forEach(System.out::println);
                        }
                    }
                    if(!znalezionoStatek) System.out.println("*Nie ma takiego statku!*");
                }break;

                case 4: { //wyswietlic stan magazynu wraz z czasem pozostałym do utylizacji " +
                        // "kontenerów przechowujących materiały wybuchowe lub materiały toksyczne
                    magazyn.aktualnyStanMagazynu();
                    System.out.println("Aktualny czas: "+ uplywCzasu.getCzas());
                }break;

                case 5: {//usunac kontener z magazynu
                    int numerKonteneru;
                    boolean findKontener=false;
                    Kontener ktmp = null;
                    System.out.println("Podaj numer konteneru:");
                    magazyn.listaPrzechowywanychKontenerow.forEach(lk -> System.out.println(lk.getNumer() + ", waga: "+lk.getWagaBrutto()));


                    numerKonteneru=scanner.nextInt();
                    for(Kontener kontener : magazyn.listaPrzechowywanychKontenerow)
                        if (kontener.getNumer() == numerKonteneru) {
                            findKontener = true;
                            break;
                        }
                    for(Kontener kontener : kontenerArrayList){
                        if(kontener.getNumer()==numerKonteneru)
                            ktmp=kontener;
                    }
                    if(findKontener) {
                       magazyn.utylizujKontener(ktmp);
                       assert ktmp != null;
                       System.out.println("Kontener " + ktmp.getNumer() + " zostal usuniety z magazynu.");
                    }
                    else System.out.println("*Nie ma takiego konteneru!*");
                }break;

                case 6: { // tworzenie statku
                        System.out.println("****DODAJ NOWY STATEK****\n");
                        String nazwa;
                        String portMac;
                        String startLoc;
                        String EndLoc;
                        int maksToks;
                        int maksCiezkichKont;
                        int maxPodlaczeniaSieci;
                        int maxWszystkich;
                        int maxLadownosc;

                        System.out.println("Podaj nazwe statku:");
                        nazwa = scanner.next();
                        System.out.println("Podaj port macierzysty statku:");
                        portMac = scanner.next();
                        System.out.println("Podaj lokalizacje poczatkowa:");
                        startLoc = scanner.next();
                        System.out.println("Podaj lokalizacje koncowa:");
                        EndLoc = scanner.next();
                        System.out.println("Podaj liczbe toksycznych kontenerow:");
                        maksToks = scanner.nextInt();
                        System.out.println("Podaj liczbe ciezkich kontenerow:");
                        maksCiezkichKont = scanner.nextInt();
                        System.out.println("Podaj liczbe podlaczen kontenerow:");
                        maxPodlaczeniaSieci = scanner.nextInt();
                        System.out.println("Podaj liczbe wszystkich kontenerow:");
                        maxWszystkich = scanner.nextInt();
                        System.out.println("Podaj max ladownosc statku:");
                        maxLadownosc = scanner.nextInt();

                        Statek newStatek = new Statek(nazwa, portMac, startLoc, EndLoc, maksToks,
                                maksCiezkichKont, maxPodlaczeniaSieci, maxWszystkich, maxLadownosc);

                        statekList.add(newStatek);
                        port.statekList.add(newStatek);
                        System.out.println("***Dodano nowy statek, numer :" + newStatek.getNumer()+" ***\n");
                    }break;

                case 7: { // stworzyc nowy kontener
                        System.out.println("Wybierz [1], aby utworzyc Kontener zwykly");
                        System.out.println("Wybierz [2], aby utworzyc Kontener z materialem cieklym");
                        System.out.println("Wybierz [3], aby utworzyc Kontener Ciezki");
                        System.out.println("Wybierz [4], aby utworzyc Kontener Chlodniczy");
                        System.out.println("Wybierz [5], aby utworzyc Kontener Wybuchowy");
                        System.out.println("Wybierz [6], aby utworzyc Kontener Toksyczny");

                        menu7 = scanner.nextInt();
                        switch (menu7) {
                            case 1: {
                                System.out.println("****KONTENER ZWYKLY****");
                                String Nadawca;
                                String Nazwisko;
                                String pesel;
                                String adres;
                                String tara;
                                String zabiezpeczenia;
                                int wagaNetto;
                                int wagaBrutto;
                                int dni;

                                System.out.println("Podaj nadawce: ");
                                Nadawca = scanner.next();
                                System.out.println("Podaj nazwisko: ");
                                Nazwisko = scanner.next();
                                System.out.println("Podaj PESEL: ");
                                pesel = scanner.next();
                                System.out.println("Podaj adres nadawcy: ");
                                adres = scanner.next();
                                System.out.println("Podaj tare kontenera: ");
                                tara = scanner.next();
                                System.out.println("Podaj zabiezpeczenia RigidLoading/SlidingLoading: ");
                                zabiezpeczenia = scanner.next();
                                System.out.println("Podaj waga Netto: ");
                                wagaNetto = scanner.nextInt();
                                System.out.println("Podaj waga Brutto: ");
                                wagaBrutto = scanner.nextInt();
                                System.out.println("Podaj ilosc dni przechowywania: ");
                                dni = scanner.nextInt();


                                Nadawca nadawca = new Nadawca(Nadawca, Nazwisko, pesel, adres);

                                if (zabiezpeczenia.equals("SlidingLoading")) {
                                    Kontener kontenernew = new Kontener(nadawca, tara, Zabiezpeczenia.SlidingLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.IMDG,dni);
                                    //magazyn.magazunyjKontener(kontenernew);
                                    kontenerArrayList.add(kontenernew);
                                    System.out.println("Dodano nowy kontener, jego numer :" + kontenernew.getNumer());
                                }
                                if (zabiezpeczenia.equals("RigidLoading")) {
                                    Kontener kontenernew1 = new Kontener(nadawca, tara, Zabiezpeczenia.RigidLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.IMDG,dni);
                                    kontenerArrayList.add(kontenernew1);
                                    System.out.println("Dodano nowy kontener, jego numer :" + kontenernew1.getNumer());
                                }

                            }
                            break;
                            case 2: {
                                System.out.println("****KONTENER z MATERIALEM CIEKLYM****");
                                String Nadawca;
                                String Nazwisko;
                                String pesel;
                                String adres;
                                String tara;
                                String zabiezpeczenia;
                                int wagaNetto;
                                int wagaBrutto;
                                int pojemnoscL;

                                System.out.println("Podaj nadawce: ");
                                Nadawca = scanner.next();
                                System.out.println("Podaj nazwisko: ");
                                Nazwisko = scanner.next();
                                System.out.println("Podaj PESEL: ");
                                pesel = scanner.next();
                                System.out.println("Podaj adres nadawcy: ");
                                adres = scanner.next();
                                System.out.println("Podaj tare kontenera: ");
                                tara = scanner.next();
                                System.out.println("Podaj zabiezpeczenia RigidLoading/SlidingLoading: ");
                                zabiezpeczenia = scanner.next();
                                System.out.println("Podaj waga Netto: ");
                                wagaNetto = scanner.nextInt();
                                System.out.println("Podaj waga Brutto: ");
                                wagaBrutto = scanner.nextInt();
                                System.out.println("Podaj pojemnosc: ");
                                pojemnoscL = scanner.nextInt();
                                int dni;
                                System.out.println("Podaj ilosc dni przechowywania: ");
                                dni = scanner.nextInt();

                                Nadawca nadawca = new Nadawca(Nadawca, Nazwisko, pesel, adres);

                                if (zabiezpeczenia.equals("SlidingLoading")) {
                                    KontenerMaterialyCiekle kc = new KontenerMaterialyCiekle(nadawca, tara, Zabiezpeczenia.SlidingLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.IMDG,dni, pojemnoscL);
                                    kontenerArrayList.add(kc);
                                    System.out.println("Dodano nowy kontener, jego numer :" + kc.getNumer());
                                }
                                if (zabiezpeczenia.equals("RigidLoading")) {
                                    KontenerMaterialyCiekle kc1 = new KontenerMaterialyCiekle(nadawca, tara, Zabiezpeczenia.RigidLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.IMDG,dni, pojemnoscL);
                                    kontenerArrayList.add(kc1);
                                    System.out.println("Dodano nowy kontener, jego numer :" + kc1.getNumer());
                                }
                            }
                            break;
                            case 3: {
                                System.out.println("****KONTENER CIEZKI****");
                                String Nadawca;
                                String Nazwisko;
                                String pesel;
                                String adres;
                                String tara;
                                String zabiezpeczenia;
                                int wagaNetto;
                                int wagaBrutto;
                                int pojemnosc;

                                System.out.println("Podaj nadawce: ");
                                Nadawca = scanner.next();
                                System.out.println("Podaj nazwisko: ");
                                Nazwisko = scanner.next();
                                System.out.println("Podaj PESEL: ");
                                pesel = scanner.next();
                                System.out.println("Podaj adres nadawcy: ");
                                adres = scanner.next();
                                System.out.println("Podaj tare kontenera: ");
                                tara = scanner.next();
                                System.out.println("Podaj zabiezpeczenia RigidLoading/SlidingLoading: ");
                                zabiezpeczenia = scanner.next();
                                System.out.println("Podaj waga Netto: ");
                                wagaNetto = scanner.nextInt();
                                System.out.println("Podaj waga Brutto: ");
                                wagaBrutto = scanner.nextInt();
                                System.out.println("Podaj pojemnosc: ");
                                pojemnosc = scanner.nextInt();
                                int dni;
                                System.out.println("Podaj ilosc dni przechowywania: ");
                                dni = scanner.nextInt();

                                Nadawca nadawca = new Nadawca(Nadawca, Nazwisko, pesel, adres);

                                if (zabiezpeczenia.equals("SlidingLoading")) {
                                    KontenerCiezki kc = new KontenerCiezki(nadawca, tara, Zabiezpeczenia.SlidingLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.IMDG,dni, pojemnosc);
                                    kontenerArrayList.add(kc);
                                    System.out.println("Dodano nowy kontener, jego numer :" + kc.getNumer());
                                }
                                if (zabiezpeczenia.equals("RigidLoading")) {
                                    KontenerCiezki kc1 = new KontenerCiezki(nadawca, tara, Zabiezpeczenia.RigidLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.IMDG,dni, pojemnosc);
                                    kontenerArrayList.add(kc1);
                                    System.out.println("Dodano nowy kontener, jego numer :" + kc1.getNumer());
                                }
                            }
                            break;
                            case 4: {
                                System.out.println("****KONTENER CHLODNICZY****");
                                String Nadawca;
                                String Nazwisko;
                                String pesel;
                                String adres;
                                String tara;
                                String zabiezpeczenia;
                                int wagaNetto;
                                int wagaBrutto;
                                int temperatura;

                                System.out.println("Podaj nadawce: ");
                                Nadawca = scanner.next();
                                System.out.println("Podaj nazwisko: ");
                                Nazwisko = scanner.next();
                                System.out.println("Podaj PESEL: ");
                                pesel = scanner.next();
                                System.out.println("Podaj adres nadawcy: ");
                                adres = scanner.next();
                                System.out.println("Podaj tare kontenera: ");
                                tara = scanner.next();
                                System.out.println("Podaj zabiezpeczenia RigidLoading/SlidingLoading: ");
                                zabiezpeczenia = scanner.next();
                                System.out.println("Podaj waga Netto: ");
                                wagaNetto = scanner.nextInt();
                                System.out.println("Podaj waga Brutto: ");
                                wagaBrutto = scanner.nextInt();
                                System.out.println("Podaj temperature: ");
                                temperatura = scanner.nextInt();
                                int dni;
                                System.out.println("Podaj ilosc dni przechowywania: ");
                                dni = scanner.nextInt();

                                Nadawca nadawca_new = new Nadawca(Nadawca, Nazwisko, pesel, adres);

                                if (zabiezpeczenia.equals("SlidingLoading")) {
                                    KontenerChlodniczy chl = new KontenerChlodniczy(nadawca_new, tara, Zabiezpeczenia.SlidingLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.CSC,dni, 500, temperatura);
                                    kontenerArrayList.add(chl);
                                    System.out.println("Dodano nowy kontener, jego numer :" + chl.getNumer());
                                }
                                if (zabiezpeczenia.equals("RigidLoading")) {
                                    KontenerChlodniczy chl = new KontenerChlodniczy(nadawca_new, tara, Zabiezpeczenia.RigidLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.CSC,dni, 500, temperatura);
                                    kontenerArrayList.add(chl);
                                    System.out.println("Dodano nowy kontener, jego numer :" + chl.getNumer());
                                }
                            }
                            break;
                            case 5: {
                                System.out.println("****KONTENER WYBUCHOWY****");
                                String Nadawca;
                                String Nazwisko;
                                String pesel;
                                String adres;
                                String tara;
                                String zabiezpeczenia;
                                int wagaNetto;
                                int wagaBrutto;
                                int pojemnosc;
                                String nazwa_mater;

                                System.out.println("Podaj nadawce: ");
                                Nadawca = scanner.next();
                                System.out.println("Podaj nazwisko: ");
                                Nazwisko = scanner.next();
                                System.out.println("Podaj PESEL: ");
                                pesel = scanner.next();
                                System.out.println("Podaj adres nadawcy: ");
                                adres = scanner.next();
                                System.out.println("Podaj tare kontenera: ");
                                tara = scanner.next();
                                System.out.println("Podaj zabiezpeczenia RigidLoading/SlidingLoading: ");
                                zabiezpeczenia = scanner.next();
                                System.out.println("Podaj waga Netto: ");
                                wagaNetto = scanner.nextInt();
                                System.out.println("Podaj waga Brutto: ");
                                wagaBrutto = scanner.nextInt();
                                System.out.println("Podaj pojemnosc: ");
                                pojemnosc = scanner.nextInt();
                                System.out.println("Podaj nazwe materualu wybuchowego: ");
                                nazwa_mater = scanner.next();
                                int dni;
                                System.out.println("Podaj ilosc dni przechowywania: ");
                                dni = scanner.nextInt();

                                Nadawca nadawca = new Nadawca(Nadawca, Nazwisko, pesel, adres);

                                if (zabiezpeczenia.equals("SlidingLoading")) {
                                    KontenerWybuchowy wyb = new KontenerWybuchowy(nadawca, tara, Zabiezpeczenia.SlidingLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.IMDG,dni, pojemnosc, nazwa_mater);
                                    kontenerArrayList.add(wyb);
                                    System.out.println("Dodano nowy kontener, jego numer :" + wyb.getNumer());
                                }
                                if (zabiezpeczenia.equals("RigidLoading")) {
                                    KontenerWybuchowy wyb2 = new KontenerWybuchowy(nadawca, tara, Zabiezpeczenia.RigidLoading,
                                            wagaNetto, wagaBrutto, Certyfikat.IMDG,dni, pojemnosc, nazwa_mater);
                                    kontenerArrayList.add(wyb2);
                                    System.out.println("Dodano nowy kontener, jego numer :" + wyb2.getNumer());
                                }
                            }
                            break;
                            case 6: {
                                System.out.println("Pogaj [1] - jezeli kontener toksyczny z materialem Sypkim");
                                System.out.println("Pogaj [2] - jezeli kontener toksyczny z materialem cieklym");
                                int menuKontToks;
                                menuKontToks = scanner.nextInt();
                                switch (menuKontToks) {
                                    case 1: {
                                        System.out.println("****KONTENER TOKSYCZNY(SYPKI)****");
                                        String Nadawca;
                                        String Nazwisko;
                                        String pesel;
                                        String adres;
                                        String tara;
                                        String zabiezpeczenia;
                                        int wagaNetto;
                                        int wagaBrutto;
                                        int pojemnosc;
                                        String materialSypki;

                                        System.out.println("Podaj nadawce: ");
                                        Nadawca = scanner.next();
                                        System.out.println("Podaj nazwisko: ");
                                        Nazwisko = scanner.next();
                                        System.out.println("Podaj PESEL: ");
                                        pesel = scanner.next();
                                        System.out.println("Podaj adres nadawcy: ");
                                        adres = scanner.next();
                                        System.out.println("Podaj tare kontenera: ");
                                        tara = scanner.next();
                                        System.out.println("Podaj zabiezpeczenia RigidLoading/SlidingLoading: ");
                                        zabiezpeczenia = scanner.next();
                                        System.out.println("Podaj waga Netto: ");
                                        wagaNetto = scanner.nextInt();
                                        System.out.println("Podaj waga Brutto: ");
                                        wagaBrutto = scanner.nextInt();
                                        System.out.println("Podaj pojemnosc: ");
                                        pojemnosc = scanner.nextInt();
                                        System.out.println("Podaj nazwe materialu sypkiego: ");
                                        materialSypki = scanner.next();
                                        int dni;
                                        System.out.println("Podaj ilosc dni przechowywania: ");
                                        dni = scanner.nextInt();

                                        Nadawca nadawca = new Nadawca(Nadawca, Nazwisko, pesel, adres);

                                        if (zabiezpeczenia.equals("SlidingLoading")) {
                                            KontenerToksyczny t1 = new KontenerToksyczny(nadawca, tara, Zabiezpeczenia.SlidingLoading,
                                                    wagaNetto, wagaBrutto, Certyfikat.IMDG, dni,pojemnosc, materialSypki);
                                            kontenerArrayList.add(t1);
                                            System.out.println("Dodano nowy kontener, jego numer :" + t1.getNumer());
                                        }
                                        if (zabiezpeczenia.equals("RigidLoading")) {
                                            KontenerToksyczny t1 = new KontenerToksyczny(nadawca, tara, Zabiezpeczenia.RigidLoading,
                                                    wagaNetto, wagaBrutto, Certyfikat.IMDG,dni, pojemnosc, materialSypki);
                                            kontenerArrayList.add(t1);
                                            System.out.println("Dodano nowy kontener, jego numer :" + t1.getNumer());
                                        }
                                    }
                                    break;
                                    case 2: {
                                        System.out.println("****KONTENER TOKSYCZNY(CIEKLY)****");
                                        String Nadawca;
                                        String Nazwisko;
                                        String pesel;
                                        String adres;
                                        String tara;
                                        String zabiezpeczenia;
                                        int wagaNetto;
                                        int wagaBrutto;
                                        int pojemnosc;
                                        String materialciekly;
                                        int pojemnoscL;

                                        System.out.println("Podaj nadawce: ");
                                        Nadawca = scanner.next();
                                        System.out.println("Podaj nazwisko: ");
                                        Nazwisko = scanner.next();
                                        System.out.println("Podaj PESEL: ");
                                        pesel = scanner.next();
                                        System.out.println("Podaj adres nadawcy: ");
                                        adres = scanner.next();
                                        System.out.println("Podaj tare kontenera: ");
                                        tara = scanner.next();
                                        System.out.println("Podaj zabiezpeczenia RigidLoading/SlidingLoading: ");
                                        zabiezpeczenia = scanner.next();
                                        System.out.println("Podaj waga Netto: ");
                                        wagaNetto = scanner.nextInt();
                                        System.out.println("Podaj waga Brutto: ");
                                        wagaBrutto = scanner.nextInt();
                                        System.out.println("Podaj pojemnosc: ");
                                        pojemnosc = scanner.nextInt();
                                        System.out.println("Podaj nazwe materialu cieklego: ");
                                        materialciekly = scanner.next();
                                        System.out.println("Podaj pojemnosc materialu cieklego: ");
                                        pojemnoscL = scanner.nextInt();
                                        int dni;
                                        System.out.println("Podaj ilosc dni przechowywania: ");
                                        dni = scanner.nextInt();

                                        Nadawca nadawca = new Nadawca(Nadawca, Nazwisko, pesel, adres);

                                        if (zabiezpeczenia.equals("SlidingLoading")) {
                                            KontenerToksyczny t1 = new KontenerToksyczny(nadawca, tara, Zabiezpeczenia.SlidingLoading,
                                                    wagaNetto, wagaBrutto, Certyfikat.IMDG,dni, pojemnosc, materialciekly, pojemnoscL);
                                            kontenerArrayList.add(t1);
                                            System.out.println("Dodano nowy kontener, jego numer :" + t1.getNumer());
                                        }
                                        if (zabiezpeczenia.equals("RigidLoading")) {
                                            KontenerToksyczny t1 = new KontenerToksyczny(nadawca, tara, Zabiezpeczenia.RigidLoading,
                                                    wagaNetto, wagaBrutto, Certyfikat.IMDG,dni, pojemnosc, materialciekly, pojemnoscL);
                                            kontenerArrayList.add(t1);
                                            System.out.println("Dodano nowy kontener, jego numer :" + t1.getNumer());
                                        }
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                }break;

                case 8: { //usunac statek
                        System.out.println("Podaj numer Statku:");
                        int number;
                        boolean znalezionoStatek = false;
                        Statek tmp = null;
                        number = scanner.nextInt();
                        for (Statek s : port.statekList) {
                            if (s.getNumer() == number) {
                                znalezionoStatek = true;
                                tmp = s;
                            }
                        }
                        if (znalezionoStatek) {
                                port.statekList.remove(tmp);
                                System.out.println("Usunieto statek: " + tmp.getNumer());
                        }
                        else System.out.println("Nie znaleziono Statku!");

                }break;

                case 9: { //usun kontener
                        System.out.println("Podaj numer Konteneru:");
                        int number;
                        boolean znalezionoKontener = false;
                        Kontener tmp = null;
                        number = scanner.nextInt();
                        for (Kontener s : kontenerArrayList) {
                            if (s.getNumer() == number) {
                                znalezionoKontener = true;
                                tmp = s;
                            }
                        }
                        if (znalezionoKontener) {
                            kontenerArrayList.remove(tmp);
                            System.out.println("Usunieto kontener: " + tmp.getNumer());
                        }
                        else System.out.println("Nie znaleziono konteneru!");
                    }break;

                case 10:{
                    System.out.println("Lista statkow w portach:");
                    port.statekList.forEach(p -> System.out.println(p.getName()));
                  //  statekList.forEach(statek -> System.out.println(statek));
                }break;

                case 11:{
                    System.out.println("Lista kontenerow:");
                    kontenerArrayList.forEach(kontener -> System.out.println(kontener));
                }break;

                case 12:{
                    System.out.println("Lista kontenerow w magazynie:");
                    System.out.println(magazyn.listaPrzechowywanychKontenerow);
                }break;

                case 13: {
                    System.out.println("Lista kontenerow w wagonie:");
                    wagonArrayList.forEach(w -> System.out.println(w));
                }break;

                case 14:{
                    uplywCzasu.pause();
                    System.out.println("Zatrzymano uplyw czasu.");
                    System.out.println("Obecna data:"+ uplywCzasu.getCzas());
                }break;

                case 15: {
                    zapisStanuPortu(Port,statekList,kontenerArrayList,magazyn);
                }break;

                default:{
                    System.out.println("NIEPOPRAWNA KOMENDA!PROSZE WYBRAC MUNER Z MENU!");
                }
            }
        }

        System.out.println("****KONIEC**** :)");
        uplywCzasu.pause();
        uplywCzasu.end();
    }

    public static void zapisStanuPortu(ArrayList<Port> Port, ArrayList<Statek> statekList, ArrayList<Kontener> kontenerArrayList,
                                       Magazyn magazyn){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            FileWriter fileWriter = new FileWriter("Ogolna_Informacja.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //sortowanie statkow wedlug nazwy
            statekList.sort(Comparator.comparing(Statek::getName).reversed());
            //sortowanie kontenerow wedlug wagi
            kontenerArrayList.sort(Comparator.comparingInt(Kontener::getWagaBrutto));

            stringBuilder.append("---- s22931: Aktualny stan portu: ----\n");
            stringBuilder.append("\n___PORT___:\n");
            for (Port str : Port) {
                stringBuilder.append(str).append(System.lineSeparator());
            }

            stringBuilder.append("\n___STATKI___:\n");
            for (Statek str : statekList) {
                stringBuilder.append(str).append(System.lineSeparator());
            }

            stringBuilder.append("\n___KONTENERY___:\n");
            for (Kontener str : kontenerArrayList) {
                stringBuilder.append(str).append(System.lineSeparator());
            }

           // Kontenery magazynowane powinny być posortowane malejąco względem daty rozpoczęcia magazynowania
            // to kolejnym kryterium sortującym jest nazwa nadawcy.
            stringBuilder.append("\n___MAGAZYN___:\n");
            magazyn.listaPrzechowywanychKontenerow.sort(new ComparatorMagazynow());
            stringBuilder.append(magazyn.listaPrzechowywanychKontenerow.toString()).append(System.lineSeparator());

            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("Plik z danymi zapisano!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
