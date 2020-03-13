package com.poortoys.examples;

public class AppMain {

    public static void main(String[] args) {
    	Bank bank=new Bank();
        Thread thread=new Thread(new ClientGenerateThread(bank));
        thread.start();
    }

}
