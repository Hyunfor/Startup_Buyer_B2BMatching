<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fmt2" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../include/header.jsp" />

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">상품 상세보기</h3>
				</div>
				<!-- /.box-header -->


				<form role="form" action="modify" method="post">
					<input type='hidden' name='noticeNo' value="${noticeVO.noticeNo}">
					<input type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">

					<div class="row">
						<div class="col-12">

							<div class="card">
								<div class="card-body">
									<h4 class="header-pname">상품 상세보기</h4>
									<div class="form-group col-xs-12">
										<label for="inputAddress2" class="col-form-label">상품명<span
											class="must-mark">*</span></label> <input type="text" name="pname"
											id="pname" value="${productVO.pname}" class="form-control"
											disabled="disabled">
									</div>

									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="inputEmail4" class="col-form-label">스타트업</label>
											<input type="text" name="startup_id" id="startup_id"
												value="${productVO.startup_id}" class="form-control"
												disabled="disabled">
										</div>

										<div class="form-group col-md-6">
											<label for="category" class="col-form-label">카테고리</label> <input
												type="text" class="form-control" name="category"
												id="category" value="${productVO.category}" />
										</div>
									</div>



									<div class="form-group">
										<label for="inputAddress2" class="col-form-label">상세내용</label>
										<textarea class="form-control" name="content" id="content"
											rows="15" disabled="disabled">${productVO.content}</textarea>
									</div>


									<c:if test="${!empty ProductIMGVO}">
										<div class="form-group">
											<label for="exampleInputEmail1" class="col-form-label">첨부파일</label>
										</div>

										<ul class="dropzone-previews">

											<c:forEach items="${ProductIMGVO}" var="ProductIMGVO"
												varStatus="status">
												<c:set var="img_namee"
													value="${ProductIMGVO.img_name}" />
												<c:set var="noticeFileNo"
													value="${fn:toLowerCase(img_name)}" />

												<li class="dropzone-previews mt-3">
													<div
														class="card mt-1 mb-0 shadow-none border dz-processing dz-image-preview dz-success dz-complete">
														<div class="p-2">
															<div class="row align-items-center">
																<c:forTokens var="token" items="${pimage_no}"
																	delims="." varStatus="status">
																	<c:if test="${status.last}">
																		<c:choose>
																			<c:when test="${token eq 'hwp'}">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/hwp.png"
																					alt="${img_name}" />
																			</c:when>
																			<c:when test="${token eq 'xls' || token eq 'xlsx' }">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/excelIcon.png" />
																			</c:when>
																			<c:when
																				test="${token eq 'jpg' || token eq 'gif' || token eq 'png' || token eq 'bmp' }">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/displayFile?fileName=${ProductIMGVO.fileLocation}">
																			</c:when>
																			<c:when test="${token eq 'pdf'}">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/pdf.png"
																					alt="${img_name}" />
																			</c:when>
																			<c:when test="${token eq 'ppt' }">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/ppt.png"
																					alt="${img_name}" />
																			</c:when>
																			<c:otherwise>
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/file.svg"
																					alt="${img_name}" />
																			</c:otherwise>
																		</c:choose>
																	</c:if>
																</c:forTokens>
																<div class="col pl-0">
																	<a
																		href="/displayFile?fileName=${ProductIMGVO.fileLocation}"
																		text-muted font-weight-bold data-dz-name="">
																		${ProductIMGVO.img_name}</a>
																</div>
															</div>
														</div>
													</div>
												</li>
											</c:forEach>
										</ul>
									</c:if>
									<c:if test="${empty ProductIMGVO}">
									</c:if>
									<br> <br>
									<div style="text-align: right;">

										<button type="button" class="btn btn-success"
											style="font-size: 14px;">수정</button>
										<button type="button" class="btn btn-light"
											style="font-size: 14px;">목록</button>
										<button class="btn btn-danger" type="submit">삭제</button>
									</div>
								</div>
							</div>
							<!-- end card -->
						</div>
						<!-- end col-12 -->
					</div>
					<!-- end row -->
				</form>
			</div>
			<!-- container -->

		</div>
		<!-- content -->

		<script>
			$(document).ready(function() {

				var formObj = $("form[role='form']");

				console.log(formObj);

				/* 수정버튼 */
				$(".btn-success").on("click", function() {
					formObj.attr("action", "/product/modify");
					formObj.attr("method", "get");
					formObj.submit();
				});
				//목록버튼
				$(".btn-light").on("click", function() {
					formObj.attr("method", "get");
					formObj.attr("action", "/product/list");
					formObj.submit();
				});
				/* 삭제버튼 */
				$(".btn-danger").on("click", function() {
					formObj.attr("action", "/product/remove");
					formObj.submit();
				});

			});

			function checkImageType(fileName) {

				var pattern = /jpg|gif|png|jpeg/i;

				return img_name.match(pattern);

			}
		</script>
	</div>
</section>
<!-- /.content -->

<%@include file="../include/footer.jsp"%>