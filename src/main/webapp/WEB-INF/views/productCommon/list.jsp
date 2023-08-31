<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />

<main id="main" class="main">

<div class="pagetitle">
	<h1>상품관리</h1>

</div>
<!-- End Page Title -->

<section class="section">
	<div class="row">
		<div class="col-md-12">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title">상품 관리</h5>

					<div class="datatable-search">

						<select name="searchType">
							<option value="none"
								<c:out value="${cri.searchType == null?'selected':''}"/>>
								---</option>
							<option value="n"
								<c:out value="${cri.searchType eq 'n'?'selected':''}"/>>
								상품명</option>
							<option value="c"
								<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
								카테고리</option>
							<option value="w"
								<c:out value="${cri.searchType eq 's'?'selected':''}"/>>
								스타트업</option>
							<option value="nc"
								<c:out value="${cri.searchType eq 'nc'?'selected':''}"/>>
								상품명 OR 내용</option>
							<option value="cw"
								<c:out value="${cri.searchType eq 'cs'?'selected':''}"/>>
								카테고리 OR 스타트업</option>
							<option value="ncw"
								<c:out value="${cri.searchType eq 'ncs'?'selected':''}"/>>
								제품명 OR 카테고리 OR 스타트업</option>

						</select> <input class="datatable-input" placeholder="Search..."
							type="text" name='keyword' id="keywordInput"
							value='${cri.keyword }' title="Search within table">
						<!-- <button id='searchBtn' class="btn btn-dark">검색</button>
       
        <button type = "button" id='newBtn' class="btn btn-primary">기업등록</button>
         -->
						<button id='searchBtn' class="btn btn-dark">검색</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="card">
		<div class="card-body">
			<h5 class="card-title">상품 목록</h5>
			<p>
				Add
				<code>.table-bordered</code>
				for borders on all sides of the table and cells.
			</p>

			<p>
				<a
					href="https://getbootstrap.com/docs/5.0/utilities/borders/#border-color"
					target="_blank">Border color utilities</a> can be added to change
				colors:
			</p>

			<!-- Primary Color Bordered Table -->
			<table class="table table-bordered border-primary">
				<thead>
					<tr>

						<th style="width: 10px">NO</th>
						<th>상품명</th>
						<th>카테고리</th>
						<th>내용</th>
						<th>스타트업</th>
						<th>등록일</th>

					</tr>
				</thead>
				<tbody>

				</tbody>

				<c:forEach items="${list}" var="productVO" varStatus="var">

					<tr>
						<c:if test="${pageMaker.cri.page == 1 }">
							<td>${var.count }</td>
						</c:if>
						<c:if test="${pageMaker.cri.page != 1 }">
							<td>${var.count + ((pageMaker.cri.page-1)*10) }</td>
						</c:if>
						<td><a
							href='/productCommon/read${pageMaker.makeSearch(pageMaker.cri.page) }&pno=${productVO.pno}'>
								${productVO.pname} </a></td>
						<td>${productVO.category}</td>
						<td>${productVO.content}</td>
						<td>${productVO.startupId}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${productVO.regdate}" /></td>
					</tr>

				</c:forEach>


			</table>
			<!-- End Primary Color Bordered Table -->

		</div>
	</div>

	<div class="card">
		<div class="card-body">

			<div class="text-center">
				<ul class="pagination">

					<c:if test="${pageMaker.prev}">
						<li><a class="page-link"
							href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a>
						</li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">

						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a class="page-link" href="list${pageMaker.makeSearch(idx)}">${idx}</a>

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

<%@include file="../include/footer.jsp"%>