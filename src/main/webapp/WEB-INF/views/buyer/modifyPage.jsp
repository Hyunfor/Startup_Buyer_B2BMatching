<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="../include/buyer_header.jsp" />


<main id="main" class="main">

<div class="pagetitle">
	<h1>바이어 수정</h1>
</div>
<section class="section">
	<div class="row">
		<div class="col-lg-12">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title">바이어 정보 수정</h5>

					<!-- General Form Elements -->

					<form role="form" action="modifyPage" method="post" name="frm">

						<input type='hidden' name='buyerId' value="${buyerVO.buyerId}">
						<input type='hidden' name='page' value="${cri.page}"> <input
							type='hidden' name='perPageNum' value="${cri.perPageNum}">
						<input type='hidden' name='searchType' value="${cri.searchType}">
						<input type='hidden' name='keyword' value="${cri.keyword}">



						<div class="row mb-3">
							<label for="buyerName" class="col-form-label">기업명<span
								class="must-mark">*</span></label> <input type="text"
								class="form-control" name="buyerName" id="buyerName"
								value="${buyerVO.buyerName}" disabled="disabled">
						</div>

						<div class="row mb-3">
							<label for="email" class="col-form-label">바이어 ID (Email)<span
								class="must-mark">*</span></label> <input type="text"
								class="form-control" name="email" id="email"
								value="${buyerVO.email}" disabled="disabled">
						</div>

						<div class="row mb-3">
							<label for="country">국가<span class="must-mark">*</span></label> <input
								class="form-control" type="text" name="country"
								value="${buyerVO.country}" id="country">
						</div>

						<div class="row mb-3">
							<label for="category">업종<span class="must-mark">*</span></label>
							<input class="form-control" type="text" name="category"
								value="${buyerVO.category}" id="category">
						</div>

						<div class="row mb-3">
							<label for="business">업태<span class="must-mark">*</span></label>
							<input class="form-control" type="text" name="business"
								value="${buyerVO.business}" id="business">
						</div>

						<div class="row mb-3">
							<label for="items">주력상품<span class="must-mark">*</span></label> <input
								class="form-control" type="text" name="items"
								value="${buyerVO.items}" id="items">
						</div>

						<div class="row mb-3">
							<label for="orderAmount">잠재주문량<span class="must-mark">*</span></label>
							<input class="form-control" type="text" name="orderAmount"
								value="${buyerVO.orderAmount}" id="orderAmount">
						</div>


						<div class="text-center">
							<button type="submit" class="btn btn-primary">수정</button>
							<a class="btn btn-secondary"
								href="/buyer/readPage?searchType=${cri.searchType}&keyword=${cri.keyword}&page=${cri.page}&perPageNum=${cri.perPageNum}">취소</a>
						</div>

					</form>


				</div>
			</div>
		</div>
	</div>
</section>

</main>


<%@include file="../include/buyer_footer.jsp"%>