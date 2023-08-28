<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/startup_header.jsp" />

<main id="main" class="main">

    <div class="pagetitle">
      <h1>기업관리</h1>
      
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-md-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">기업관리</h5>
             
        
              
    
        
       <div class="datatable-search">
    
       <select name="searchType">
						<option value="none"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="n"
							<c:out value="${cri.searchType eq 'n'?'selected':''}"/>>
							기업명</option>
						<option value="s"
							<c:out value="${cri.searchType eq 's'?'selected':''}"/>>
							기업규모</option>
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							주소</option>
							<option value="i"
							<c:out value="${cri.searchType eq 'i'?'selected':''}"/>>
							주력상품</option>
						
					</select> 
						
		<input class="datatable-input" placeholder="Search..." type="text" name='keyword' id="keywordInput"
						value='${cri.keyword }' title="Search within table">
       	<!-- <button id='searchBtn' class="btn btn-dark">검색</button>
       
        <button type = "button" id='newBtn' class="btn btn-primary">기업등록</button>
         -->
        <button id='searchBtn' class="btn btn-dark">검색</button>
		<button id='newBtn' class="btn btn-primary">기업 등록</button>
       </div>
       </div>
        </div>
        </div>
         </div>
         
         
         
         <div class="card">
            <div class="card-body">
              <h5 class="card-title">기업정보 테이블</h5>
              <p>Add <code>.table-bordered</code> for borders on all sides of the table and cells.</p>
 

              <p><a href="https://getbootstrap.com/docs/5.0/utilities/borders/#border-color" target="_blank">Border color utilities</a> can be added to change colors:</p>

              <!-- Primary Color Bordered Table -->
              <table class="table table-bordered border-primary">
                <thead>
                  <tr>
                    
                    <th scope="col">no</th>
                    <th scope="col">기업 이메일</th>
                    <th scope="col">기업명</th>
                    <th scope="col">설립일</th>
                    <th scope="col">규모</th>
                    <th scope="col">업종</th>
                    <th scope="col">업태</th>
                    <th scope="col">직원 수</th>
                    <th scope="col">주소</th>
                    <th scope="col">주력상품</th>
                    <th scope="col">이메일</th>
                    <th scope="col">대표자 명</th>
                    <th scope="col">등록일자</th>
                    
                  </tr>
                </thead>
                <tbody>
                 
               
                </tbody>
                
                
            <c:forEach items="${list}" var="startupVO" varStatus="var">

							<tr>
								<c:if test="${pageMaker.cri.page == 1 }">
								<td>${var.count }</td>
								</c:if>
								
								<c:if test="${pageMaker.cri.page != 1 }">
								<td>${var.count + ((pageMaker.cri.page-1)*10) }</td>
								</c:if>
								
								<td><a href='/startup/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&startupId=${startupVO.startupId}'>
										${startupVO.startupId} </a></td>
								<td>${startupVO.startupName}</td>	
								<%-- <td><fmt:formatDate pattern="yyyy-MM-dd" 
										value="${startupVO.establishedYear}" /></td> --%> 	
								<td>    <fmt:parseDate value="${startupVO.establishedYear}" pattern ="yyyy-MM-dd" > </fmt:parseDate></td> 			 
								<td>${startupVO.sizes}</td>
								<td>${startupVO.categorys}</td>
								<td>${startupVO.business}</td>
								<td>${startupVO.noOfEmployees}</td>
								<td>${startupVO.city}</td>
								<td>${startupVO.items}</td>
								<td>${startupVO.email}</td>
								<td>${startupVO.names}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${startupVO.regdate}" /></td>
								
							</tr>

						</c:forEach>
		
                
              </table>
              <!-- End Primary Color Bordered Table -->

            </div>
          </div>
         
         
         
         <div class="card" >
            <div class="card-body" >
       
             <div class="text-center">
                <ul class="pagination">
                
                
                	<c:if test="${pageMaker.prev}">
								<li>
								<a class="page-link" href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a>
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
								<li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
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

<!-- <script>
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
</script> -->


     
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
