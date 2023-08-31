<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="../include/startup_header.jsp" />


<main id="main" class="main">

<div class="pagetitle">
	<h1>기업 수정</h1>
</div>
<section class="section">
	<div class="row">
		<div class="col-lg-12">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title">기업 정보 수정</h5>

					<!-- General Form Elements -->

					<form role="form" action="modifyPage" method="post" name="frm">

						<input type='hidden' name='startupId' value="${startupVO.startupId}">
						<input type='hidden' name='page' value="${cri.page}"> <input
							type='hidden' name='perPageNum' value="${cri.perPageNum}">
						<input type='hidden' name='searchType' value="${cri.searchType}">
						<input type='hidden' name='keyword' value="${cri.keyword}">



						<div class="row mb-3">
							<label for="startupName" class="col-form-label">기업명<span
								class="must-mark">*</span></label> <input type="text"
								class="form-control" name="startupName" id="startupName"
								value="${startupVO.startupName}" disabled="disabled">
						</div>

						<div class="row mb-3">
							<label for="startupId" class="col-form-label">스타트업 ID (Email)<span
								class="must-mark">*</span></label> <input type="text"
								class="form-control" name="startupId" id="startupId"
								value="${startupVO.startupId}" disabled="disabled">
						</div>

						<div class="row mb-3">
							<label for="names">대표자명<span class="must-mark">*</span></label> <input
								class="form-control" type="text" name="names"
								value="${startupVO.names}" id="names">
						</div>

						<div class="row mb-3">
							<label for="establishedYear">설립일<span class="must-mark">*</span></label>
							<input class="form-control" type="text" name="establishedYear"
								value="${startupVO.establishedYear}" id="establishedYear">
						</div>

						<div class="row mb-3">
							<label for="sizes">기업규모<span class="must-mark">*</span></label>
							<input class="form-control" type="text" name="sizes"
								value="${startupVO.sizes}" id="sizes">
						</div>

						<div class="row mb-3">
							<label for="categorys">업종<span class="must-mark">*</span></label> <input
								class="form-control" type="text" name="categorys"
								value="${startupVO.categorys}" id="categorys">
						</div>

						<div class="row mb-3">
							<label for="categorys">업태<span class="must-mark">*</span></label>
							<input class="form-control" type="text" name="business"
								value="${startupVO.business}" id="business">
						</div>
						
							<div class="row mb-3">
							<label for="noOfEmployees">직원수<span class="must-mark">*</span></label>
							<input class="form-control" type="text" name="noOfEmployees"
								value="${startupVO.noOfEmployees}" id="noOfEmployees">
						</div>
						
							<div class="row mb-3">
							<label for="city">주소<span class="must-mark">*</span></label>
							<input class="form-control" type="text" name="city"
								value="${startupVO.city}" id="city">
						</div>
						
							<div class="row mb-3">
							<label for="items">주력상품<span class="must-mark">*</span></label>
							<input class="form-control" type="text" name="items"
								value="${startupVO.items}" id="items">
						</div>
						
				

						<div class="text-center">
							<button type="submit" class="btn btn-primary">수정</button>
							<a class="btn btn-secondary"
								href="/satrtup/readPage?searchType=${cri.searchType}&keyword=${cri.keyword}&page=${cri.page}&perPageNum=${cri.perPageNum}">취소</a>
						</div>

					</form>


				</div>
			</div>
		</div>
	</div>
</section>

</main>


<%@include file="../include/startup_footer.jsp"%>