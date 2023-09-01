<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />


              
              
<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='buyerId' value="${buyerVO.buyerId}"> 
	<input type='hidden' name='page' value="${cri.page}">
	<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

</form>
             
             
             
             
             
             <section id="pricing" class="pricing">
      <div class="container aos-init aos-animate" data-aos="fade-up">

        <div class="section-title">
          <h2>buyers</h2>
          <h3>바이어 정보 <span>상세</span></h3>
        </div>

        <div class="row">

       

          <div class="col-lg-20 col-md-12 mt-4 mt-md-0 aos-init aos-animate" data-aos="fade-up" data-aos-delay="200">
            <div class="box featured">
              <h3>바이어 정보</h3>
              <h4><td>${buyerVO.buyerName}</td></h4>
              <ul>
                <li>기업명 &nbsp;<td>${buyerVO.buyerName}</td></li>
                <li>바이어 이메일  &nbsp; <td>${buyerVO.email} </td></li>	
                <li>국가  &nbsp;<td>${buyerVO.country}</td></li>
                <li>업종  &nbsp;<td>${buyerVO.category}</td></li>
                <li>업태  &nbsp;<td>${buyerVO.business}</td></li>
                <li>주력상품  &nbsp;<td>${buyerVO.items}</td></li>
                <li>잠재주문량 &nbsp;<td>${buyerVO.orderAmount}</td></li>
                
               
              </ul>
              <div class="btn-wrap">
            
                  <button type="submit" class="btn-buy">목록</button>
            
              </div>
            </div>
          </div>

      

        </div>

      </div>
    </section>
             
             
             
             
             
             
              
              
 
               
               

              <!-- End General Form Elements -->

<script>
	var result = '${msg}';

	if(result != '' ) {
		alert(result);
	}

</script>

<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);


		$(".btn-buy").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/buyerCommon/list");
			formObj.submit();
		});

	});
</script>







            
         
        

       
         
 

















<%@include file="../include/footer.jsp"%>