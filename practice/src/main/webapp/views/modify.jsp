<%@page import="U.Practice"%>
<%@page import="U.controller.PracticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/joinpage1.css">
</head>
<body>
<%
String no = request.getParameter("custno");
int custno = 0;
if(no != null){
	custno = Integer.parseInt(no);
}

PracticeDao practiceDao = PracticeDao.getInstance();
Practice practice = practiceDao.getUserByCustno(custno);
%>
    <div class="container">
        <header>
            <h1>쇼핑몰 회원 관리 프로그램 ver 1.0</h1>
        </header>
        <nav>
            <a href="join">회원등록</a>
            <a href="search">회원조회/수정</a>
            <a href="searchSales">회원매출조회</a>
            <a href="index">홈으로</a>
        </nav>
        <section>
            <form method="post" action="modifyAction">
             
             <table>
					<h2>홈쇼핑 회원수정</h2>
					<tr>
						<td>회원번호 :</td>
						<td><input type="text" id="custno" name="custno"
							value="<%=custno%>" readonly></td>
					</tr>
					<tr>
						<td>회원성명 :</td>
						<td><input type="text" id="custname" name="custname" value="<%=practice.getCustname()%>"></td>
					</tr>
					<tr>
						<td>회원전화 :</td>
						<td><input type="text" id="phone" name="phone" value="<%=practice.getPhone()%>"></td>
					</tr>
					<tr>
						<td>회원주소 :</td>
						<td><input type="text" id="address" name="address" value="<%=practice.getAddress()%>"></td>
					</tr>
					<tr>
						<td>가입일자 :</td>
						<td><input type="date" id="join" name="joindate" value="<%=practice.getJoindate()%>"></td>
					</tr>
					<tr>
						<td>고객등급<br>(A: VIP, B: 일반, C: 직원) :
						</td>
						<td>
						<select id="grade" name="grade">
								<option value="A" <%=practice.getGrade() == null || practice.getGrade().equals("A") ? "selected" : practice.getGrade() %>>A</option>
								<option value="B" <%=practice.getGrade() != null && practice.getGrade().equals("B") ? "selected" : practice.getGrade() %>>B</option>
								<option value="C" <%=practice.getGrade() != null && practice.getGrade().equals("C") ? "selected" : practice.getGrade() %>>C</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>도시코드 :</td>
						<td><input type="text" id="city" name="city" value="<%=practice.getCity()%>"></td>
					</tr>
				</table>
             
             
            <div>
                <button type="button" onclick="checkValues(form)">수정</button>
                <button type="button" onclick="location.href='search.jsp'">조회</button>
            </div>
            </form>
        </section>
        <footer>© Copyright by EZEN. All rights reserved.</footer>
    </div>
<script src="../resources/validation2.js?after"></script>
</body>
</html>