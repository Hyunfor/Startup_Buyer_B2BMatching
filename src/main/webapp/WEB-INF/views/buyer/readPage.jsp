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

						<input type='hidden' name='pno' value="${buyerVO.buyerId}"
							id='buyerId'> <input type='hidden' name='page'
							value="${cri.page}"> <input type='hidden'
							name='perPageNum' value="${cri.perPageNum}"> <input
							type='hidden' name='searchType' value="${cri.searchType}">
						<input type='hidden' name='keyword' value="${cri.keyword}">
					</form>


					<div
						class="alert alert-light border-light alert-dismissible fade show"
						role="alert">
						<h4 class="alert-heading">기업명 &nbsp;-&nbsp;${buyerVO.buyerName}</h4>
						<hr>
						<h4 class="alert-heading">바이어 ID (Email) &nbsp;-&nbsp;${buyerVO.email}</h4>
						<hr>
						<p>국가 &nbsp;-&nbsp;${buyerVO.country}</p>
						<p>업종 &nbsp;-&nbsp;${buyerVO.category}</p>
						<p>업태 &nbsp;-&nbsp;${buyerVO.business}</p>
						<p>주력상품 &nbsp;-&nbsp;${buyerVO.items}</p>
						<p>잠재주문량 &nbsp;-&nbsp;${buyerVO.orderAmount}</p>
						<p>등록일자 &nbsp;-&nbsp;${buyerVO.regdate}</p>
						
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


	});

	function checkImageType(fileName) {

		var pattern = /jpg|gif|png|jpeg/i;

		return img_name.match(pattern);

	}
</script>



<%@include file="../include/buyer_footer.jsp"%>