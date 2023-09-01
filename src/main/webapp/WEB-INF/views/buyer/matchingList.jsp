<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/buyer_header.jsp" />

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
			<h5 class="card-title">스타트업</h5>

			<!-- Primary Color Bordered Table -->
			<table class="table table-bordered border-primary">
				<thead>
					<tr>

						<th style="width: 10px">NO</th>
						<th>기업 이메일</th>
                    <th>기업명</th>
                    <th>설립일</th>
                    <th>규모</th>
                    <th>업종</th>
                    <th>업태</th>
                    <th>직원 수</th>
                    <th>주소</th>
                    <th>주력상품</th>
                    <th>대표자 명</th>
                    <th>등록일자</th>
                    <th></th>

					</tr>
				</thead>
				<tbody>

				</tbody>

				 
								<tr>
								<td>1</td>
								<td><a href='/startup/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&startupId=1'>
									angel@gma.com</a></td>		
								<td>엔젤로보틱스</td> 			 
								<td>17-02-05</td>
								<td>중소기업</td>
								<td>제조</td>
								<td>의료</td>
								<td>150명</td>
								<td>서울</td>				
								<td>엔젤슈트</td>
								<td>공경철</td>
								<td>23-09-01</td>
								<td><input type="checkbox"></td>
								</tr>

								<tr>
								<td>2</td>
								<td><a href='/startup/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&startupId=1'>
									bear@gma.com</a></td>		
								<td>베어로보틱스</td> 			 
								<td>17-05-05</td>
								<td>중소기업</td>
								<td>제조</td>
								<td>외식</td>
								<td>100명</td>
								<td>서울</td>				
								<td>서비(서빙 로봇)</td>
								<td>김준수</td>
								<td>23-08-31</td>
								<td><input type="checkbox"></td>
								</tr>
								
								<tr>
								<td>3</td>
								<td><a href='/startup/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&startupId=1'>
									breezy@gma.com</a></td>		
								<td>브리지테일</td> 			 
								<td>17-04-19</td>
								<td>중소기업</td>
								<td>제조</td>
								<td>반려동물</td>
								<td>53명</td>
								<td>서울</td>				
								<td>반려동물 케어제품</td>
								<td>강창우</td>
								<td>23-08-25</td>
								<td><input type="checkbox"></td>
								</tr>
								
								<tr>
								<td>4</td>
								<td><a href='/startup/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&startupId=1'>
									monster@gma.com</a></td>		
								<td>몬스터스튜디오</td> 			 
								<td>16-07-06</td>
								<td>중소기업</td>
								<td>제조</td>
								<td>콘텐츠</td>
								<td>37명</td>
								<td>광주</td>				
								<td>애니메이션 영상</td>
								<td>정지환</td>
								<td>23-08-22</td>
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
							href="matchingList${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a>
						</li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">

						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a class="page-link" href="matchingList${pageMaker.makeSearch(idx)}">${idx}</a>

						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="matchingList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
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

<%@include file="../include/buyer_footer.jsp"%>
