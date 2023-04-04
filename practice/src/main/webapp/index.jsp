<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/mainpage.css?after">
</head>
<body>
<%
DBManager.getConnectionFromMySql();
%>
    <div class="container">
        <header><h1>쇼핑몰 회원 관리 프로그램 ver 1.0</h1></header>
        <nav>
            <a href="join">회원등록</a>
            <a href="search">회원조회/수정</a>
            <a href="searchSales">회원매출조회</a>
            <a href="index">홈으로</a>
        </nav>
        <section>
            <h2>쇼핑몰회원관리 프로그램</h2>
			<p>쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.</p>
			<p>프로그램 작성 순서</p>
			<p>1. 회원정보 테이블을 생성한다.</p>
			<p>2. 매출정보 테이블을 생성한다.</p>
			<p>3. 회원정보, 매출정보 테이블에 제시된 문제지와 참조데이터를 추가 생성한다.</p>
			<p>4. 회원정보 입력 화면프로그램을 작성한다.</p>
			<p>5. 회원정보 조회 프로그램을 작성한다.</p>
			<p>6. 회원매출정보 조회 프로그램을 작성한다.</p>
        </section>
        <footer>© Copyright by EZEN. All rights reserved.</footer>
    </div>
</body>
</html>