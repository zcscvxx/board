<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<div class="container">
		<table class="table table-hover">
			<form action="modify" method="post">
				<input type="hidden" name="bId" value="${content_view.bId}">
				<tr height="40">
					<td align="center" width="70">번호</td>
					<td>${content_view.bId}</td>
				</tr>
				<tr height="40">
					<td align="center" width="70">히트</td>
					<td>${content_view.bHit}</td>
				</tr>
				<tr height="40">
					<td align="center" width="70">이름</td>
					<td><input type="text" name="bName"
						value="${content_view.bName}" class="form-control"></td>
				</tr>
				<tr height="40">
					<td align="center" width="70">제목</td>
					<td><input type="text" name="bTitle"
						value="${content_view.bTitle}" class="form-control"></td>
				</tr>
				<tr height="40">
					<td align="center" width="70">내용</td>
					<td><textarea rows="10" name="bContent" class="form-control">${content_view.bContent}</textarea></td>
				</tr>
				<tr height="40">
					<td colspan="2"><input type="submit" value="수정" class="btn btn-default">
						&nbsp;&nbsp; <a href="list">목록보기</a>
						&nbsp;&nbsp; <a href="delete?bId=${content_view.bId}">삭제</a> &nbsp;&nbsp; <a
						href="reply_view?bId=${content_view.bId}">답변</a></td>
				</tr>
			</form>
		</table>
		</div>
	</center>
</body>
</html>