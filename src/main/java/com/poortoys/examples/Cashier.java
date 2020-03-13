package com.poortoys.examples;

import java.util.concurrent.CountDownLatch;

public class Cashier {
	
	public int id;
	public Bank bank;
	public Client client;
	public StatusEnum status;
	public CountDownLatch workStatus;

	public Cashier(Bank bank, int id)
	{
		this.status=StatusEnum.FREE;
		this.bank=bank;
		this.id=id;
		workStatus=new CountDownLatch(1);
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
		this.client.setClientStatus(ClientStatus.INPROCESS);
		
		this.workStatus.countDown();
	}

	
	
	public void startWork() {
		Thread cashierThread=new Thread(new CashierThread(this));
		cashierThread.start();
		
	}
	
}
