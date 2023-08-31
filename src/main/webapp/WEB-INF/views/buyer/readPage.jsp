<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="../include/buyer_header.jsp" />


<main id="main" class="main">

<div class="pagetitle">
	<h1>바이어상세보기</h1>
</div>
<section class="section">
	<div class="row">
		<div class="col-lg-12">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title"></h5>

					<!-- General Form Elements -->

					<form role="form" action="modifyPage" method="post">

						<input type='hidden' name='pno' value="${buyerVO.buyerId}" id='buyerId'>
						<input type='hidden' name='page' value="${cri.page}"> <input
							type='hidden' name='perPageNum' value="${cri.perPageNum}">
						<input type='hidden' name='searchType' value="${cri.searchType}">
						<input type='hidden' name='keyword' value="${cri.keyword}">

					</form>

			<div class="alert alert-light border-light alert-dismissible fade show" role="alert">
                <h4 class="alert-heading">${buyerVO.buyerName}</h4>
                <hr>
                <h4 class="alert-heading">${buyerVO.email}</h4>
                <hr>
                <p>${buyerVO.country}</p>
                <p>${buyerVO.category}</p>
                <p>${buyerVO.business}</p>
                <p>${buyerVO.items}</p>
                <p>${buyerVO.orderAmount}</p>
              </div>
              
              
           
			
</div>

						<div class="row mb-3">
							<div class="text-center"> 
									<button type="submit" class="btn btn-primary">수정</button>
						</div>
					</div>	
				

				<!-- end card-body-->

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
			formObj.attr("action", "/buyer/modifyPage");
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