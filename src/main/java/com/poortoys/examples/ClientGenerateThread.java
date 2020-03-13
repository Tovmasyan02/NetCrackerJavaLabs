package com.poortoys.examples;

import java.util.*;

public class ClientGenerateThread implements Runnable {

	private Bank bank;
	private Random rnd=new Random();
	
	public ClientGenerateThread(Bank bank)
	{
		this.bank=bank;
	}
	
	@Override
	public void run() {
		try {
			while(true)
			{
				Thread.sleep(8000);
				Client client=this.generateClient();
				bank.addClient(client);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Client generateClient()
	{	
		Client client=new Client();
		client.setPrice((long)rnd.nextInt(1000));
		client.setTime((long)rnd.nextInt(15000));
		if(rnd.nextInt(2)==1)
			client.setAction(ActionsEnum.PUT);
		else
			client.setAction(ActionsEnum.WITHDRAW);
		return client;
	}
}
