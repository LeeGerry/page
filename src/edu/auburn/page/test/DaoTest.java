package edu.auburn.page.test;

import org.junit.Before;
import org.junit.Test;

import edu.auburn.page.dao.IContactDao;
import edu.auburn.page.dao.impl.ContactDao;
import edu.auburn.page.entity.Contact;

public class DaoTest {
	IContactDao dao;
	@Before
	public void init(){
		dao = new ContactDao();
	}
	@Test
	public void addTest(){
		for(int i = 10;i<50;i++)
			dao.addContact(new Contact(i,"wangliu"+i,i+"wang@aw.com",999+i));
	}
}
