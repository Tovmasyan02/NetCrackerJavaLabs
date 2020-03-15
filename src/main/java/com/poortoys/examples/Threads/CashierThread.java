package com.poortoys.examples.Threads;
import java.util.*;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.poortoys.examples.Classes.Cashier;
import com.poortoys.examples.Enums.ActionsEnum;
import com.poortoys.examples.Enums.StatusEnum;

public class CashierThread implements Runnable {
	
	Logger logger = LoggerFactory.getLogger("CashierThread");
	
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
				
				// обновляем список свободных кассиров
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
		logger.info("Действие");
		
		if(casheir.client.getAction()==ActionsEnum.PUT)
		{
			this.casheir.bank.putMoney(this.casheir.client.getPrice());
		}
		
		else
			this.casheir.bank.withdrawMoney(this.casheir.client.getPrice());
	}

}
