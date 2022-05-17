<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="study" tagdir="/WEB-INF/tags" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Insert title here</title>
</head>
<body>
<study:studyTag></study:studyTag>
<hr style="color:black; height: 3px; "/>
<h1 style = "text-align: center; font-size: 60px; margin-top: 20px;"> 중앙 게시판 </h1>
<c:url value="/study/studyWrite" var="write" />
	<h2 style="margin-left: 20px;"><a href="${write }"><button class="btn btn-primary">글 쓰기</button></a></h2>
	
	<hr style="color:black; height: 3px; "/>

	<%-- 게시판 메인 리스트 --%>
	<table class="table">
		<thead>
			<tr>
				<th>작성자ID</th>
				<th style = "text-align:center;">제목</th>
				<th style = "text-align: right;">작성일자</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items = "${boardList }" var = "board">
				<tr>
					<td>${board.id }</td>
					<td style = "text-align: center;">
					<c:url value="/study/studyBoard/${board.id }" var="link"></c:url>
					<a href="${link }" style="color:black;">
						${board.title }
					</a>
					<c:if test="${board.numOfReply > 0 }">
						(${board.numOfReply })
					</c:if>

					
					</td>
					<td style = "text-align: right;">${board.inserted }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	

</body>
</html>