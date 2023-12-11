function validateForm() {
    // 입력값 가져오기
    const inputValue = document.getElementById('pw').value;

    // 8글자 ~ 20글자, 문자, 숫자, 특수문자가 하나 이상 포함
    const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[a-zA-Z\d@$!%*?&]{8,20}$/;
    
    if (regex.test(inputValue)) {
      alert("유효한 입력 값입니다.");
      return true; // 제출 허용
    } else {
      alert("유효하지 않은 입력 값입니다.");
      return false; // 제출 차단
    }

  }
  const validateButton = document.getElementById('login-btn');

  // 폼 제출 이벤트 처리
  document.getElementById('login-form').onsubmit = validateForm;