package U;

import U.controller.PracticeDao;

public class Practice {
	
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private String joindate;
	private String grade;
	private String city;
	private int sum;
	
	public Practice(int custno, String custname, String phone, String address, String joindate, String grade,
			String city) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}
	
	public Practice(int custno, String custname, String grade, int sum) {
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.sum = sum;
	}
	
	public Practice(String custname, String phone, String address, String joindate, String grade,
			String city) {
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	public Practice(PracticeDto practiceDto) {
		PracticeDao practiceDao = PracticeDao.getInstance();
		
		this.custno = practiceDao.maxUserCnt() +1;
		this.custname = practiceDto.getCustname();
		this.phone = practiceDto.getPhone();
		this.address = practiceDto.getAddress();
		this.joindate = practiceDto.getJoindate();
		this.grade = practiceDto.getGrade();
		this.city = practiceDto.getCity();
	}

	public int getCustno() {
		return this.custno;
	}

	public String getCustname() {
		return this.custname;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddress() {
		return this.address;
	}

	public String getJoindate() {
		return this.joindate;
	}

	public String getGrade() {
		return this.grade;
	}

	public String getCity() {
		return this.city;
	}
	public int getSum() {
		return this.sum;
	}
	
	
	

}
