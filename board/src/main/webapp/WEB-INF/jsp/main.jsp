<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bark</title>
    <link href="./css/main2.css?ver=20231220" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="head-bar">
        <div class="hd-left">
            <div class="logo">
                <img src="./images/image 3.svg" alt="no image">
            </div>
            <div class="search-box">
                <img src="./images/icon5.svg" alt="no image">
                <input class="search-bar" type="search" placeholder="Search">
            </div>
        </div>
        <div class="hd-right">
            <div class="user-info">
                <div class="user-text">
                    <div class="user-name">${info.author}</div>
                </div>
            </div>
        </div>
    </div>
    <div class="side-wrap">
        <div class="side-bar">
             <ul class="side-menu">
                <li class="side-main active"><img src="./images/icon43.svg">Home</li>
                <li><img src="./images/icon29.svg">Community</li>
            </ul>
            <div class="sign-out">
                <img src="./images/button4.svg">
            </div>
        </div>
    </div>
    <div class="design-main">
        <div class="ds-main-wrap">
            <div class="ds-main-head">
                <button class="ds-pj-type">글 작성</button>
            </div>
            <div class="ds-cnts-list">
            <c:forEach items="${list}" var="list">
                <div class="contents">
                <input type="hidden" value="${list.board_id}">
                    <div class="con-file-title">
                        <div class="title-edit">
                            <div class="file-name">${list.title}</div>
                            <div class="edit-recent">${list.createdAt}</div>
                        </div>
                        <div class="user-author">
                            <div class="author">${list.author}</div>
                        </div>
                    </div>
                    <div class="con-thumbnail">
                        <a href="detailBoard.do?board_id=${list.board_id}"><img src=${list.imageFile }></a>
                    </div>
                </div>
            </c:forEach>
            </div>
        </div>
    </div>
    <script>
    document.querySelector('.sign-out').addEventListener('click', function() {
    	window.location.href='logout.do';
    });
    
    document.querySelector('.ds-pj-type').addEventListener('click', function() {
    	window.location.href='createBoard.do';
    })
    </script>
</body>
</html>