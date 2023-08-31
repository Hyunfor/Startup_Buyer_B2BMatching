<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />
      
<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='startupId' value="${productVO.startupId}"> 
	<input type='hidden' name='pno' value="${productVO.pno}" id='pno'> 
	<input type='hidden' name='page' value="${cri.page}">
	<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

</form>  
             <section id="pricing" class="pricing">
      <div class="container aos-init aos-animate" data-aos="fade-up">

        <div class="section-title">
          <h2>product</h2>
          <h3>상품 정보 <span>상세</span></h3>
        </div>

        <div class="row">
          <div class="col-lg-20 col-md-12 mt-4 mt-md-0 aos-init aos-animate" data-aos="fade-up" data-aos-delay="200">
            <div class="box featured">
              <h3>상품 정보</h3>
              <h4><td>${productVO.startupId}</td></h4>
              <ul>
              	<li>상품번호 &nbsp;<td>${productVO.pno}</td></li>
              	<li>등록일 &nbsp;<td>${productVO.regdate}</td></li> 
                <li>상품명 &nbsp;<td>${productVO.pname}</td></li>
                <li>스타트업  &nbsp; <td>${productVO.startupId} </td></li>	
                <li>카테고리  &nbsp;<td>${productVO.category}</td></li>
                <li>상품  &nbsp;<td>${productVO.content}</td></li>
              </ul>
              
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
					<c:if test="${empty ProductIMGVO}">
					</c:if>
			</div>
			
			<div style="text-align: right;">
              
               <c:if test="${not empty login}">
				<div class="alert alert-light border-light alert-dismissible fade show" role="alert">
					<div class="portfolio-info">
							<h3>Comments</h3>
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
				</div>				

				 <div class="col-lg-12">
				 
				 <div style="text-align: right;">
				 <div class="alert alert-light border-light alert-dismissible fade show" role="alert">
					<div class="portfolio-info">
							<h3>댓글 목록</h3>
						<div class="card">
							<ul id="comments">
							</ul>
						</div>
						<div style="text-align: right;"></div>
					</div>
					</div>
				</div>
				</div>
				 <button type="submit" class="btn btn-outline-primary btn-rounded" >목록</button>
				</div>
            </div>
          </div>
        </div>
      
    </section>
             
              <!-- End General Form Elements -->

<script>
	var result = '${msg}';

	if(result != '' ) {
		alert(result);
	}

</script>

<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);


		$(".btn-outline-primary").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/productCommon/list");
			formObj.submit();
		});

	});
</script>


<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);
		
		//목록버튼
		$(".btn-dark").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/productCommon/list");
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


<%@include file="../include/footer.jsp"%>