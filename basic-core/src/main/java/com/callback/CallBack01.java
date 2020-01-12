package com.callback;

public class CallBack01 {
    public static void main(String[] args) {
        IndoorsMan man = new IndoorsMan();
        String result = "";
        GasCompany gasCompany = new GasCompany();
        System.out.println(gasCompany.getResult());
        System.out.println("***********");
        gasCompany.advertiseTo(man);
        man.prepareCook();
        System.out.println("***********");
        System.out.println(gasCompany.getResult());
        System.out.println(result);
    }
}
