<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

  <title>Hello, world!</title>
</head>
<body>
<form action="index" method="post">
  <div class="form-group">
    <label for="name">이름</label>
    <input type="text" name="name" class="form-control" id="name" aria-describedby="name" placeholder="이름을 입력하세요.">
  </div>
  <div class="form-group">
    <label for="major">전공</label>
    <input type="text" name="major" class="form-control" id="major" placeholder="전공을 입력하세요.">
  </div>

  <div>
    <button type="submit" class="btn btn-primary">팀원 추가 하기</button>
  </div>
</form>
<button type="submit" onclick="location.href='/student/list' " class="btn btn-primary"> 모든 팀원 찾기</button>
</body>
</html>