<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Pages / Register - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="/resources/admin/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/admin/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="/resources/admin/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="/resources/admin/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="/resources/admin/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="/resources/admin/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="/resources/admin/assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="/resources/admin/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: NiceAdmin
  * Updated: Jul 27 2023 with Bootstrap v5.3.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <main>
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="/" class="logo d-flex align-items-center w-auto">
                  <img src="assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">BizMatch - Startup</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body">
                			<form action="/startupUser/memberRegister" role="form" method="post">
                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">Create an Account</h5>
                    <p class="text-center small">Enter your personal details to create account</p>
                  </div>
                    
                    <div class="col-12">
                      <label for="sName" class="form-label">Name</label>
                        <input type="text" name="sName" class="form-control" id="sName" required>
                        <div class="invalid-feedback">Please choose a username.</div>
                    </div>

                    <div class="col-12">
                      <label for="sId" class="form-label">Startup ID(Email)</label>
                      <input type="text" name="sId" class="form-control" id="sId" required>
                      <div class="invalid-feedback">Please enter a valid ID.</div>
                    </div>

                    <div class="col-12">
                      <label for="sPw" class="form-label">Password</label>
                      <input type="password" name="sPw" class="form-control" id="sPw" required>
                      <div class="invalid-feedback">Please enter your password.</div>
                    </div>
                    
                    
                      <div class="col-12">
                      <label for="country" class="form-label">Startup Name</label>
                      <input type="text" name="startupName" class="form-control" id="startupName" required>
                      <div class="invalid-feedback">Please enter your Startup Name.</div>
                    </div>
                    
                    <div class="col-12">
                      <label for="country" class="form-label">establishedYear</label>
                      <input type="text" name="establishedYear" class="form-control" id="establishedYear" required>
                      <div class="invalid-feedback">Please enter your establishedYear.</div>
                    </div>
                    
                    <div class="col-12">
                      <label for="category" class="form-label">sizes</label>
                      <input type="text" name="sizes" class="form-control" id="sizes" required>
                      <div class="invalid-feedback">Please enter your sizes.</div>
                    </div>
                    
                    <div class="col-12">
                      <label for="business" class="form-label">categorys</label>
                      <input type="text" name="categorys" class="form-control" id="categorys" required>
                      <div class="invalid-feedback">Please enter your categorys.</div>
                    </div>
                    
                    <div class="col-12">
                      <label for="items" class="form-label">business</label>
                      <input type="text" name="business" class="form-control" id="business" required>
                      <div class="invalid-feedback">Please enter your business.</div>
                    </div>
                    
                     <div class="col-12">
                      <label for="items" class="form-label">noOfEmployees</label>
                      <input type="text" name="noOfEmployees" class="form-control" id="noOfEmployees" required>
                      <div class="invalid-feedback">Please enter your noOfEmployes.</div>
                    </div>
                    
                     <div class="col-12">
                      <label for="items" class="form-label">city</label>
                      <input type="text" name="city" class="form-control" id="city" required>
                      <div class="invalid-feedback">Please enter your city.</div>
                    </div>
                    
                     <div class="col-12">
                      <label for="items" class="form-label">items</label>
                      <input type="text" name="items" class="form-control" id="items" required>
                      <div class="invalid-feedback">Please enter your items.</div>
                    </div>
                 
                    
                    
                    

                    
                    
                    

                    <div class="col-12">
                      <div class="form-check">
                        <input class="form-check-input" name="terms" type="checkbox" value="" id="acceptTerms" required>
                        <label class="form-check-label" for="acceptTerms">I agree and accept the <a href="#">terms and conditions</a></label>
                        <div class="invalid-feedback">You must agree before submitting.</div>
                      </div>
                    </div>
                    <div class="col-12">
                      <button class="btn btn-primary w-100" type="submit">Create Account</button>
                    </div>
                    <div class="col-12">
                      <p class="small mb-0">Already have an account? <a href="/startupUser/login">Log in</a></p>
                    </div>
                  </form>

                </div>
              </div>

              <div class="credits">
                <!-- All the links in the footer should remain intact. -->
                <!-- You can delete the links only if you purchased the pro version. -->
                <!-- Licensing information: https://bootstrapmade.com/license/ -->
                <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
              </div>

            </div>
          </div>
        </div>

      </section>

    </div>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="/resources/admin/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="/resources/admin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="/resources/admin/assets/vendor/chart.js/chart.umd.js"></script>
  <script src="/resources/admin/assets/vendor/echarts/echarts.min.js"></script>
  <script src="/resources/admin/assets/vendor/quill/quill.min.js"></script>
  <script src="/resources/admin/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="/resources/admin/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="/resources/admin/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="/resources/admin/assets/js/main.js"></script>

</body>
</html>