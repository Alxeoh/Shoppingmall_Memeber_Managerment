package U;

public class PracticeDto {

	private int custno;
	private String custname;
	private String phone;
	private String address;
	private String joindate;
	private String grade;
	private String city;

	public PracticeDto(int custno, String custname, String phone, String address, String joindate, String grade,
			String city) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	public PracticeDto(String custname, String phone, String address, String joindate, String grade, String city) {
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
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

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
