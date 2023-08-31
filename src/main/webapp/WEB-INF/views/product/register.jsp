<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/startup_header.jsp" />


<main id="main" class="main">

<div class="pagetitle">
	<h1>상품등록</h1>
</div>

<section class="section">
	<div class="row">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">상품 정보 등록</h5>

					<!-- General Form Elements -->

			<form role="form" method="post" name="frm">
					
				<div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">상품명 <span class="must-mark">*</span></label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="pname" id="pname">
                  </div>
                </div>		
                
				<div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">기업명</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="startupId" id="startupId" value="${login.sId}" readonly>
                  </div>
                </div>	       
                         		
				<div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">카테고리 <span class="must-mark">*</span></label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="category" id="category" placeholder="카테고리를 입력하세요">
                  </div>
                </div>			
                     
				<div class="row mb-3">
                  <label for="inputPassword" class="col-sm-2 col-form-label">상세내용</label>
                  <div class="col-sm-10">
                    <textarea class="form-control" name="content" id="content" style="height: 100px"></textarea>
                  </div>
                </div>						

						<div id='mydropzone' class="dropzone">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">첨부파일</label>
							<input type="file" id="fileUpload" name="fileUpload"
							style="visibility: hidden;" />

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
							</ul>
						</div>

				<div class="text-center">
                  <button type="submit" class="btn btn-primary">등록</button>
                  <button type="button" class="btn btn-secondary" onclick="location.href='adminList'">취소</button>
                </div>

<!-- 						<div class="row mb-3">
							<label class="col-sm-2 col-form-label">등록하기</label>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">등록</button>
								<button type="button" onclick="location.href='adminList'" class="btn btn-light" style="font-size: 14px;">취소</button>
							</div>
						</div> -->


					</form>
					<!-- End General Form Elements -->

				</div>
			</div>

		</div>


	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
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
		// 신청 등록 유효성 검사 
		function validate() {

			var title = $("#pname").val();
			var content = $("#content").val();

			if (title == "") {
				alert("상품명을 입력해주세요 .");
				document.getElementById("pname").focus();
				return false;
			}

			if (content == "") {
				alert("내용을 입력해주세요 .");
				document.getElementById("content").focus();
				return false;
			}

			return true;

		}
	</script>

	<script>
		$("input:text[numberOnly]").on("focus", function() {
			var x = $(this).val();
			x = removeCommas(x);
			$(this).val(x);
		}).on("focusout", function() {
			var x = $(this).val();
			if (x && x.length > 0) {
				if (!$.isNumeric(x)) {
					x = x.replace(/[^0-9]/g, "");
				}
				x = addCommas(x);
				$(this).val(x);
			}
		}).on("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/g, ""));
		});
	</script>


	<script>
	
		$(document).ready(function() {
			var formObj = $("form[role='form']");
				formObj.submit(function(event) {
				event.preventDefault();
			
			//유효성 검사
			var val = validate();
			if (val) {var that = $(this);
			var str = "";

			$(".uploadedList .delbtn").each(function(index) {
				str += "<input type='hidden' name='files'"
				+ " value='" + $( this).attr("href") + "'> ";
				});

				that.append(str);
				console.log(str);
				that.get(0).submit();
					}//if문 종료
				});
				
			$(".btn-cancel").on("click",function() {
				self.location = "list&page=${cri.page}&perPageNum=${cri.perPageNum}"
					+ "&searchType=${cri.searchType}&listType=${cri.listType}&keyword=${cri.keyword}";
					});
				
		
		});
		
		$('#mydropzone').click(function(event) {
			document.frm.fileUpload.click();
		});

		var template = Handlebars.compile($("#template").html());

		//dragenter dragover, drop 기본 동작 막기(기본적인 이벤트 처리 제한 preventDefault) 끌어다 놓으면 새로운 창이 열리는 동작
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		});

		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();

			var uploaded = $("#uploadCount").val();

			//event.dataTransfer=이벤트와 같이 전달된 데이터   
			//dataTransfer.files= 그안 에 포함된 전달된 파일 데이터를 찾아 가져오는 부분
			//jQuery를 이용하는 경우 envent가 순수한 DOM 이벤트가 아니기때문에 
			var files = event.originalEvent.dataTransfer.files;

			var file = files[0];

			//formData를 이용한 서버 호출 (기존 <form>태그로 만든 데이터 전송방식과 동일)
			var formData = new FormData();

			//file 이름으로 파일 객체 추가
			formData.append("file", file);

			//$.post()를 사용하지 않고 $.ajax() 사용하는 대신 processData,contentType: false로 지정
			$.ajax({
				url : '/uploadAjax',
				data : formData,
				dataType : 'text',
				processData : false, //데이터를 자동 변환 할 것인지(true:일반적인 query string / false:자동 변환 없이)
				contentType : false, //기본값(true) application/urlcod 타입으로 전송 / 파일의 경우(false) multipart/form_data 방식으로 전송
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

		//첨부파일 삭제 처리
		$(".uploadedList").on("click", ".delbtn", function(event) {
			event.preventDefault();

			var that = $(this);
			var uploaded = $("#uploadCount").val();

			$.ajax({
				url : "/deleteFile",
				type : "post",
				data : {
					fileName : $(this).attr("href")
				},
				dataType : "text",
				success : function(result) {

					if (result == 'deleted') {

						that.closest("li").remove();
						uploaded--;
						$("#uploadCount").attr("value", uploaded);

					}
				}

			});

		});
		//파일링크 처리(길이를 줄여줌)
		function getOriginalName(noticeFileName) {

			if (checkImageType(noticeFileName)) {
				return;
			}

			var idx = noticeFileName.indexOf("_") + 1;
			return noticeFileName.substr(idx);

		}
		//이미지파일 원본 파일 찾기
		function getImageLink(noticeFileName) {

			if (!checkImageType(noticeFileName)) {
				return;
			}
			//noticeFileName.substring(0,12)/년/월/일 경로 추출  
			//noticeFileName.substring(14) 파일 이름앞의 's_'제거
			var front = noticeFileName.substr(0, 12);
			var end = noticeFileName.substr(14);

			return front + end;

		}
	</script>




	<script>
		$(document).ready(function() {

			var formObj = $("form[role='form']");

			console.log(formObj);

			$("#btn_submit").on("click", function() {

				formObj.submit();
			});
		});
	</script>

</section>

</main>


<%@include file="../include/startup_footer.jsp"%>