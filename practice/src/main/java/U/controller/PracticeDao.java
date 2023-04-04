package U.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import U.Practice;
import U.PracticeDto;
import util.DBManager;

public class PracticeDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private PracticeDao() {
	}

	private static PracticeDao instance = new PracticeDao();

	public static PracticeDao getInstance() {
		return instance;
	}

	PracticeDao practiceDao = PracticeDao.getInstance();

	// C

	public boolean createMember(PracticeDto practiceDto) {
		boolean check = false;
		Practice member = new Practice(practiceDto);
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null ) {
			String sql = "Insert into member_tbl_02 values(?, ?, ?, ?,TO_DATE(?, 'YYYY-MM-DD'), ?,?)";

		try {
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.pstmt.setInt(1,member.getCustno());
			this.pstmt.setString(2,member.getCustname());
			this.pstmt.setString(3,member.getPhone());
			this.pstmt.setString(4,member.getAddress());
			this.pstmt.setString(5,member.getJoindate());
			this.pstmt.setString(6,member.getGrade());
			this.pstmt.setString(7,member.getCity());
			
			this.pstmt.execute();
			check = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		}
		
		return check;
	}

//	public boolean createUser(PracticeDto practiceDto) {
//		boolean check = false;
//		Practice practice = new Practice(practiceDto);
//		this.conn = DBManager.getConnection();
//		if (conn != null) {
//
//			try {
//				String sql = "Insert into member_tbl_02(custname, phone, address, joindate, grade, city) values(?,?,?,TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";
//				this.pstmt = this.conn.prepareStatement(sql);
//				
//				pstmt.setString(1, practice.getCustname());
//				pstmt.setString(2, practice.getPhone());
//				pstmt.setString(3, practice.getAddress());
//				pstmt.setString(4, practice.getJoindate());
//				pstmt.setString(5, practice.getGrade());
//				pstmt.setString(6, practice.getCity());
//
//				pstmt.execute();
//				System.out.println("회원등록 성공");
//				check = true;
//			} catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("회원등록 실패");
//			} finally {
//				DBManager.close(conn, pstmt);
//			}
//		}
//		return check;
//	}

	public Practice getUserByCustno(int custno) {
		Practice practice = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM member_tbl_02 WHERE custno=?";
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setInt(1, custno);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String custName = this.rs.getString(2);
					String phone = this.rs.getString(3);
					String address = this.rs.getString(4);
					String joindate = this.rs.getString(5).substring(0,10);
					String grade = this.rs.getString(6);
					String city = this.rs.getString(7);
					practice = new Practice(custno, custName, phone, address, joindate, grade, city);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		return practice;
	}

	// R
	public ArrayList<Practice> getAllUser() {
		ArrayList<Practice> list = new ArrayList<>();

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM member_tbl_02 ORDER BY custno";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int custno = this.rs.getInt(1);
					String custname = this.rs.getString(2);
					String phone = this.rs.getString(3);
					String address = this.rs.getString(4);
					String joindate = this.rs.getString(5);
					String grade = this.rs.getString(6);
					String city = this.rs.getString(7);

					Practice practice = new Practice(custno, custname, phone, address, joindate, grade, city);
					list.add(practice);
				}
			} catch (Exception e) {
				System.out.println("전체보기 실패");
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		return list;
	}

	// U

	public boolean modifyUser(PracticeDto practiceDto) {
		boolean check = false;
		String sql = "UPDATE member_tbl_02 SET custname =? ,phone =?, address =?, joindate =TO_DATE(?, 'YYYY-MM-DD'), grade =?, city =? Where custno = ?";

		this.conn = DBManager.getConnection();
		if(this.conn != null) {
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, practiceDto.getCustname());
			this.pstmt.setString(2, practiceDto.getPhone());
			this.pstmt.setString(3, practiceDto.getAddress());
			this.pstmt.setString(4, practiceDto.getJoindate());
			this.pstmt.setString(5, practiceDto.getGrade());
			this.pstmt.setString(6, practiceDto.getCity());
			this.pstmt.setInt(7, practiceDto.getCustno());
			this.pstmt.execute();
			System.out.println("정보수정 성공");
			check = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("정보수정 실패");
		} finally {
			DBManager.close(conn, pstmt);
		}
		}
		return check;
	}

	public ArrayList<Practice> viewSales() {
		ArrayList<Practice> list = new ArrayList<>();
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM sum_sales";
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.rs = pstmt.executeQuery();
				while (this.rs.next()) {
					int custno = rs.getInt(1);
					String custname = rs.getString(2);
					String grade = rs.getString(3);
					int total = rs.getInt(4);
					Practice practice = new Practice(custno, custname, grade, total);
					list.add(practice);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}

	public int maxUserCnt() {
		int cnt = 100001;
		this.conn = DBManager.getConnection();
		if (conn != null) {
			String sql = "SELECT MAX(custno) FROM member_tbl_02";
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				this.rs.next();
				cnt = this.rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return cnt;
	}

}
