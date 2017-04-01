<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>contact list</title>
</head>
<body>
	<table border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Tel</th>
		</tr>
		<c:choose>
			<c:when test="${not empty requestScope.pb.pageData }">
				<c:forEach var="emp" items="${requestScope.pb.pageData }" varStatus="vs">
					<tr>
						<td>${emp.id }</td>
						<td>${emp.name }</td>
						<td>${emp.email }</td>
						<td>${emp.tel }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><td colspan="4" align="center">sorry...no data...</td></tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="center">
			current${requestScope.pb.currentPage}/${requestScope.pb.totalPage}
				<a href="${pageContext.request.contextPath }/index?currentPage=1">First</a>
				<a href="${pageContext.request.contextPath }/index?currentPage=${requestScope.pb.currentPage-1}">Last</a>
				<a href="${pageContext.request.contextPath }/index?currentPage=${requestScope.pb.currentPage+1}">Next</a>
				<a href="${pageContext.request.contextPath }/index?currentPage=${requestScope.pb.totalPage}">Last</a>
			</td>
		</tr>
	</table>
</body>
</html>