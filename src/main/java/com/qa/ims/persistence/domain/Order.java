package com.qa.ims.persistence.domain;

import java.util.List;

public class Order {
	
	// Fields
	private Long id;
	private Long customer_id;
	private List<Item> allItems;
	private String progress;
	private Double total;
	
	public Order(Long customer_id, List<Item> allItems, String progress, Double total) {
		super();
		this.customer_id = customer_id;
		this.allItems = allItems;
		this.progress = progress;
		this.total = total;
	}
	
	public Order(Long id, Long customer_id, List<Item> allItems, String progress, Double total) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.allItems = allItems;
		this.progress = progress;
		this.total = total;
	}
	
	public Order(Long id, Long customer_id, String progress) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.progress = progress;
	}
	
	

	public Order(Long customer_id, String progress) {
		super();
		this.customer_id = customer_id;
		this.progress = progress;
	}

	public Order(Long customer_id) {
		super();
		this.customer_id = customer_id;
	}


	public Order(Long id, Long customer_id) {
		super();
		this.id = id;
		this.customer_id = customer_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public List<Item> getAllItems() {
		return allItems;
	}

	public void setAllItems(List<Item> allItems) {
		this.allItems = allItems;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer_id=" + customer_id + ", allItems=" + allItems + ", progress=" + progress
				+ ", total=" + total + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allItems == null) ? 0 : allItems.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((progress == null) ? 0 : progress.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (allItems == null) {
			if (other.allItems != null)
				return false;
		} else if (!allItems.equals(other.allItems))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (progress == null) {
			if (other.progress != null)
				return false;
		} else if (!progress.equals(other.progress))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	
	
}
