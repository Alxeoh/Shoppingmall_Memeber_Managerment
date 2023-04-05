package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 인터페이스는 메소드의 집합 
// ㄴ 자식클래스가 정의해야하는 메소드의 선언부만 나열
public interface Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException; 
	
	
}
