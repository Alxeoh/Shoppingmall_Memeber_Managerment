<%@page import="U.Practice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="U.controller.PracticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/showpage.css?after">
</head>
<body>
	<div class="container">
		<header>
			<h1>쇼핑몰 회원 관리 프로그램 ver 1.0</h1>
		</header>
		<nav>
			<a href="join">회원등록</a> <a href="search">회원조회/수정</a> <a
				href="searchSales">회원매출조회</a> <a href="index">홈으로</a>
		</nav>
		<section>
			<h2>회원매출조회</h2>
			<table>
				<thead>
					<tr>
						<td>회원번호</td>
						<td>회원성명</td>
						<td>회원등급</td>
						<td>매출</td>
					</tr>
				</thead>
				<tbody>
					<%
					PracticeDao practiceDao = PracticeDao.getInstance();
					ArrayList<Practice> list = practiceDao.viewSales();
					for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><%=list.get(i).getCustno()%></td>
						<td><%=list.get(i).getCustname()%></td>
						<td><%=list.get(i).getGrade()%></td>
						<td><%=list.get(i).getSum()%></td>
					</tr>
					<%}%>
				</tbody>
			</table>
		</section>
		<footer>© Copyright by EZEN. All rights reserved.</footer>
	</div>
</body>
</html>