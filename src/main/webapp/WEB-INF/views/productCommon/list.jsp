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
					<h4>상품 검색</h4>
					<p>찾고 있는 상품을 검색해보세요</p>
					<form>
						<div class="row">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" >
								<select name="searchType" class="form-control">
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
			<h2>상품 정보</h2>
			<h3>
				상품 둘러보기 <span>BizMatch Items</span>
			</h3>
			<p>현재 BizMatch에 등록된 상품들 입니다.</p>
		</div>

		<div class="row">
			<c:forEach items="${list}" var="productVO" varStatus="var">
				<div class="col-lg-3 col-md-6 d-flex align-items-stretch aos-init aos-animate" data-aos="fade-up" data-aos-delay="100">
					<div class="member">
						<div class="member-img">
           				<c:if test="${!empty productVO.fileList}">     
                    			<img class="img-fluid" src="/displayFile?fileName=${productVO.fileList[0].fileLocation}" alt="${productVO.fileList[0].imgName}">
                		</c:if>
                		
						<c:if test="${empty productVO.fileList}">
							<img src="https://bootstrapmade.com/demo/templates/BizLand/assets/img/team/team-3.jpg" class="img-fluid">
						</c:if>
					<div class="social">
								<a href='/productCommon/read${pageMaker.makeSearch(pageMaker.cri.page) }&pno=${productVO.pno}'><i
									class="bi bi-zoom-in"></i></a>
							</div>
						</div>
						<div class="member-info">
							<h4 class="title">${productVO.pname}</h4>
							<span>카테고리 &nbsp;	${productVO.category} </span> 
							<span>내용 &nbsp;	${productVO.content} </span> 
							<span>스타트업 &nbsp; ${productVO.startupId} </span>
							<span>등록일 &nbsp; ${productVO.regdate} </span>
						</div>
					</div>
					</div>
			</c:forEach>
		</div>
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