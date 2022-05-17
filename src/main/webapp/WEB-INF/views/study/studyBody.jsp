<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	referrerpolicy="no-referrer"></script>
<%@ taglib prefix="study" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css"
	integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	referrerpolicy="no-referrer"></script>
<script>
	$(document).ready(function(){
	$("#delete-submit1").click(function(e) {
		e.preventDefault();
		
		if (confirm("삭제하시겠습니까?")) {
			let form1 = $("#form1");
			let actionAttr = "${appRoot }/study/remove";
			form1.attr("action", actionAttr);
			
			form1.submit();
		}
		
	});
	$("#replydeletebutton").click(function() {
		const replyId = $(this).attr("data-reply-id");
		const message = "댓글을 삭제하시겠습니까?";
		
		if (confirm(message)) {
			$("#replyDeleteInput1").val(replyId);
			$("#replyDeleteForm1").submit();
		}
	});
})
</script>
	
<title>Insert title here</title>
</head>
<body>
	<study:studyTag></study:studyTag>
	<hr style="color: black; height: 3px;" />
	<%-- 게시글 본문 메인 --%>

	<div class="container">
		<div class="row">
			<div class="col">
				<form action="${appRoot }/study/modify" method="post">
					<h3>작성자 ID : ${bodyS.id }</h3>


					<input type="hidden" name="id" value="${bodyS.id }" />

					<div>
						<label class="form-label" for="input1"></label>
						<input class="form-control" type="text" name="title" required
							id="input1" value="${bodyS.title }" style="font-size: 25px;" />
					</div>

					<div>
						<label class="form-label" for="textarea1"></label>
						<textarea class="form-control" name="body" id="textarea1"
							cols="30" rows="10" style="font-size: 15px;">${bodyS.body }</textarea>
					</div>

					<div>
						<label for="input2" class="form-label">작성일시</label>
						<input class="form-control" type="datetime-local"
							value="${bodyS.inserted }" readonly />
					</div>
					<br />

					<button id="edit-button1" class="btn btn-primary">수정</button>
				</form>
				<form id="form1"action="${appRoot }/study/remove" method="post">
					<input type="hidden" name="id" value="${bodyS.id }" />
					<button id="delete-submit1" class="btn btn-danger" data-bs-toggle="button">삭제</button>
				</form>

				<hr />
				<h4>댓글 작성</h4>
				<form action="${appRoot }/study/reply" method="post">
					<input type="hidden" name="boardId" value="${bodyS.id }" />
					<input type="text" name="content" size="50" />
					<button class="btn btn-primary" data-bs-toggle="button">쓰기</button>
				</form>

				<hr />

				<div>
					<c:forEach items="${replyList }" var="reply">

						<div style="border: 1px solid black; background-color:#ffff99 ;">
							${reply.inserted } :

							<%-- 댓글 수정 --%>
							<form action="${appRoot }/study/replyModify" method="post">
								<input type="hidden" value="${reply.id }" name="id" />
								<input type="hidden" name="boardId" value="${bodyS.id }" />
								<input type="text" value="${reply.content }" name="content" />

								<button class="btn btn-primary" data-bs-toggle="button">수정</button>

							</form>

							<%-- 댓글 삭제 --%>
							<form action="${appRoot }/study/ReplyRemove" method=post>
								<input type="hidden" name="id" value="${reply.id }" />
								<input type="hidden" name="boardId" value="${bodyS.id }" />
								<button id="replydeletebutton" class="btn btn-danger" data-bs-toggle="button">삭제</button>
							</form>
						</div>
					</c:forEach>
				</div>


			</div>
		</div>
	</div>

</body>
</html>