package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;
	
	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long id = 1L;
		final Order created = new Order(id);
		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

//		Mockito.verify(utils, Mockito.times(1)).getString();
//		Mockito.verify(utils, Mockito.times(1)).getDouble();
//		Mockito.verify(utils, Mockito.times(1)).getInt();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, "PendingTest"));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testCustomerUpdate() {
		Order updated = new Order(1L, 1L, "PendingTest");
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn("customer");
		Mockito.when(this.dao.read(updated.getId())).thenReturn(updated);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getCustomer_id());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);
		assertEquals(updated, this.controller.update());
	}
		
	@Test
	public void testProgressupdate() {
		Order updated = new Order(1L, 1L, "PendingTest");
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn("progress", updated.getProgress());
		Mockito.when(this.dao.read(updated.getId())).thenReturn(updated);
		Mockito.when(this.dao.update(updated)).thenReturn(updated);
		assertEquals(updated, this.controller.update());
	}
	
	@Test
	public void testItemUpdate() {
		Order updated = new Order(1L, 1L);
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn("items");
		Mockito.when(this.dao.addingItems(1L, 1L)).thenReturn(updated);
		assertEquals(updated, this.controller.update());
		
	}

//		Mockito.verify(this.utils, Mockito.times(1)).getLong();
//		Mockito.verify(this.utils, Mockito.times(1)).getString();
//		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
//		Mockito.verify(this.utils, Mockito.times(1)).getInt();
//		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

//		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	@Test
	public void testUpdateInvalid() {

	Mockito.when(this.utils.getLong()).thenReturn(1L);
	Mockito.when(this.utils.getString()).thenReturn("2232");
	//Mockito.when(this.dao.update(updated)).thenReturn(updated);
	assertEquals(null, this.controller.update());

	}

}
