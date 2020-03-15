package com.poortoys.examples.Classes;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.poortoys.examples.Enums.ActionsEnum;
import com.poortoys.examples.Enums.ClientStatus;
import com.poortoys.examples.Enums.StatusEnum;

public class Bank {
	
	 
	Logger logger = LoggerFactory.getLogger("Bank");
	
	//счет банка
	private long score;
	
	// cписок всех кассиров
	private List<Cashier> cashiers=new ArrayList<Cashier>();
	
	// список свободных кассиров 
	private List<Cashier> freeCashiers=new ArrayList<Cashier>();
	
	// список ожидающих клиентов
	private List<Client> clients=new ArrayList<Client>();
	
	
	// конструктор класса 
	public Bank()
	{
		logger.info("Создается банк");
		this.score=1000;
		cashiers.add(new Cashier(this,1));
		cashiers.add(new Cashier(this,2));
		cashiers.add(new Cashier(this,3));
		this.RefreshfreeCashiers();
		this.BankStartWork();
		
	}
	
	public void BankStartWork()
	{
		this.cashiers.stream().forEach(c->c.startWork());
		logger.info("Банк начал работу");
	}
	
	public void addClient(Client client)
	{
		this.clients.add(client);
		boolean b=this.SearchCashierForClient(client);
		logger.info("Новый Клиент {}",client);
		if(b)
			logger.info("Нашли кассира для клиента - {}" + client);
		else 
			logger.info("Не Нашли кассира для клиента -" + client);
		
	}
	
	
	
	public void setScore(long score) {
		this.score = score;
	}

	// Обновляет список свободых кассиров
	// Если после обновления список свободных кассиров равен 0 то переключает CountDownLatch чтобы клиенты ждали
	// пока освобидится хотя бы один кассир
	public synchronized  void  RefreshfreeCashiers()
	{
		this.setFreeCashiers(cashiers.stream().filter(c->c.status==StatusEnum.FREE).collect(Collectors.toList()));
		logger.info("Обновление кассиров");
	}
	
	
	// Обновляет список ожидающих клиентов клиентов
	public synchronized  void RefreshWaitingClients()
	{
		this.setClients(this.clients.stream().filter(c->c.getClientStatus()==ClientStatus.Wait).collect(Collectors.toList()));
		logger.info("обновление клиентов");
	}
	
	
	public boolean checkScore(Client client)
	{
		if(client.getAction()==ActionsEnum.WITHDRAW)
			if(this.getScore()<client.getPrice())
			{
				logger.warn("checkScore - Неуспешно");
				return false;
			}
		return true;
	}
	
	
	public synchronized  boolean SearchClientForCashier(Cashier cashier) {
		logger.info("Нашли клиента для кассира -{} ",cashier.id);
		if(this.clients.size()==0)
			return false;
		for(Client c:this.clients)
		{
			if(this.checkScore(c))
			{
				cashier.setClient(c);
				cashier.client.setClientStatus(ClientStatus.INPROCESS);
				this.RefreshWaitingClients();
				return true;
			}
		}
		return false;
		
	}
	
	
	// свободному кассиру дает нового клиент, если нет мест возвращает false
	public synchronized  boolean SearchCashierForClient(Client client)
	{
		if(!this.checkScore(client))
			return false;
		logger.info("ищем кассира для клиента - {}",client);
		if(this.freeCashiers.size()!=0)
		{
			freeCashiers.get(0).setClient(client);
			logger.info("Нашли кассира для клиента -" + client.toString()+"kassir - "+freeCashiers.get(0).id);
			logger.info("Число свободных кассиров - {}",this.getFreeCashiers().size());
			this.RefreshfreeCashiers();
			return true;
		}
		return false;
		
	}
	
	
	// геттуры / сеттеры
	
	
	public int countOfFreeCashiers()
	{
		return this.getFreeCashiers().size();
	}
	
	public List<Cashier> getFreeCashiers() {
		return freeCashiers;
	}

	public void setFreeCashiers(List<Cashier> freeCashiers) {
		this.freeCashiers = freeCashiers;
	}
	
	public synchronized void putMoney(Long money) {
		logger.info("Касса - "+this.score);
		logger.info("Put Money - "+money);
		score+=money;
		logger.info("Касса после PUT - "+this.score);
	}
	
	public synchronized void withdrawMoney(Long money)
	{
		logger.info("Касса - "+this.score);
		logger.info("withDraw Money - "+money);
		score-=money;
		logger.info("Касса после Withdraw - "+this.score);
	}
	

	public void setCashiers(List<Cashier> cashiers)
	{
	
		this.cashiers=cashiers;
	}

	public synchronized Long getScore() {
		return score;
	}

	public synchronized void setScore(Long score) {
		this.score = score;
	}

	public List<Cashier> getCashiers() {
		return cashiers;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
		
}
