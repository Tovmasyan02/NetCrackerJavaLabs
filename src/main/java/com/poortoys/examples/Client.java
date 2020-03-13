package com.poortoys.examples;

public class Client {
 
	private ActionsEnum action;
	private ClientStatus clientStatus;
	private Long price;
	private Long time;
	
	public Client()
	{
		this.clientStatus=ClientStatus.Wait;
	}
	
	public ClientStatus getClientStatus() {
		return clientStatus;
	}
	public void setClientStatus(ClientStatus clientStatus) {
		this.clientStatus = clientStatus;
	}
	public ActionsEnum getAction() {
		return action;
	}
	public void setAction(ActionsEnum action) {
		this.action = action;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Client [action=" + action + ", clientStatus=" + clientStatus + ", price=" + price + ", time=" + time
				+ "]";
	}
}
