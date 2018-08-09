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
			<form action="reply" method="post">
				<input type="hidden" name="bId" value="${reply_view.bId}"> <input
					type="hidden" name="bGroup" value="${reply_view.bGroup}"> <input
					type="hidden" name="bStep" value="${reply_view.bStep}"> <input
					type="hidden" name="bIndent" value="${reply_view.bIndent}">
				<tr height="40">
					<td align="center" width="70">번호</td>
					<td>${reply_view.bId}</td>
				</tr>
				<tr height="40">
					<td align="center" width="70">히트</td>
					<td>${reply_view.bHit}</td>
				</tr>
				<tr height="40">
					<td align="center" width="70">이름</td>
					<td><input type="text" name="bName"
						value="${reply_view.bName}" class="form-control"></td>
				</tr>
				<tr height="40">
					<td align="center" width="70">제목</td>
					<td><input type="text" name="bTitle"
						value="[re] ${reply_view.bTitle}" class="form-control"></td>
				</tr>
				<tr height="40">
					<td align="center" width="70">내용</td>
					<td><textarea rows="10" name="bContent" class="form-control">[원글] ${reply_view.bContent}</textarea></td>
				</tr>
				<tr height="40">
					<td colspan="2" align="center"><input type="submit" value="답변" class="btn btn-default">
						<a href="list">목록</a></td>
				</tr>
			</form>
		</table>
		</div>
	</center>
</body>
</html>