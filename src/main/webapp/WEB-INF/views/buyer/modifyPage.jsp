<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/buyer_header.jsp" />


<main id="main" class="main">

    <div class="pagetitle">
      <h1>기업수정</h1>
    </div>
    <section class="section">
      <div class="row">
        <div class="col-lg-10">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">기업 정보 수정</h5>

              <!-- General Form Elements -->
              
              
<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='buyerId' value="${buyerVO.buyerId}"> 
	<input type='hidden' name='page' value="${cri.page}">
	<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">
              
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">바이어명</label>
                  <div class="col-sm-10">
                    <input type="text" name='buyerName' class="form-control"  value="${buyerVO.buyerName}"  readonly="readonly">
                  </div>
                </div>                               
                
                <div class="row mb-3">
                  <label for="inputEmail" class="col-sm-2 col-form-label">바이어 이메일</label>
                  <div class="col-sm-10">
                   <input type="text" name='email' class="form-control"
                   value="${buyerVO.email}"  readonly="readonly">
                  </div>
                </div>
               
                 <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">국가</label>
                  <div class="col-sm-10">
                     <input type="text" name='country' class="form-control"
                     value="${buyerVO.country}" >
                  </div>
                </div>
                
                  <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">업종</label>
                  <div class="col-sm-10">
                   <input type="text" name='category' class="form-control"
                   value="${buyerVO.category}" >
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">업태</label>
                  <div class="col-sm-10">
                   <input type="text" name='business' class="form-control"
                   value="${buyerVO.business}" >
                  </div>
                </div>
                
                   <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">주력상품</label>
                  <div class="col-sm-10">
                    <input type="text" name='items' class="form-control"
                    value="${buyerVO.items}">
                  </div>
                </div>
                
                   <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">잠재주문량</label>
                  <div class="col-sm-10">
                    <input type="text" name='orderAmount' class="form-control"
                    value="${buyerVO.orderAmount}">
                  </div>
                </div>

                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">등록하기</label>
                  <div class="col-sm-10">
                    <button type="submit" class="btn btn-warning">등록</button>
                    <button type="submit" class="btn btn-primary">목록</button>
                  </div>
                </div>
               
</form>
<script>
$(document).ready(
	function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-primary")
				.on("click",function() {
					self.location = "/buyer/adminList?page=${cri.page}&perPageNum=${cri.perPageNum}"
							+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
				});

		$(".btn-warning").on("click",
				function() {
					formObj.submit();
				});
	});
</script>




            </div>
          </div>

        </div>

       
            </div>
       
    </section>





</main>














<%@include file="../include/buyer_footer.jsp"%>
