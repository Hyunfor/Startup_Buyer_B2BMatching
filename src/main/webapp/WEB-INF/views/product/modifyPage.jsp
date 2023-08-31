<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="../include/startup_header.jsp" />


<main id="main" class="main">

<div class="pagetitle">
	<h1>상품 수정</h1>
</div>
<section class="section">
	<div class="row">
		<div class="col-lg-12">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title">상품 정보 수정</h5>

					<!-- General Form Elements -->

					<form role="form" action="modifyPage" method="post" name="frm">

						<input type='hidden' name='pno' value="${productVO.pno}">
						<input type='hidden' name='page' value="${cri.page}"> <input
							type='hidden' name='perPageNum' value="${cri.perPageNum}">
						<input type='hidden' name='searchType' value="${cri.searchType}">
						<input type='hidden' name='keyword' value="${cri.keyword}">

					

					<div class="row mb-3">
						<label for="pname">상품명 <span class="must-mark">*</span></label> <input
							class="form-control" type="text" name="pname"
							value="${productVO.pname}" id="pname">
					</div>

					<div class="row mb-3">
						<label for="startupId" class="col-form-label">스타트업<span
							class="must-mark">*</span></label> <input type="text"
							class="form-control" name="startupId" id="startupId"
							value="${productVO.startupId}" disabled="disabled">
					</div>

					<div class="row mb-3">
						<label for="category" class="col-form-label">카테고리<span
							class="must-mark">*</span></label> <input type="text" name="category"
							id="category" class="form-control" value="${productVO.category}"
							placeholder="카테고리를 입력하세요">
					</div>

					<div class="row mb-3">
						<label for="contents" class="col-form-label">상세내용</label>
						<textarea class="form-control" name="content" id="content"
							rows="5">${productVO.content}</textarea>
					</div>

					<div id='mydropzone' class="dropzone">
						<label for="exampleInputEmail1" class="col-sm-2 control-label">첨부파일</label>
						<input type="file" id="fileUpload" name="fileUpload" style="visibility: hidden;" />

						<div class="fileDrop">
								<input type="hidden" id="uploadCount">
								<div class="alert alert-primary alert-dismissible fade show">
									<div class="d-flex align-items-center">
									<i class="h1 bi bi-cloud-download"></i>&nbsp;
									<h3>Drop files here or click to upload.</h3>
									</div>
									<span class="text-muted font-13">첨부파일을 업로드하려면 여기에 첨부파일
										파일을 끌어 넣거나 클릭해주세요</span>
								</div>

							</div>
					</div>
					<div>
						<ul class="dropzone-previews clearfix uploadedList">

							<c:forEach items="${fileList}" var="fVo" varStatus="status">
								<c:set var="imgName" value="${fVo.imgName}" />
								<c:set var="pimageNo" value="${fn:toLowerCase(imgName)}" />

								<li class="list-group-item dropzone-previews mt-3">
									<div
										class="card mt-1 mb-0 shadow-none border dz-processing dz-image-preview dz-success dz-complete">
										<div class="p-2">
											<div class="row align-items-center">
												<div class="col pl-0">
													<img alt="${fVo.imgName}"
														src="/displayFile?fileName=${fVo.fileLocation}">
												</div>
												<div class="col pl-0">
   													<a href="/displayFile?fileName=${fVo.fileLocation}" data-dz-name="">${fVo.imgName}</a>
 												</div>
												<div class="col-auto">
													<a href="${fVo.fileLocation}"
														class="btn btn-default btn-xs pull-right delbtn">
														<i class="bi bi-trash"></i></a>
												</div>
											</div>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					
					
				<div class="text-center">
                  <button type="submit" class="btn btn-primary">수정</button>
                  <a  class="btn btn-secondary" href="/product/adminList?searchType=${cri.searchType}&keyword=${cri.keyword}&page=${cri.page}&perPageNum=${cri.perPageNum}">목록</a>
                </div>

		</form>

						<!-- End General Form Elements -->

						<script
							src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
						<script type="text/javascript" src="/resources/upload.js"></script>
						<script
							src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
						<script id="template" type="text/x-handlebars-template">
							<li class="list-group-item dropzone-previews mt-3">
								<div class="card mt-1 mb-0 shadow-none border dz-processing dz-image-preview dz-success dz-complete">
									<div class="p-2">
										<div class="row align-items-center">
 											<div class="col-auto">
    											<img data-dz-thumbnail="" class="avatar-sm rounded bg-light" src="{{imgsrc}}">
 											</div>
 										<div class="col pl-0">
   											<a href="/displayFile?fileName={{fullName}}" text-muted font-weight-bold" data-dz-name="">{{fileName}}</a>
 										</div>
 										<div class="col-auto">
   											<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn"><i class="bi bi-trash"></i></a>
 										</div>
									</div>
								</div>
							</div>
						</li>
						</script>

						<script>
							function checkImageType(fileName) {
								var pattern = /jpg|gif|png|jpeg/i;
								return fileName.match(pattern);
							}
						</script>

						<script>
							$(document).ready(function() {
								var formObj = $("form[role='form']");
								
								formObj.submit(function(event) {
								event.preventDefault();
								
								var that = $(this);
								
								var str = "";
								
								$(".uploadedList .delbtn").each(
								function(index) {
									str += "<input type='hidden' name='files'" + " value='"
										+ $(this).attr("href") + "'> ";
									});
								that.append(str);
								that.get(0).submit(); 
								
								});
								
							});

							$('#mydropzone').click(function(event) {
								document.frm.fileUpload.click();
							});
							
							var template = Handlebars.compile($("#template").html());
							$(".fileDrop").on("dragenter dragover",
									function(event) {
										event.preventDefault();
									});

							$(".fileDrop").on("drop",function(event) {
								event.preventDefault();
								var uploaded = $("#uploadCount").val();
								var files = event.originalEvent.dataTransfer.files;
								var file = files[0];
								var formData = new FormData();
								
								formData.append("file", file);
								
								$.ajax({
									url : '/uploadAjax',
									data : formData,
									dataType : 'text',
									processData : false,
									contentType : false,
									type : 'POST',
									success : function(data) {
										var fileInfo = getFileInfo(data);
										var html = template(fileInfo);
										var str = "";
									$(".uploadedList").append(html);
										uploaded++;
									$("#uploadCount").attr("value",uploaded);
									$(".uploadedList").append(str);
															}
											});
									});

							//클릭으로 파일 업로드할 때 호출되는 함수
							$("#fileUpload").on("change", function(event) {
								event.preventDefault();

								var uploaded = $("#uploadCount").val();

								if (uploaded >= 3) {
									alert('첨부파일은 3개 까지 업로드할 수 있습니다.');
									return;
								}

								// 파일업로드 인풋에서 파일을 받음
								var file = document.getElementById("fileUpload").files[0];

								// 새로운 폼데이터를 생성
								var formData = new FormData();

								// 폼데이터에 파일을 붙임
								formData.append("file", file);

								// AJAX로 uploadAjax 메소드를 호출해서 파일을 업로드함
								$.ajax({
									url : '/uploadAjax',
									data : formData,
									dataType : 'text',
									processData : false,
									contentType : false,
									type : 'POST',
									success : function(data) {

										var fileInfo = getFileInfo(data);
										var html = template(fileInfo);

										var str = "";

										$(".uploadedList").append(html);

										uploaded++;
										$("#uploadCount").attr("value", uploaded);

										$(".uploadedList").append(str);
									}
								});
							});

							//파일 삭제 버튼 클릭 시 
							$(".uploadedList").on("click",".delbtn",function(event) {
								event.preventDefault();

								var that = $(this);
								var uploaded = $("#uploadCount").val();
								$.ajax({
											url : "/deleteFile",
											type : "post",
											data : { fileName : $(this).attr("href")
										}, dataType : "text",
										success : function(result) {

										if (result == 'deleted') {
										that.closest("li").remove();
										uploaded--;
										$("#uploadCount").attr("value",uploaded);
													}
												}
											});
									});

							function getOriginalName(noticeFileName) {

								if (checkImageType(noticeFileName)) {
									return;
								}

								var idx = noticeFileName.indexOf("_") + 1;
								return noticeFileName.substr(idx);

							}

							function getImageLink(noticeFileName) {

								if (!checkImageType(noticeFileName)) {
									return;
								}
								var front = noticeFileName.substr(0, 12);
								var end = noticeFileName.substr(14);

								return front + end;

							}
						</script>
					</div>
				</div>
			</div>
		</div>
</section>

</main>


<%@include file="../include/startup_footer.jsp"%>
