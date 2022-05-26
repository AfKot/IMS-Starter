package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;

}
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the id of the Customer");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter the progress status");
		String progress = utils.getString();
		Order order = orderDAO.create(new Order(customerId, progress));
		LOGGER.info("order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		
		LOGGER.info("What would you like to update, Customer or Progress Status or Items");
		
		String scan1 = utils.getString();
		Order nOrder = orderDAO.read(id);
		
		if (scan1.toLowerCase().equals("customer")) {
			LOGGER.info("Please enter the id of the Customer");
			Long customerId = utils.getLong();
			return orderDAO.update(new Order(id, customerId, nOrder.getProgress()));
		} else if (scan1.toLowerCase().equals("progress")) {
			LOGGER.info("Please enter the progress status");
			String progress = utils.getString();
			return orderDAO.update(new Order(id, nOrder.getCustomer_id(), progress));
		} else if (scan1.toLowerCase().equals("items")) {
			LOGGER.info("Please enter the id of item you want to add");
			Long itemId = utils.getLong();
			return orderDAO.addingItems(id, itemId);
		} else { 
			LOGGER.info("Invalid selection");
			return null;
		}
		
	}
		

	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
