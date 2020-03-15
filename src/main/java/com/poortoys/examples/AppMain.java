package com.poortoys.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.poortoys.examples.Classes.Bank;
import com.poortoys.examples.Threads.ClientGenerateThread;

public class AppMain {

    public static void main(String[] args) {
    	
    	Bank bank=new Bank();
        Thread thread=new Thread(new ClientGenerateThread(bank));
        thread.start();
    }

}
