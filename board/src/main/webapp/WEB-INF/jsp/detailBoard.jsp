<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bark</title>
    <link href="./css/detailBoard2.css?ver=20231225" rel="stylesheet" type="text/css" />
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <div class="conents-box">
    <input type="hidden" id="board_id" value="${data.board_id }">
        <div class="contents">
            <div class="con-file-title">
                <div class="title-edit">
                    <div class="file-name">${data.title}</div>
                    <div class="edit-recent">${data.createdAt}</div>
                </div>
                <div class="user-author">
                    <div class="author">${data.author}</div>
                </div>
            </div>
            <div class="con-file-content">${data.content}</div>
            <div class="con-img">
                <img src="${data.imageFile}">
            </div>
            <c:if test="${info.author eq data.author}">
			<div class="edit-btn">
	            <button id="update-btn">수정</button>
	            <button id="delete-btn">삭제</button>
			</div>
            </c:if>
            <div class="division-line"></div>
            <div class="comments-list">
            	<c:forEach items="${list}" var="list">
                <div class="comments-wrap">
                    <div class="cmt-user-name">${list.author}</div>
                    <div class="cmt-content">${list.c_content}
                   <c:if test="${info.author eq list.author}">
                   <span><button>삭제</button></span>
                   </c:if>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <form class="write-comment-wrap" id="write-comment-form">
        <div class="form-box">
            <div class="write-comment-my-name" id="author">${info.author}</div>
            <textarea class="write-comment-box" id="c_content" placeholder="댓글을 입력하세요."></textarea>
            <input type=submit class="insert-comment-btn" value="댓글 작성" />
        </div>
    </form>
    
    <script>
    function commentValidation() {
    	const c_content= document.getElementById('c_content').value;
    	const author= document.getElementById('author').textContent;
    	const board_id= document.getElementById('board_id').value;

        const spaceRegex = /^\s+$/;
    	
        if (!c_content) {
            alert("댓글을 작성해주세요.")
            return false;
          }
         if (c_content.charAt(0) === ' ') {
             alert("댓글은 공백으로 시작할 수 없습니다.");
             return false;
         }
         if (spaceRegex.test(c_content)) {
             alert("댓글은 공백으로만 작성할 수 없습니다.");
             return false;
         }
         
         console.log(c_content, author, board_id);
    	
	    $.ajax({
	        type: 'POST',
	        url: 'insertComment.do',
	        data: {c_content, board_id, author},
	        success: function(response) {
	          alert("성공");
	          window.location.href = 'detailBoard.do?board_id='+ board_id;
	        },
	        error: function(err) {
	          alert("실패");
	          console.log(err)
	        }
	      });
	    return false;
    }
    document.getElementById('write-comment-form').onsubmit = commentValidation;
    
    document.getElementById("delete-btn").addEventListener('click', function() {
    	const board_id= document.getElementById('board_id').value;
    	console.log(board_id)
		$.ajax({
			type:"POST",
			url:"deleteBoard.do",
			data:{board_id},
			success: function(response) {
				if(response === "success") {
					alert("삭제 성공");
					window.location.href = "main.do"
				} else {
					alert("삭제 실패")
					return false
				}
			},
			error: function(err) {
				alert("AJAX 실패");
				console.log(err);
			}
		});
		return false;
    })
    </script>
</body>
</html>