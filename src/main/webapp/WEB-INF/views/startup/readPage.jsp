<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="../include/startup_header.jsp" />


<main id="main" class="main">

<div class="pagetitle">
	<h1>스타트업상세보기</h1>
</div>
<section class="section">
	<div class="row">
		<div class="col-lg-12">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title"></h5>

					<!-- General Form Elements -->

					<form role="form" action="modifyPage" method="post">

						<input type='hidden' name='startupId' value="${startupVO.startupId}"
							id='startupId'> <input type='hidden' name='page'
							value="${cri.page}"> <input type='hidden'
							name='perPageNum' value="${cri.perPageNum}"> <input
							type='hidden' name='searchType' value="${cri.searchType}">
						<input type='hidden' name='keyword' value="${cri.keyword}">
					</form>


					<div
						class="alert alert-light border-light alert-dismissible fade show"
						role="alert">
						<h4 class="alert-heading">기업명 &nbsp;-&nbsp;${startupVO.startupName}</h4>
						<hr>
						<h4 class="alert-heading">스타트업 ID (Email) &nbsp;-&nbsp;${startupVO.startupId}</h4>
						<hr>
						
						<p>대표자명&nbsp;-&nbsp;${startupVO.names}</p>
						<p>설립일 &nbsp;-&nbsp;${startupVO.establishedYear}</p>
						<p>기업규모 &nbsp;-&nbsp;${startupVO.sizes}</p>
						<p>업종 &nbsp;-&nbsp;${startupVO.categorys}</p>
						<p>업태 &nbsp;-&nbsp;${startupVO.business}</p>
						<p>직원수 &nbsp;-&nbsp;${startupVO.noOfEmployees}</p>
						<p>주소 &nbsp;-&nbsp;${startupVO.city}</p>
						<p>주력상품 &nbsp;-&nbsp;${startupVO.items}</p>
						<p>등록일자 &nbsp;-&nbsp;${startupVO.regdate}</p>
						
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
			formObj.attr("action", "/startup/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		
		});


	});

	function checkImageType(fileName) {

		var pattern = /jpg|gif|png|jpeg/i;

		return img_name.match(pattern);

	}
</script>



<%@include file="../include/startup_footer.jsp"%>