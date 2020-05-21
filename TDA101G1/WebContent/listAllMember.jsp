<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>
<!DOCTYPE html>

<%-- <% 
	MemberService service = new MemberService();
	List<MemberVO> members = service.getAll();
	pageContext.setAttribute("members", members);
%> --%>
<jsp:useBean id="members" scope="page"
	class="com.member.model.MemberService" />
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel=stylesheet type="text/css"
	href="<%=request.getContextPath()%>/vendors/bootstrap/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<nav
		class="navbar navbar-expand navbar-light d-flex justify-content-start"
		style="background-color: #e3f2fd;">
		<a class="navbar-brand mr-auto" href="#"> <img
			src="<%=request.getContextPath()%>/img/logo.png" width="30" height="30"
			class="d-inline-block align-top" alt="tourism"> Tourism
		</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#"><i
					class="fas fa-pen"></i>建立行程</a></li>
			<li class="nav-item"><a class="nav-link" href="#"><i
					class="fas fa-store"></i>商城</a></li>
			<li class="nav-item"><a class="nav-link" href="#"><i
					class="fas fa-shopping-cart"></i>購物車</a></li>
			<li class="nav-item"><a class="nav-link" href="#"><i
					class="fas fa-sign-in-alt"></i>會員中心</a></li>
			<li class="nav-item"><a class="nav-link" href="#"><i
					class="fas fa-user"></i>USER</a></li>
		</ul>
	</nav>
	<form method="post" action="<c:url value="/member/login.controller" />">
		<input type="text" name="account" placeholder="帳號" value="${account }"><span>${errorMsg.account }</span>
		<input type="password" name="password" placeholder="密碼"> <span>${errorMsg.password }</span>
		<div>${errorMsg.login }</div>
		<div>${errorMsg.other }</div>
		<input type="hidden" name="action" value="login"> 
		<input type="submit" value="login">

	</form>
	<h1>所有員工</h1>
<%-- 	<c:forEach var="members" items="${members.all}">
		<h3>ID:${members.member_ID}</h3>
		<h3>ACCOUNT:${members.member_Account}</h3>
		<h3>PWD:${members.member_Pwd }</h3>

	</c:forEach> --%>

	<c:if test="${not empty member}">
		<h4>
			<span>${member.member_Account}</span><br> <span>${member.member_Name}</span><br>
		</h4>
	</c:if>

	<table class="table table-hover">
		<thead>
			<tr>
				<th style="width: 5%" scope="col">#</th>
				<th style="width: 10%" scope="col">選擇</th>
				<th style="width: 10%" scope="col">ID</th>
				<th style="width: 20%" scope="col">ACCOUNT</th>
				<th style="width: 20%" scope="col">PASSWORD</th>
				<th style="width: 35%" scope="col">建立時間</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="members" items="${members.all}" varStatus="loop">
			<%int a = 1; %>
			<tr>
				<th scope="row">${loop.count }</th>
				<td><input type="checkbox"></td>
				<td>${members.member_ID}</td>
				<td>${members.member_Account}</td>
				<td>${members.member_Pwd}</td>
				<td>${members.member_Est_Time }</td>
				
			</tr>
			<% a++; %>
		</c:forEach>
		</tbody>
	</table>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.4.1.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/vendors/bootstrap/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/vendors/popper/popper.min.js"></script>
</body>
</html>