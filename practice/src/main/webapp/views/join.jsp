<%@page import="U.controller.PracticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/joinpage1.css?after">
</head>
<body>
	<%
	PracticeDao practiceDao = PracticeDao.getInstance();
	int custno = practiceDao.maxUserCnt() + 1;
	
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	
	System.out.println(custno);
	System.out.println(custname);
	System.out.println(phone);
	System.out.println(address);
	System.out.println(joindate);
	System.out.println(grade);
	System.out.println(city);
	%>
	<div class="container">
		<header>
			<h1>쇼핑몰 회원 관리 프로그램 ver 1.0</h1>
		</header>
		<nav>
			<a href="join">회원등록</a> <a href="search">회원조회/수정</a> <a
				href="searchSales">회원매출조회</a> <a href="index">홈으로</a>
		</nav>
		<section>
			<form method="post" action="joinAction">
				<table>
					<h2>홈쇼핑 회원등록</h2>
					<tr>
						<td>회원번호 :</td>
						<td><input type="text" id="custno" name="custno"
							value="<%=custno%>" readonly></td>
					</tr>
					<tr>
						<td>회원성명 :</td>
						<td><input type="text" id="custname" name="custname" value="<%=custname != null ? custname : ""%>" <%=custname == null ? "autofocus" : ""%>></td>
					</tr>
					<tr>
						<td>회원전화 :</td>
						<td><input type="text" id="phone" name="phone" value="<%=phone != null ? phone : ""%>" <%=phone == null ? "autofocus" : ""%>></td>
					</tr>
					<tr>
						<td>회원주소 :</td>
						<td><input type="text" id="address" name="address" value="<%=address != null ? address : ""%>" <%=address == null ? "autofocus" : ""%>></td>
					</tr>
					<tr>
						<td>가입일자 :</td>
						<td><input type="date" id="join" name="joindate" value="<%=joindate != null ? joindate : ""%>" <%=joindate == null ? "autofocus" : ""%>></td>
					</tr>
					<tr>
						<td>고객등급<br>(A: VIP, B: 일반, C: 직원) :
						</td>
						<td>
						<select id="grade" name="grade">
								<option value="A" <%=grade != null && grade.equals("A") ? "selected" : "" %>>A</option>
								<option value="B" <%=grade == null || grade.equals("B") ? "selected" : "" %>>B</option>
								<option value="C" <%=grade != null && grade.equals("C") ? "selected" : "" %>>C</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>도시코드 :</td>
						<td><input type="text" id="city" name="city" value="<%=city != null ? city : ""%>" <%=city == null ? "autofocus" : ""%>></td>
					</tr>
				</table>
				<div>
					<button type="button" onclick="checkValues(form)">등록</button>
					<button type="button" onclick="location.href='search.jsp'">조회</button>
				</div>
			</form>
		</section>
		<footer>© Copyright by EZEN. All rights reserved.</footer>
	</div>
	
<script src="../resources/validation.js"></script>
</body>
</html>