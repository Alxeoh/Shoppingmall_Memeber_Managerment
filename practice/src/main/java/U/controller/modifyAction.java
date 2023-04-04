package U.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import U.PracticeDto;

/**
 * Servlet implementation class modifyAction
 */
//@WebServlet("/modify")
public class modifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
	}

}
