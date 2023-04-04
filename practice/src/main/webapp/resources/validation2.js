function checkValues(htmlForm) {


	const custno = document.getElementById("custno").value;
	const custname = document.getElementById("custname").value;
	const phone = document.getElementById("phone").value;
	const address = document.getElementById("address").value;
	const joindate = document.getElementById("join").value;
	const grade = document.getElementById("grade").value;
	const city = document.getElementById("city").value;

	let url = "modify?custno=" + custno;

	let check = true;

	if (custname === "") {
		alert('회원성명이 입력되지 않았습니다.');
		check = false;
	}
	else if (phone === "") {
		alert('전화번호가 입력되지 않았습니다.');
		check = false;
	}
	else if (address === "") {
		alert('회원주소가 입력되지 않았습니다.');
		check = false;
	}
	else if (joindate === "") {
		alert('가입일자가 입력되지 않았습니다.');
		check = false;
	}
	else if (grade === "") {
		alert('회원등급이 입력되지 않았습니다.');
		check = false;
	}
	else if (city === "") {
		alert('도시코드가 입력되지 않았습니다.');
		check = false;
	}
	
	if (check === false) {
		location.href = url;
	}
	else {
		htmlForm.submit();
	}
}
