package edu.auburn.page.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.auburn.page.dao.IContactDao;
import edu.auburn.page.entity.Contact;
import edu.auburn.page.utils.JdbcUtils;
import edu.auburn.page.utils.PageBean;
/**
 * 2.DAO接口的实现
 */
public class ContactDao implements IContactDao{
	@Override
	public void getAll(PageBean<Contact> pb) {
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		/*
		 * 问题：JSP页面，如果当前页为首页，再点击上一页报错；若当前页为尾页，再点击下一页显示有问题！
		 * 
		 * 解决：
		 * 		1.若当前页 <= 0, 则设置当前页为1
		 * 		2.若当前页 > 最大页数， 则设置当前页等于最大页数
		 */
		if(pb.getCurrentPage() <= 0){
			pb.setCurrentPage(1);
		}else if(pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		// 1.获取当前页：计算查询的起始行,返回的行数
		int currentPage = pb.getCurrentPage();
		int count = pb.getPageCount();
		int index = (currentPage - 1) * count;

		// 分页查询数据；把查询到的数据设置到pb对象中
		String sql = "select * from contact limit ? , ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			List<Contact> pageData = qr.query(sql, new BeanListHandler<>(Contact.class), index, count);
			pb.setPageData(pageData);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from contact";
		try {
			QueryRunner qr = JdbcUtils.getQueryRunner();
			Long count = qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addContact(Contact c) {
		String sql = "insert into contact values (?,?,?,?)";
		try {
			QueryRunner qr = JdbcUtils.getQueryRunner();
			qr.update(sql,c.getId(),c.getName(),c.getEmail(),c.getTel());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
