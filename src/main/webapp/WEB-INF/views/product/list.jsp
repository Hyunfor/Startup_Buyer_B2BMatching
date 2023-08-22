<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->


		<div class="col-md-12">
			<!-- general form elements -->
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title">제품 관리</h3>
				</div>


				<div class='box-body'>

					<select name="searchType">
						<option value="none"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="n"
							<c:out value="${cri.searchType eq 'n'?'selected':''}"/>>
							제품명</option>
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							내용</option>
						<option value="w"
							<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
							작성자</option>
						<option value="nc"
							<c:out value="${cri.searchType eq 'nc'?'selected':''}"/>>
							제품명 OR 내용</option>
						<option value="cw"
							<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
							내용 OR 작성자</option>
						<option value="ncw"
							<c:out value="${cri.searchType eq 'ncw'?'selected':''}"/>>
							제품명 OR 내용 OR 작성자</option>
					</select> <input type="text" name='keyword' id="keywordInput"
						value='${cri.keyword }'>
					<button id='searchBtn'>검색</button>
					<button id='newBtn'>제품 등록</button>

				</div>
			</div>


			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">제품 목록</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
						    <th style="width: 10px">NO</th>
							<th>제품명</th>
							<th>가격</th>
							<th>작성자</th>
							<th>등록일</th>
							<th style="width: 60px">조회수</th>
						</tr>

						<c:forEach items="${list}" var="productVO" varStatus="var">

							<tr>
								<c:if test="${pageMaker.cri.page == 1 }">
								<td>${var.count }</td>
								</c:if>
								<c:if test="${pageMaker.cri.page != 1 }">
								<td>${var.count + ((pageMaker.cri.page-1)*10) }</td>
								</c:if>
								<td><a
									href='/product/readPage${pageMaker.makeSearch(pageMaker.cri.page) }&pno=${productVO.pno}'>
										${productVO.pname} </a></td>
										<td>${productVO.price}</td>
								<td>${productVO.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${productVO.regdate}" /></td>
								<td><span class="badge bg-red">${productVO.viewcnt }</span></td>
							</tr>

						</c:forEach>

					</table>
				</div>
				<!-- /.box-body -->


				<div class="box-footer">

					<div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>

						</ul>
					</div>

				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->


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
