package org.zk.domain;

public class Order {

	public Order() {
		System.out.println("create order");
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
