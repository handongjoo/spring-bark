<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/register.css?ver=2">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<title>Bark</title>
</head>
<body>
    <h1><img src="./images/image 3.svg">Bark</h1>
    <form id="register-form" class="register-form">
    
    	<label for="author">사용할 아이디</label>
    	<div id="auth-validate">아이디는 4자이상 20자 이하의 영문 혹은 한글만 가능합니다.</div>
        <input type="text" id="author" placeholder="아이디" maxlength="20"/>
        
        <label for="password">비밀번호</label>
        <div id="pw-validate">비밀번호는 8자이상 20자 이하의 숫자+영문+특수문자 조합으로 만들어야합니다.</div>
        <input type="password" id="password" placeholder="비밀번호" maxlength="20"/>
        
        <label for="check-password">비밀번호 확인</label>
        <div id="check-validate">비밀번호가 일치하지 않습니다.</div>
        <input type="password" id="check-password" placeholder="비밀번호 확인" maxlength="20"/>
        
        <input type="submit" class="register-btn" value="회원가입"/>
        
        <div class="division"></div>
    
    </form>
    <button class="loginPage">로그인 페이지로</button>
    <script>
    function userValidate() {
    	const author = document.getElementById('author').value;
    	const password = document.getElementById('password').value;
    	const checkPassword = document.getElementById('check-password').value;
    	const authValidate = document.getElementById('auth-validate');
    	const pwValidate = document.getElementById('pw-validate');
    	const checkValidate= document.getElementById('check-validate');
    	
    	const authorRegex = /^[a-zA-Z가-힣]{4,20}$/;
    	const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[a-zA-Z\d@$!%*?&]{8,20}$/;
    	
        if(!authorRegex.test(author)) {
            authValidate.style.display="block";
            return false;
        } else {
            authValidate.style.display="none";
        }
        
        // 비밀번호 유효성 검증
        if (!pwRegex.test(password)) {
            pwValidate.style.display="block";
            return false;
        } else {
            pwValidate.style.display="none";
        }
        
        // 비밀번호 확인 일치 여부 검증
        if (password !== checkPassword) {
            checkValidate.style.display="block";
            return false;
        } else {
            checkValidate.style.display="none";
        }
    	
    	$.ajax({
    		type:"POST",
    		url:"registerUser.do",
    		data:{author, password},
    		success: function(response) {
    			if(response === "success") {
    				alert('회원가입에 성공했습니다.');
    				window.location.href = "login.do"
    			}
    		}, error: function(err) {
      		  alert('AJAX오류');
    		  console.log(err)
    	  }
    	});
    	return false;
    }
    
    document.getElementById('register-form').onsubmit = userValidate;
    
    document.querySelector('.loginPage').addEventListener('click', function() {
    	
    	window.location.href="login.do";
    })

    </script>
</body>
</html>