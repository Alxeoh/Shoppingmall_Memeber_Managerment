<%@page import="U.Practice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="U.controller.PracticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/searchpage.css">
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
			<table>
				<thead>
					<tr>
						<td>회원번호</td>
						<td>회원성명</td>
						<td>전화번호</td>
						<td>회원주소</td>
						<td>가입일자</td>
						<td>고객등급</td>
						<td>지역번호</td>
					</tr>
				</thead>
				<tbody>
					<%
					PracticeDao practiceDao = PracticeDao.getInstance();
					ArrayList<Practice> list = practiceDao.getAllUser();
					for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><a href="modify?custno=<%=list.get(i).getCustno()%>"><%=list.get(i).getCustno()%></a></td>
						<td><%if(list.get(i).getCustname() ==null){continue;} %><%=list.get(i).getCustname()%></td>
						<td><%=list.get(i).getPhone()%></td>
						<td><%=list.get(i).getAddress()%></td>
						<td><%=list.get(i).getJoindate().substring(0,10)%></td>
						<td>
							<%
							if (list.get(i).getGrade().equals("A")) {
							%> VIP <%
							} else if (list.get(i).getGrade().equals("B")) {
							%> 일반 <%
							} else if (list.get(i).getGrade().equals("C")) {
							%> 직원 <%
							}
							%>
						</td>
						<td><%=list.get(i).getCity()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</section>
		<footer>© Copyright by EZEN. All rights reserved.</footer>
	</div>
</body>
</html>