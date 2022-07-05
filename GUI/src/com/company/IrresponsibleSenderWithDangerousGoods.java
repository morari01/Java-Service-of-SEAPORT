package com.company;

public class IrresponsibleSenderWithDangerousGoods extends Exception {
    public IrresponsibleSenderWithDangerousGoods(){
        super("Kontener zostal zutylizowany");
    }
}
