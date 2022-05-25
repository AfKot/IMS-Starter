package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	
	private final ItemDAO DAO = new ItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schemaitem.sql", "src/test/resources/sql-dataitem.sql");
	}
	
	//Testing to see if item created matches what I expect to be created
	@Test
	public void testCreate() {
		final Item created = new Item(2L, "Gummy Bear", 7.99, 150);
		assertEquals(created, DAO.create(created));
		
	}
	
	//Test to see if the list is as expected
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Wallet", 24.50, 10));
		assertEquals(expected, DAO.readAll());

	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Item(1L, "Wallet", 24.50, 10), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long Id = 1L;
		assertEquals(new Item(Id, "Wallet", 24.50, 10), DAO.read(Id));
	}
	
	@Test
	public void testUpdateItem() {
		final Item updated = new Item(1L, "Gummy Bear", 7.99, 150);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testDeleteItem() {
		assertEquals(1, DAO.delete(1));
	}
	
}
