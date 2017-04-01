package edu.auburn.page.service;

import edu.auburn.page.entity.Contact;
import edu.auburn.page.utils.PageBean;

/**
 * 3.业务逻辑层接口
 */
public interface IContactService {
	/**
	 * 分页查询数据
	 */
	public void getAll(PageBean<Contact> pb);
}
