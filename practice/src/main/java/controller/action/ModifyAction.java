package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import U.PracticeDto;
import U.controller.PracticeDao;
import controller.Action;

public class ModifyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PracticeDao practiceDao = PracticeDao.getInstance();
		int maxCnt = practiceDao.maxUserCnt();
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("custno");
		int custno = 0;
		if(no != null)
			custno = Integer.parseInt(no);
		String custname = request.getParameter("custname"); // null
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");

		PracticeDto practiceDto = new PracticeDto(custno, custname, phone, address, joindate, grade, city);
		if(practiceDao.modifyUser(practiceDto)){
			System.out.println("정보수정 성공!");
			response.sendRedirect("search");
		}
		else{
			System.out.println("정보수정 실패");
			response.sendRedirect("search");
		} 
		
	}

}
