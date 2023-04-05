package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import U.PracticeDto;
import U.controller.PracticeDao;
import controller.Action;

public class JoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 회원등록 처리로직
		String no = request.getParameter("custno");
		int custno = 0;
		if(no != null)
			custno = Integer.parseInt(no);

		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");

		PracticeDao practiceDao = PracticeDao.getInstance();
		PracticeDto practiceDto = new PracticeDto(custno, custname, phone, address, joindate, grade, city);

		 if(practiceDao.createMember(practiceDto)){
			System.out.println("회원가입 성공!");
			response.sendRedirect("join");
		}
		else{
			System.out.println("회원가입 실패");
			response.sendRedirect("search");
		} 
		
	}
	

}
