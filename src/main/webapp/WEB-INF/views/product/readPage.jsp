<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <%@include file="../include/header.jsp"%> --%>
<jsp:include page="../include/header.jsp" />

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">제품 상세보기</h3>
				</div>
				<!-- /.box-header -->

<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='pno' value="${productVO.pno}"> <input
		type='hidden' name='page' value="${cri.page}"> <input
		type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">상품명</label> <input type="text"
							name='pname' class="form-control" value="${productVO.pname}"
							readonly="readonly">
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">카테고리</label> <input type="text"
							name='price' class="form-control" value="${productVO.category}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">내용</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${productVO.content}</textarea>
					</div>
										
					
					<div class="form-group">
						<label for="exampleInputEmail1">스타트업</label> <input type="text"
							name="writer" class="form-control" value="${productVO.startup_id}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<c:if test="${productVO.writer eq login.usid }">
						<button type="submit" class="btn btn-warning">수정</button>
						<button type="submit" class="btn btn-danger">삭제</button>
					</c:if>	
					<button type="submit" class="btn btn-primary">목록</button>
				</div>

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
			formObj.attr("action", "/product/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-danger").on("click", function() {
			formObj.attr("action", "/product/removePage");
			formObj.submit();
		});

		$(".btn-primary").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/product/list");
			formObj.submit();
		});

	});
</script>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
