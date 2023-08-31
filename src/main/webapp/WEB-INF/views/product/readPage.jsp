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
		<div class="col-lg-10">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title">상품 정보 상세보기</h5>

					<!-- General Form Elements -->

					<form role="form" action="modifyPage" method="post">

						<input type='hidden' name='pno' value="${productVO.pno}" id='pno'>
						<input type='hidden' name='page' value="${cri.page}"> <input
							type='hidden' name='perPageNum' value="${cri.perPageNum}">
						<input type='hidden' name='searchType' value="${cri.searchType}">
						<input type='hidden' name='keyword' value="${cri.keyword}">

					</form>

					<div class="row mb-3">
						<label for="inputAddress2" class="col-form-label">상품명<span
							class="must-mark">*</span></label>
						<div class="col-sm-10">
							<input type="text" name="pname" id="pname"
								value="${productVO.pname}" class="form-control"
								disabled="disabled">
						</div>
					</div>

					<div class="row mb-3">
						<label for="inputEmail4" class="col-form-label">스타트업</label>
						<div class="col-sm-10">
							<input type="text" name="startupId" id="startupId"
								value="${productVO.startupId}" class="form-control"
								disabled="disabled">
						</div>
					</div>

					<div class="row mb-3">
						<label for="category" class="col-form-label">카테고리</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="category"
								id="category" value="${productVO.category}" disabled="disabled" />
						</div>
					</div>

					<div class="row mb-3">
						<label for="inputAddress2" class="col-form-label">상세내용</label>
						<div class="col-sm-10">
							<textarea class="form-control" name="content" id="content"
								rows="15" disabled="disabled">${productVO.content}</textarea>
						</div>
					</div>

					<c:if test="${!empty ProductIMGVO}">
						<div class="form-group">
							<label for="exampleInputEmail1" class="col-form-label">첨부파일</label>
						</div>

						<ul class="dropzone-previews">

							<c:forEach items="${ProductIMGVO}" var="ProductIMGVO"
								varStatus="status">
								<c:set var="imgNamee" value="${ProductIMGVO.imgName}" />
								<c:set var="pimageNo" value="${fn:toLowerCase(imgName)}" />

								<li class="dropzone-previews mt-3">
									<div
										class="card mt-1 mb-0 shadow-none border dz-processing dz-image-preview dz-success dz-complete">
										<div class="p-2">
											<div class="row align-items-center">
												<c:forTokens var="token" items="${pimageNo}" delims="."
													varStatus="status">
													<c:if test="${status.last}">
														<c:choose>
															<c:when test="${token eq 'hwp'}">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light"
																	src="/resources/dist/img/hwp.png" alt="${imgName}" />
															</c:when>
															<c:when test="${token eq 'xls' || token eq 'xlsx' }">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light"
																	src="/resources/dist/img/excelIcon.png" />
															</c:when>
															<c:when
																test="${token eq 'jpg' || token eq 'gif' || token eq 'png' || token eq 'bmp' }">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light"
																	src="/displayFile?fileName=${ProductIMGVO.fileLocation}">
															</c:when>
															<c:when test="${token eq 'pdf'}">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light"
																	src="/resources/dist/img/pdf.png" alt="${imgName}" />
															</c:when>
															<c:when test="${token eq 'ppt' }">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light"
																	src="/resources/dist/img/ppt.png" alt="${imgName}" />
															</c:when>
															<c:otherwise>
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light"
																	src="/resources/dist/img/file.svg" alt="${imgName}" />
															</c:otherwise>
														</c:choose>
													</c:if>
												</c:forTokens>

												<div class="col pl-0">
													<img alt="${ProductIMGVO.imgName}"
														src="/displayFile?fileName=${ProductIMGVO.fileLocation}">
												</div>
												<div class="col pl-0">
													<a
														href="/displayFile?fileName=${ProductIMGVO.fileLocation}"
														text-muted font-weight-bold data-dz-name="">
														${ProductIMGVO.imgName}</a>
												</div>
											</div>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					<c:if test="${empty ProductIMGVO}">
					</c:if>
					<br> <br>
					<div style="text-align: right;">

						<div class="row mb-3">
							<div class="col-sm-10"> 
							<!--
								<c:if test="${StartUpUserVO.sId eq login.sId}">
									<button type="submit" class="btn btn-dark">목록</button>
									<button type="submit" class="btn btn-danger">삭제</button>
									<button type="submit" class="btn btn-primary">수정</button>
								</c:if>
							-->		
							
									<button type="submit" class="btn btn-dark">목록</button>
									<button type="submit" class="btn btn-danger">삭제</button>
									<button type="submit" class="btn btn-primary">수정</button>
									
								<!-- End General Form Elements -->
							</div>
						</div>

					</div>

				</div>

				<!-- 댓글창 -->


				<c:if test="${not empty login}">

					<div class="card">
						<div class="card-body">
							<h4 class="mt-0 mb-3">Comments</h4>
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

								<textarea class="form-control form-control-light mb-2"
									placeholder="Write message" id="newReplyText" rows="3"></textarea>
								<div class="text-right">
									<div class="btn-group mb-2">
										<button type="button"
											class="btn btn-link btn-sm text-muted font-18"></button>
									</div>
									<div class="btn-group mb-2 ml-2">
										<a class="btn btn-outline-primary btn-rounded comentAddBtn"
											style="font-weight: bold;">댓글 등록</a>
									</div>
								</div>
							</form>
						</div>
					</div>
				</c:if>


				<div class="col-lg-12">
					<div class="inbox-widget">
						<h5 class="mt-0">댓글 목록</h5>
						<div class="card">
							<ul id="comments">
							</ul>
						</div>
						<div style="text-align: right;"></div>
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
			formObj.attr("action", "/product/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});
		//목록버튼
		$(".btn-dark").on("click", function() {
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
					$("#newCommentsText").val(""); //댓글 입력창 공백처리
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
						str += "<li data-commentNo='" + this.commentNo + ">"
								+ "<div class='card'>" + this.name + "<br>"
								+ this.comments + "<br>"

						if (id == this.id)//댓글 정보와 로그인 정보 같을 경우 댓글 삭제 가능
						{
							strbutton += "<div class='card'>"
									+ "  <a href='#' onclick='deleteComments("
									+ this.commentNo + ")'>삭제</a>" + "</div>";
						}

						str += strbutton;
						str += "</div></li>";
					});

			$("#comments").html(str);

		});

	}
</script>

<!-- /.content -->


<%@include file="../include/startup_footer.jsp"%>
