package edu.auburn.page.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.auburn.page.entity.Contact;
import edu.auburn.page.service.IContactService;
import edu.auburn.page.service.impl.ContactService;
import edu.auburn.page.utils.PageBean;
/**
 * 5. Servlet层
 */
public class IndexServlet extends HttpServlet {
	private IContactService contactService = new ContactService();// 创建service实例
	private String uri;//跳转资源
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 1. 获取 当前页 第一次访问当前页 为null
			String currPage = req.getParameter("currentPage");
			// 判断
			if(currPage == null || "".equals(currPage.trim()))
				currPage = "1";
			// 转换
			int currentPage = Integer.parseInt(currPage);
			// 2. 创建PageBean对象，设置当前页参数；传入service方法参数
			PageBean<Contact> pageBean = new PageBean<>();
			pageBean.setCurrentPage(currentPage);
			// 3. 调用service
			contactService.getAll(pageBean);	// pageBean 已经被dao填充了数据
			// 4. 保存pageBean对象到request域中
			req.setAttribute("pb", pageBean);
			// 5. 跳转
			uri = "/WEB-INF/jsp/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/WEB-INF/jsp/error.jsp";
		}
		req.getRequestDispatcher(uri).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
