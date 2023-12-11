function validateForm() {

    const pw = document.getElementById('pw').value;
	const author= document.getElementById('author').value;

    const regex = /^[a-zA-Z0-9]/;
    
    if (!regex.test(pw) || !regex.test(author)) {
      alert("작성자와 비밀번호에는 특수문자를 사용할 수 없습니다.");
      return false;
    } else {
      return true;
    }

  }
  const submitBtn = document.getElementById('form-btn');

  // 폼 제출 이벤트 처리
  document.getElementById('form-btn').onsubmit = validateForm;