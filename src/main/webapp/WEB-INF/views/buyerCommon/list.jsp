<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />


<main id="main"> <footer id='footer'>
	<div class="footer-newsletter">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6">
					<h4>바이어 검색</h4>
					<p>찾고 있는 바이어를 검색해보세요</p>
					<form>
						<div class="row">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" >
								<select name="searchType" class="form-control">
									<option value="none"
										<c:out value="${cri.searchType == null?'selected':''}"/>>
								---</option>
							<option value="n"
								<c:out value="${cri.searchType eq 'n'?'selected':''}"/>>
								바이어명</option>
							<option value="c"
								<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
								업종</option>
							<option value="i"
								<c:out value="${cri.searchType eq 'i'?'selected':''}"/>>
								주력상품</option>
							<option value="nc"
								<c:out value="${cri.searchType eq 'nc'?'selected':''}"/>>
								바이어명 or 업종</option>
							<option value="ci"
								<c:out value="${cri.searchType eq 'ci'?'selected':''}"/>>
								업종 or 주력상품</option>
							<option value="nci"
								<c:out value="${cri.searchType eq 'nci'?'selected':''}"/>>
								바이어명 or 업종 or 주력상품</option>

								</select>
							</div>
							<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
								<input type="email" id="keywordInput" value='${cri.keyword }'><input
									type="submit" id='searchBtn' value="검색">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</footer>

<section id="team" class="team section-bg">
	<div class="container aos-init aos-animate" data-aos="fade-up">

		<div class="section-title">
			<h2>바이어 정보</h2>
			<h3>
				바이어 둘러보기 <span>BizMatch Team</span>
			</h3>
			<p>현재 BizMatch와 함께하는 기업들 입니다.</p>
		</div>

		<div class="row">
			<c:forEach items="${list}" var="buyerVO" varStatus="var">
				<div
					class="col-lg-3 col-md-6 d-flex align-items-stretch aos-init aos-animate"
					data-aos="fade-up" data-aos-delay="100">
					<div class="member">
						<div class="member-img">
							<img
								src="https://bootstrapmade.com/demo/templates/BizLand/assets/img/team/team-3.jpg"
								class="img-fluid">
							<div class="social">
								<a
									href="/buyerCommon/read${pageMaker.makeSearch(pageMaker.cri.page)}&buyerId=${buyerVO.buyerId}"><i
									class="bi bi-zoom-in"></i></a>
							</div>
						</div>
						<div class="member-info">
							<h4 class="title">${buyerVO.buyerName}</h4>
							<span>업종 &nbsp;	${buyerVO.category} </span> 
							<span>업태 &nbsp;	${buyerVO.business} </span> 
							<span>주소 &nbsp; ${buyerVO.country} </span>
							<span>주력상품 &nbsp; ${buyerVO.items} </span>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>


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

</section>






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

			});
</script> </main>




<%@include file="../include/footer.jsp"%>