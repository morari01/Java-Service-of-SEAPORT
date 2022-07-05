package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class UplywCzasu extends Thread{

    public boolean start = true;
    public boolean end = true;
    public LocalDate czas;
    ArrayList<Kontener> kontenerArrayList;
    Wagon wagon;
    Magazyn magazyn;

    public UplywCzasu(ArrayList<Kontener> kontener0ArrayList, Magazyn magazyn, Wagon wagon){
        this.czas=LocalDate.of(2022,4,1);
        this.kontenerArrayList=kontener0ArrayList;
        this.magazyn=magazyn;
        this.wagon=wagon;
    }

    public UplywCzasu(ArrayList<Kontener> kontener0ArrayList, Magazyn magazyn){
        this.czas=LocalDate.of(2022,4,1);
        this.kontenerArrayList=kontener0ArrayList;
        this.magazyn=magazyn;
    }

    public UplywCzasu(ArrayList<Kontener> kontener0ArrayList, Wagon wagon){
        this.czas=LocalDate.of(2022,4,1);
        this.kontenerArrayList=kontener0ArrayList;

        this.wagon=wagon;
    }




    public void run(){
        while(end){
            while (start){
                try{
                    sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                czas = czas.plusDays(1);
                try {
                    magazyn.sprawdzWaznoscKontenera();

                }catch (IrresponsibleSenderWithDangerousGoods irresponsibleSenderWithDangerousGoods) {
                    irresponsibleSenderWithDangerousGoods.printStackTrace();
                }
                try{
                    wagon.sprawdzIloscKontenerow();
                    sleep(30000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    synchronized public void end() {
        this.end=false;
    }

    synchronized public void pause(){
        this.start=false;
    }

    synchronized public void runAgain(){
        this.start=false;
    }

    synchronized public LocalDate getCzas(){
        return czas;
    }
}
