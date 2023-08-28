<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/startup_header.jsp" />


<main id="main" class="main">

    <div class="pagetitle">
      <h1>기업상세보기</h1>
    </div>
    <section class="section">
      <div class="row">
        <div class="col-lg-10">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">기업 정보 상세보기</h5>

              <!-- General Form Elements -->
              
              
<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='startupId' value="${startupVO.startupId}"> 
	<input type='hidden' name='page' value="${cri.page}">
	<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

</form>
             
              
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">기업명</label>
                  <div class="col-sm-10">
                    <input type="text" name='startupName' class="form-control"
                    value="${startupVO.startupName}" readonly="readonly">
                    
                  </div>
                </div>
                
                  <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">대표명</label>
                  <div class="col-sm-10">
                    <input type="text" name='names' class="form-control"
                    value="${startupVO.names}" readonly="readonly">
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputEmail" class="col-sm-2 col-form-label">기업 이메일</label>
                  <div class="col-sm-10">
                   <input type="text" name='startupId' class="form-control"
                   value="${startupVO.startupId}" readonly="readonly">
                  </div>
                </div>
               
                 <div class="row mb-3">
                  <label for="inputDate" class="col-sm-2 col-form-label">설립일</label>
                  <div class="col-sm-10">
                     <input type="date" name='establishedYear' class="form-control"
                     value="${startupVO.establishedYear}" readonly="readonly">
                  </div>
                </div>
                
                  <div class="row mb-3">
                  <label for="inputEmail" class="col-sm-2 col-form-label">규모</label>
                  <div class="col-sm-10">
                   <input type="text" name='sizes' class="form-control"
                   value="${startupVO.sizes}" readonly="readonly">
                  </div>
                </div>
           <!--      <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">규모</label>
                  <div class="col-sm-10">
                    <select class="form-select" aria-label="Default select example">
                      <option selected="">기업 규모 선택</option>
                      <option value="1">소기업</option>
                      <option value="2">중소기업</option>
                      <option value="3">중견기업</option>
                      <option value="4">대기업</option>
                    </select>
                  </div>
                </div> -->
               <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">업종</label>
                  <div class="col-sm-10">
                     <input type="text" name='categorys' class="form-control"
                     value="${startupVO.categorys}" readonly="readonly">
                  </div>
                </div>
                
                    <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">업태</label>
                  <div class="col-sm-10">
                   <input type="text" name='business' class="form-control"
                   value="${startupVO.business}" readonly="readonly">
                  </div>
                </div>
                
                    <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">직원수</label>
                  <div class="col-sm-10">
                    <input type="text" name='noOfEmployees' class="form-control"
                    value="${startupVO.noOfEmployees}" readonly="readonly">
                  </div>
                </div>
                
                    <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">주소</label>
                  <div class="col-sm-10">
                     <input type="text" name='city' class="form-control"
                     value="${startupVO.city}" readonly="readonly">
                  </div>
                </div>
                
                   <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">주력상품</label>
                  <div class="col-sm-10">
                    <input type="text" name='items' class="form-control"
                    value="${startupVO.items}" readonly="readonly">
                  </div>
                </div>
                
                   <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">이메일</label>
                  <div class="col-sm-10">
                    <input type="text" name='email' class="form-control"
                    value="${startupVO.email}" readonly="readonly">
                  </div>
                </div>
                
              <!--    <div class="row mb-3">
                  <label for="inputNumber" class="col-sm-2 col-form-label">사업자 등록증</label>
                  <div class="col-sm-10">
                    <input class="form-control" type="file" id="formFile">
                  </div>
                </div> -->
 

                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">수정하기</label>
                  <div class="col-sm-10">
                    <c:if test="${UserVO.usid eq login.usid}">
                    <button type="submit" class="btn btn-primary">수정</button>
                    <button type="submit" class="btn btn-danger">삭제</button>
                    </c:if>
                    <button type="submit" class="btn btn-primary">목록</button>
                    
                    
                    
              
               
               

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

		$(".btn-warning").on("click", function() {
			formObj.attr("action", "/startup/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-danger").on("click", function() {
			formObj.attr("action", "/startup/removePage");
			formObj.submit();
		});

		$(".btn-primary").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/startup/list");
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














<%@include file="../include/startup_footer.jsp"%>
