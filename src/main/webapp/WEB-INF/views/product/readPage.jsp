<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="../include/startup_header.jsp" />


<main id="main" class="main">

<div class="pagetitle">
	<h1>상품상세보기</h1>
</div>
<section class="section">
	<div class="row">
		<div class="col-lg-12">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title"></h5>

					<!-- General Form Elements -->

					<form role="form">

						<input type='hidden' name='pno' value="${productVO.pno}" id='pno'>
						<input type='hidden' name='page' value="${cri.page}"> 
						<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
						<input type='hidden' name='searchType' value="${cri.searchType}">
						<input type='hidden' name='keyword' value="${cri.keyword}">

					</form>

			<div class="alert alert-light border-light alert-dismissible fade show" role="alert">
                <h4 class="alert-heading">${productVO.pname}</h4>
                <p>${productVO.category}</p>
                <hr>
                <p class="mb-0">${productVO.content}</p>
              </div>
              
              
           <div class="alert alert-light border-light alert-dismissible fade show" role="alert">
             <h4 class="alert-heading">제품 이미지</h4>
               <hr>
               
           <c:if test="${!empty ProductIMGVO}">     
           <c:forEach items="${ProductIMGVO}" var="ProductIMGVO" varStatus="status">
                    <img src="/displayFile?fileName=${ProductIMGVO.fileLocation}" class="img-fluid rounded align-items-center" alt="${ProductIMGVO.imgName}">
                </c:forEach>
                </c:if>

					<c:if test="${empty ProductIMGVO}">
					</c:if>
					<br> <br>
					<div style="text-align: right;">
				</div>
			</div>

						<div class="row mb-3">
							<div class="text-center"> 
									<button type="submit" class="btn btn-danger">삭제</button>
									<button type="submit" class="btn btn-primary">수정</button>
									<button type="submit" class="btn btn-secondary">목록</button>
						</div>
					</div>	
				<!-- 댓글창 -->


				<c:if test="${not empty login}">

					<div class="alert border-info alert-dismissible fade show" role="alert">
					 <h4 class="alert-heading">Comments</h4>
					 <hr>
							<form method="get">
								<c:if
									test="${login.getClass().name eq 'com.b2b.domain.StartUpUserVO'}">
									<input type="hidden" value="${login.sId}" id="newUserNo">
									<input type="hidden" value="${login.name}" id="newUserName">
								</c:if>

								<c:if
									test="${login.getClass().name eq 'com.b2b.domain.BuyerUserVO'}">
									<input type="hidden" value="${login.bId}" id="newUserNo">
									<input type="hidden" value="${login.name}" id="newUserName">
								</c:if>
								
							<div class="text-right">
								<textarea class="form-control form-control-light mb-2" placeholder="Write message" id="newReplyText" rows="3"></textarea>
								<a class="btn btn-outline-primary btn-rounded comentAddBtn" style="font-weight: bold;">댓글 등록</a>
								</div>
							</form>
						</div>
				</c:if>

				<div class="col-lg-12">
				<div class="alert border-primary alert-dismissible fade show">
				<h5 class="mt-0">댓글 목록</h5>
						<div class="card">
							<ul id="comments" class="list-group"
							>
							</ul>
						</div>
						<div style="text-align: right;"></div>
					</div>

				</div>

				<!-- end card-body-->
</div>
</div>

			</div>
			<!-- end card-->
		</div>
		<!-- end col -->
</section>


</main>

<!-- content -->

<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		/* 수정버튼 */
		$(".btn-primary").on("click", function() {
			formObj.attr("action", "/product/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});
		//목록버튼
		$(".btn-secondary").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/product/adminList");
			formObj.submit();
		});
		/* 삭제버튼 */
		$(".btn-danger").on("click", function() {
			formObj.attr("action", "/product/remove");
			formObj.submit();
		});

		getComments();

	});

	function checkImageType(fileName) {

		var pattern = /jpg|gif|png|jpeg/i;

		return img_name.match(pattern);

	}
</script>

<script>
	var pno = $("#pno").val(); // pno 변수에 서버에서 전달받은 값 할당 
	var id = $("#newUserNo").val(); // bId 변수에 서버에서 전달받은 값 할당 
	var name = $("#newUserName").val(); // bId 변수에 서버에서 전달받은 값 할당 

	$(".comentAddBtn").on("click", function() {

		var CommentsText = $("#newReplyText").val();

		// 댓글 입력처리 수행
		$.ajax({
			type : "post",
			url : "/comments/",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : "text",
			data : JSON.stringify({
				pno : pno,
				id : id,
				name : name,
				comments : CommentsText
			}),
			success : function(result) {
				if (result === "SUCCESS") {
					alert("댓글이 등록되었습니다.");
					$("#newReplyText").val(""); //댓글 입력창 공백처리
					getComments(); //댓글 목록 호출
				}
			}
		});

	});

	function deleteComments(commentNo) {

		$.ajax({
			type : 'delete',
			url : '/comments/' + commentNo,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("삭제 되었습니다.");
					getComments();
				}
			}
		});

	}

	function getComments() {
		$.getJSON("/comments/all/" + pno, function(data) {
			var str = "";

			$(data).each(
					function() {
						var strbutton = "";
						str += "<li class='list-group-item' data-commentNo='" + this.commentNo + "'>"
						
								+ "<i class='bi bi-star me-1 text-success'>" + this.name + "</i>"
								+ this.comments + "   "

						if (id == this.id)//댓글 정보와 로그인 정보 같을 경우 댓글 삭제 가능
						{
							strbutton += "<i class'bi bi-trash'>"
									+ "  <a href='#' onclick='deleteComments("
									+ this.commentNo + ")'>삭제</a>" + "</i>";
						}

						str += strbutton;
						str += "</li>";
					});

			$("#comments").html(str);

		});

	}
</script>

<!-- /.content -->


<%@include file="../include/startup_footer.jsp"%>