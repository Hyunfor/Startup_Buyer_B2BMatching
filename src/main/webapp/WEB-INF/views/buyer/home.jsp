<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/buyer_header.jsp" />
<main id="main" class="main">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Components / Accordion - NiceAdmin Bootstrap Template</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: NiceAdmin
  * Updated: Jul 27 2023 with Bootstrap v5.3.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<section class="section">
	<div class="row">
		<div class="col-lg-6">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title">보낸 매칭 요청</h5>

					<!-- Default Accordion -->
					<div class="accordion" id="accordionExample">
						<div class="accordion-item">
							<h2 class="accordion-header" id="headingOne">
								<button class="accordion-button" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseOne"
									aria-expanded="true" aria-controls="collapseOne">
									<i class="bi bi-box-arrow-in-right"></i>&nbsp;&nbsp;스타트업 1
								</button>
							</h2>
							<div id="collapseOne" class="accordion-collapse collapse show"
								aria-labelledby="headingOne" data-bs-parent="#accordionExample">
								<div class="accordion-body">
									<strong>기업 이메일</strong> - daejeon@gmail.com<br> <strong>기업명</strong>
									- 대전기업<br> <strong>설립일</strong> - 23/08/31<br> <strong>규모</strong>
									- 대기업<br> <strong>업종</strong> - IT<br> <strong>업태</strong>
									- 서비스<br> <strong>직원 수</strong> - 1000<br> <strong>주소</strong>
									- 대전광역시 대덕구<br> <strong>주력상품</strong> - PC<br> <strong>대표자
										명</strong> - 김대전<br> <strong>등록일자</strong> - 23/08/31<br>

								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="headingTwo">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseTwo"
									aria-expanded="false" aria-controls="collapseTwo">
									<i class="bi bi-box-arrow-in-right"></i>&nbsp;&nbsp;스타트업 2
								</button>
							</h2>
							<div id="collapseTwo" class="accordion-collapse collapse"
								aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
								<div class="accordion-body">
									<strong>기업 이메일</strong> - daejeon@gmail.com<br> <strong>기업명</strong>
									- 대전기업<br> <strong>설립일</strong> - 23/08/31<br> <strong>규모</strong>
									- 대기업<br> <strong>업종</strong> - IT<br> <strong>업태</strong>
									- 서비스<br> <strong>직원 수</strong> - 1000<br> <strong>주소</strong>
									- 대전광역시 대덕구<br> <strong>주력상품</strong> - PC<br> <strong>대표자
										명</strong> - 김대전<br> <strong>등록일자</strong> - 23/08/31<br>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="headingThree">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseThree"
									aria-expanded="false" aria-controls="collapseThree">
									<i class="bi bi-box-arrow-in-right"></i>&nbsp;&nbsp;스타트업 3
								</button>
							</h2>
							<div id="collapseThree" class="accordion-collapse collapse"
								aria-labelledby="headingThree"
								data-bs-parent="#accordionExample">
								<div class="accordion-body">
									<strong>기업 이메일</strong> - daejeon@gmail.com<br> <strong>기업명</strong>
									- 대전기업<br> <strong>설립일</strong> - 23/08/31<br> <strong>규모</strong>
									- 대기업<br> <strong>업종</strong> - IT<br> <strong>업태</strong>
									- 서비스<br> <strong>직원 수</strong> - 1000<br> <strong>주소</strong>
									- 대전광역시 대덕구<br> <strong>주력상품</strong> - PC<br> <strong>대표자
										명</strong> - 김대전<br> <strong>등록일자</strong> - 23/08/31<br>
								</div>
							</div>
						</div>
					</div>
					<!-- End Default Accordion Example -->

				</div>
			</div>

		</div>

		<div class="col-lg-6">

			<div class="card">
				<div class="card-body">
					<h5 class="card-title">받은 매칭 요청</h5>

					<!-- Accordion without outline borders -->
					<div class="accordion accordion-flush" id="accordionFlushExample">
						<div class="accordion-item">
							<h2 class="accordion-header" id="flush-headingOne">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
									aria-expanded="false" aria-controls="flush-collapseOne">
									<i class="bi bi-box-arrow-in-left"></i>&nbsp;&nbsp;스타트업 4
								</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								aria-labelledby="flush-headingOne"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
								<strong>기업 이메일</strong> - daejeon@gmail.com<br> <strong>기업명</strong>
									- 대전기업<br> <strong>설립일</strong> - 23/08/31<br> <strong>규모</strong>
									- 대기업<br> <strong>업종</strong> - IT<br> <strong>업태</strong>
									- 서비스<br> <strong>직원 수</strong> - 1000<br> <strong>주소</strong>
									- 대전광역시 대덕구<br> <strong>주력상품</strong> - PC<br> <strong>대표자
										명</strong> - 김대전<br> <strong>등록일자</strong> - 23/08/31<br>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="flush-headingTwo">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
									aria-expanded="false" aria-controls="flush-collapseTwo">
									<i class="bi bi-box-arrow-in-left"></i>&nbsp;&nbsp;스타트업 5
								</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse"
								aria-labelledby="flush-headingTwo"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<strong>기업 이메일</strong> - daejeon@gmail.com<br> <strong>기업명</strong>
									- 대전기업<br> <strong>설립일</strong> - 23/08/31<br> <strong>규모</strong>
									- 대기업<br> <strong>업종</strong> - IT<br> <strong>업태</strong>
									- 서비스<br> <strong>직원 수</strong> - 1000<br> <strong>주소</strong>
									- 대전광역시 대덕구<br> <strong>주력상품</strong> - PC<br> <strong>대표자
										명</strong> - 김대전<br> <strong>등록일자</strong> - 23/08/31<br>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="flush-headingThree">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseThree"
									aria-expanded="false" aria-controls="flush-collapseThree">
									<i class="bi bi-box-arrow-in-left"></i>&nbsp;&nbsp;스타트업 6
								</button>
							</h2>
							<div id="flush-collapseThree" class="accordion-collapse collapse"
								aria-labelledby="flush-headingThree"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<strong>기업 이메일</strong> - daejeon@gmail.com<br> <strong>기업명</strong>
									- 대전기업<br> <strong>설립일</strong> - 23/08/31<br> <strong>규모</strong>
									- 대기업<br> <strong>업종</strong> - IT<br> <strong>업태</strong>
									- 서비스<br> <strong>직원 수</strong> - 1000<br> <strong>주소</strong>
									- 대전광역시 대덕구<br> <strong>주력상품</strong> - PC<br> <strong>대표자
										명</strong> - 김대전<br> <strong>등록일자</strong> - 23/08/31<br>
								</div>
							</div>
						</div>
					</div>
					<!-- End Accordion without outline borders -->

				</div>
			</div>

		</div>
	</div>
</section>

</main>
<!-- End #main -->

<%@include file="../include/buyer_footer.jsp"%>
