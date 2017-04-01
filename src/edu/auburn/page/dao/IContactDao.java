package edu.auburn.page.dao;

import edu.auburn.page.entity.Contact;
import edu.auburn.page.utils.PageBean;
/**
 * 1. DAO接口
 */
public interface IContactDao {
	/**
	 * 分页查询数据
	 */
	public void getAll(PageBean<Contact> pb);
	/**
	 * 查询记录总数
	 * @return
	 */
	public int getTotalCount();
	/**
	 * 增加联系人
	 * @param c
	 */
	public void addContact(Contact c);
}
