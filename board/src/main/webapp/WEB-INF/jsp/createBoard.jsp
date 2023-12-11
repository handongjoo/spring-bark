<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bark</title>
    <link href="./css/createBoard2.css?ver=12312" rel="stylesheet" type="text/css" />
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <div class="create-wrap">
        <h3>게시물 작성</h3>
        <form id="create-box" class="create-box" enctype="multipart/form-data">
            <div class="my-info" id="my-info">${info.author}</div>
            <input type="text" class="write-content-title" id="title" placeholder="제목을 입력하세요" maxlength="100"/>
            <textarea class="write-content-box" id="content" placeholder="${info.author}님, 무슨 생각을 하고 계신가요?" maxlength="1000"></textarea>
            <img id="image-preview" src="#" alt="Image Preview">
            <label for="image-upload" class="img-icon-box">이미지 업로드</label>
              <input id="image-upload" type="file" name="imageFile">
            <input type="submit" class="submit-btn" value="게시"/>
        </form>
    </div>
<script>
function validateForm() {
	const title= document.getElementById('title').value;
	const content= document.getElementById('content').value;
	const author = document.getElementById('my-info').textContent;
	alert(title);

    const spaceRegex = /^\s+$/;

    if (!title || !content) {
      alert("모든 항목을 작성해주세요.")
      return false;
    }
    if (title.charAt(0) === ' ') {
        alert("제목은 공백으로 시작할 수 없습니다.");
        return false;
    }
    if (spaceRegex.test(content)) {
        alert("내용은 공백으로만 작성할 수 없습니다.");
        return false;
    }
    
    const data = $('#create-box')[0];
    console.log("data>>>>>"+data);
    alert(data);
    const formData = new FormData(data);
    console.log(formData);
    alert(formData);

    $.ajax({
        type: 'POST',
        url: 'insertBoard.do',
        data: formData,
        contentType: false,
        processData: false,
        success: function (response) {
            alert("성공");
            window.location.href = 'main.do';
        },
        error: function (err) {
            alert("실패");
            console.log(err);
        }
    });
      return false;
    }
  document.getElementById('create-box').onsubmit = validateForm;
  
  document.getElementById('image-upload').addEventListener('change', function(event) {
      var input = event.target;
      var reader = new FileReader();
      var preview = document.getElementById('image-preview');

      reader.onload = function() {
          preview.src = reader.result;
          preview.style.display = 'block';
      };

      reader.readAsDataURL(input.files[0]);
  });
</script>
</body>
</html>