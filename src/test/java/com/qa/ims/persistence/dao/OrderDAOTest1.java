package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest1 {
	
	private final ItemDAO itemDAO = new ItemDAO();
	private final OrderDAO DAO = new OrderDAO(itemDAO);
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-dataorder.sql");
	}

	//Testing to see if order created matches what I expect to be created
		@Test
		public void testCreateOrder() {
			
			final Order created = new Order(2L, 1L, new ArrayList<>(), "PendingTest", 0D);
			assertEquals(created, DAO.create(created));
			
		}
		
		//Order format(id, customer_id, allItems, progress, total)
		//Test to see if the list of all orders is as expected
		@Test
		public void testReadAll() {
			List<Order> expected = new ArrayList<>();
			List<Item> items = new ArrayList<>();
			items.add(new Item(1L, "Wallet", 24.50, 10));
			expected.add(new Order(1L, 1L, items, "PendingTest", 24.5D));
			assertEquals(expected, DAO.readAll());

		}
		
		@Test
		public void testReadLatest() {
			List<Item> items = new ArrayList<>();
			items.add(new Item(1L, "Wallet", 24.50, 10));
			assertEquals(new Order(1L, 1L, items, "PendingTest", 24.5D), DAO.readLatest());
		}
		
		@Test
		public void testReadOrder() {
			final long Id = 1L;
			List<Item> items = new ArrayList<>();
			items.add(new Item(1L, "Wallet", 24.50, 10));
			assertEquals(new Order(Id, 1L, items, "PendingTest", 24.5D), DAO.read(Id));
		}
		
		@Test
		public void testUpdateOrder() {
			List<Item> items = new ArrayList<>();
			items.add(new Item(1L, "Wallet", 24.50, 10));
			final Order updated = new Order(1L, 1L, items, "PendingTest", 24.5D);
			assertEquals(updated, DAO.update(updated));
	}

		
		@Test
		public void testDeleteOrder() {
			assertEquals(1, DAO.delete(1));
		}
	
		@Test
		public void testAddingItemsToOrder() {
			List<Item> items = new ArrayList<>();
			items.add(new Item(1L, "Wallet", 24.50, 10));
			items.add(new Item(1L, "Wallet", 24.50, 10));
//			items.add(new Item(2L, "Gummy Bear", 7.99, 150));
			
			
			final Order updated = new Order(1L, 1L, items, "PendingTest", 49.0D);
			
			assertEquals(updated, DAO.addingItems(1L, 1L));
		}
	
}
