<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="login.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="form-wrapper">
        <p class="login-title">Login</p>
        <form action="" class="login-form" id="login-form">
            <div class="id-form">
                <label for="id">ID</label>
                <input type="text" name="id" id="id" maxlength="50"/>
            </div>
            <div class="pw-form">
                <label for="pw">Password</label>
                <input type="password" name="pw" id="pw" maxlength="20"/>
            </div>
            <input type="submit" class="login-btn" id="login-btn" value="로그인">
        </form>
    </div>


    <script type="text/javascript" src="index.js"></script>
</body>
</html>