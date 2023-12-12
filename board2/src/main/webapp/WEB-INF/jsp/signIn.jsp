<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/login.css?ver=1">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <title>SignIn</title>
</head>
<body>
    <h1><img src="./images/image 3.svg">Bark</h1>
    <form id="login-form" class="login-form">
        <input type="text" id="author" placeholder="아이디" maxlength="20"/>
        <input type="password" id="password" placeholder="비밀번호" maxlength="20"/>
        <input type="submit" class="login-btn" value="로그인"/>
        <div class="division"></div>
    </form>
    <button class="signup-btn">새 계정 만들기</button>
    <script>
    function validateForm() {
        const password = document.getElementById('password').value;
        const author = document.getElementById('author').value;

        // 8글자 ~ 20글자, 문자, 숫자, 특수문자가 하나 이상 포함
        const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[a-zA-Z\d@$!%*?&]{8,20}$/;
        
        if (!author) {
        	alert("아이디를 입력하세요")
        	return false;
        }
        if (!password) {
        	alert("패스워드를 입력하세요")
        	return false;
        }
        if (!regex.test(password)) {
          alert("비밀번호는 숫자+문자+특수문자를 포함하여 8자 이상 20자 이하로 입력해야합니다.");
          return false;
        }
        
          $.ajax({
        	  type: 'POST',
        	  url: 'loginAction.do',
        	  data: {author, password},
        	  success: function(response) {
        		  if(response === 'success') {
	        		  window.location.href = 'main.do'    			  
        		  } else {
        			  alert('존재하지 않는 유저이거나 비밀번호가 틀렸습니다.');
        		  }
        	  },
        	  error: function(err) {
        		  alert('AJAX오류');
        		  console.log(err)
        	  }
          });
		return false;
        }

      document.getElementById('login-form').onsubmit = validateForm;
      
      document.querySelector('.signup-btn').addEventListener('click', function() {
    	  window.location.href="register.do"
      })
    </script>
</body>
</html>