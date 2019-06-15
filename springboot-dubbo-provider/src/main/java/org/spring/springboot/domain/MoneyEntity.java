package org.spring.springboot.domain;

import java.io.Serializable;

public class MoneyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MoneyEntity(int id, int total) {
		super();
		this.total = total;
		this.id = id;
	}

	public MoneyEntity() {
		super();
	}

	@Override
	public String toString() {
		return "Money [total=" + total + ", id=" + id + "]";
	}

}
