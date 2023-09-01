<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/startup_header.jsp" />

<main id="main" class="main">

<div class="pagetitle">
	<h1>스타트업 매칭</h1>

</div>
<!-- End Page Title -->

<section class="section">
	<div class="row">
		<div class="col-md-12">

			<div class="card">
				<div class="card-body">

					<div class="datatable-search">


						<button id='searchBtn' class="btn btn-dark">매칭</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="card">
		<div class="card-body">
			<h5 class="card-title">바이어</h5>

			<!-- Primary Color Bordered Table -->
			<table class="table table-bordered border-primary">
				<thead>
					<tr>

						<th style="width: 10px">NO</th>
						<th>바이어명</th>
						<th>바이어 이메일</th>
						<th>국가</th>
						<th>업종</th>
						<th>업태</th>
						<th>주력상품</th>
						<th>잠재주문량</th>
						<th>등록일자</th>
						<th></th>

					</tr>
				</thead>
				<tbody>

				</tbody>


				<tr>
					<td>1</td>
					<td><a
						href='/startup/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&startupId=1'>
							Rodney Rogers</a></td>
					<td>rodney@gma.com</td>
					<td>미국</td>
					<td>경영 컨설팅업</td>
					<td>서비스업</td>
					<td>매니지먼트 서비스</td>
					<td>5000</td>
					<td>23-08-12</td>
					<td><input type="checkbox"></td>
				</tr>

				<tr>
					<td>2</td>
					<td><a
						href='/startup/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&startupId=1'>
							Michael Yong</a></td>
					<td>michael@gma.com</td>
					<td>호주</td>
					<td>의약품</td>
					<td>제조업</td>
					<td>일반의약품</td>
					<td>8000</td>
					<td>23-08-30</td>
					<td><input type="checkbox"></td>
				</tr>

				<tr>
					<td>3</td>
					<td><a
						href='/startup/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&startupId=1'>
							Eddy Man</a></td>
					<td>eddy@gma.com</td>
					<td>인도네시아</td>
					<td>석탄 광업</td>
					<td>광업</td>
					<td>석회암</td>
					<td>3000</td>
					<td>23-08-23</td>
					<td><input type="checkbox"></td>
				</tr>

				<tr>
					<td>4</td>
					<td><a
						href='/startup/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&startupId=1'>
							Ben Paul</a></td>
					<td>ben@gma.com</td>
					<td>독일</td>
					<td>아파트 건설업</td>
					<td>건설업</td>
					<td>아파트</td>
					<td>15000</td>
					<td>23-08-18</td>
					<td><input type="checkbox"></td>
				</tr>


			</table>
			<!-- End Primary Color Bordered Table -->

		</div>
	</div>

	<div class="card">
		<div class="card-body">

			<div class="row justify-content-center">
				<ul class="pagination justify-content-center">

					<c:if test="${pageMaker.prev}">
						<li><a class="page-link"
							href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a>
						</li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">

						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a class="page-link"
							href="list${pageMaker.makeSearch(idx)}">${idx}</a>

						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
					</c:if>

				</ul>
			</div>

		</div>
	</div>
</main>
</section>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<script>
	$(document).ready(
			function() {

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {

					self.location = "register";

				});

			});
</script>

<%@include file="../include/startup_footer.jsp"%>
