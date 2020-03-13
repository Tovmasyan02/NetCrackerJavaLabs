package com.poortoys.examples;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class Bank {
	
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
		System.out.println("Консруктор банка");
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
		System.out.println("Банк работает");
	}
	
	public void addClient(Client client)
	{
		this.clients.add(client);
		boolean b=this.SearchCashierForClient(client);
		System.out.println("Новый клиент - "+client.toString());
		if(b)
			System.out.println("Нашли кассира для клиента -" + client.toString());
		else 
			System.out.println("Не Нашли кассира для клиента -" + client.toString());
		
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
		System.out.println("Обновление кассиров");
	}
	
	
	// Обновляет список ожидающих клиентов клиентов
	public synchronized  void RefreshWaitingClients()
	{
		this.setClients(this.clients.stream().filter(c->c.getClientStatus()==ClientStatus.Wait).collect(Collectors.toList()));
		System.out.println("обновление клиентов");
	}
	
	
	public boolean checkScore(Client client)
	{
		if(client.getAction()==ActionsEnum.WITHDRAW)
			if(this.getScore()<client.getPrice())
			{
				System.out.println("checkScore - Неуспешно");
				return false;
			}
		return true;
	}
	
	
	public synchronized  boolean SearchClientForCashier(Cashier cashier) {
		System.out.println("Нашли клиента для кассира  "+cashier.id);
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
		System.out.println("ищем кассира для клиента -" + client.toString());
		if(this.freeCashiers.size()!=0)
		{
			freeCashiers.get(0).setClient(client);
			System.out.println("Нашли кассира для клиента -" + client.toString()+"kassir - "+freeCashiers.get(0).id);
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
		System.out.println("Касса - "+this.score);
		System.out.println("Put Money - "+money);
		score+=money;
		System.out.println("Касса после PUT - "+this.score);
	}
	
	public synchronized void withdrawMoney(Long money)
	{
		System.out.println("Касса - "+this.score);
		System.out.println("withDraw Money - "+money);
		score-=money;
		System.out.println("Касса после Withdraw - "+this.score);
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
