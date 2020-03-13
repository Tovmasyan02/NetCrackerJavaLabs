package com.poortoys.examples;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class CashierThread implements Runnable {
	
	private Cashier casheir;
	public CashierThread(Cashier c)
	{
		this.casheir=c;
	}
	
	@Override
	public void run() {
			
		while(true)
		{	
			try 
			{ 
				// ждем пока появится клиент 
				this.casheir.workStatus.await();
				
				// меняем status на Busy
				casheir.status=StatusEnum.BUSY;
				
				// работаем
			 	this.action();
			 	
				Thread.sleep(this.casheir.client.getTime());
				
				// меняем статус на FREE
				casheir.status=StatusEnum.FREE;
				
				// обновляем список свободных сотрудников
				this.casheir.bank.RefreshfreeCashiers();
				
				// чтобы ждать нового клиента
				this.casheir.workStatus=new CountDownLatch(1);
				
				// ищем для себя нового клиента 
				this.casheir.bank.SearchClientForCashier(this.casheir);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
			
	}
	
	private void action()
	{
		System.out.println("Действие");
		if(casheir.client.getAction()==ActionsEnum.PUT)
		{
			this.casheir.bank.putMoney(this.casheir.client.getPrice());
		}
		
		else
			this.casheir.bank.withdrawMoney(this.casheir.client.getPrice());
	}

}
