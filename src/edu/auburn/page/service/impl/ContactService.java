package edu.auburn.page.service.impl;

import edu.auburn.page.dao.IContactDao;
import edu.auburn.page.dao.impl.ContactDao;
import edu.auburn.page.entity.Contact;
import edu.auburn.page.service.IContactService;
import edu.auburn.page.utils.PageBean;
/**
 * 4.业务逻辑层接口的实现
 */
public class ContactService implements IContactService {
	private IContactDao dao = new ContactDao();
	@Override
	public void getAll(PageBean<Contact> pb) {
		dao.getAll(pb);
	}

}
