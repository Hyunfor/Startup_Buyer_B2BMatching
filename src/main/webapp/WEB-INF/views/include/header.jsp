<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Startup-Buyer AI B2B Matching Platform</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="/resources/user/assets/img/favicon.png" rel="icon">
  <link href="/resources/user/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="/resources/user/assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="/resources/user/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/user/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="/resources/user/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="/resources/user/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="/resources/user/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="/resources/user/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: BizLand
  * Updated: Jul 27 2023 with Bootstrap v5.3.1
  * Template URL: https://bootstrapmade.com/bizland-bootstrap-business-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

   <!-- jQuery 2.1.4 -->
   <script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<body>

  <!-- ======= Top Bar ======= -->
  <section id="topbar" class="d-flex align-items-center">
    <div class="container d-flex justify-content-center justify-content-md-between">
      <div class="contact-info d-flex align-items-center">
      </div>    
<div class="social-links d-none d-md-flex align-items-center">

<c:if test="${empty login}">
      <a href="startupUser/login"><i class="bi bi-box-arrow-in-right"></i><span> Startup Login </span></a>
      <a href="buyerUser/login"><i class="bi bi-box-arrow-in-right"></i><span> Buyer Login </span></a>
</c:if>
 
<c:if test="${not empty login}">
<c:choose>
<c:when test="${login.name ne null}">${login.name}
<c:if test="${login.getClass().name eq 'com.b2b.domain.StartUpUserVO'}">
<a href="/startup/readPage"><i class="bi bi-box-arrow-in-left"></i><span> My Page </span></a>
<a href="/startupUser/logout"><i class="bi bi-box-arrow-in-left"></i><span> Startup Logout </span></a>
</c:if>

<c:if test="${login.getClass().name eq 'com.b2b.domain.BuyerUserVO'}">
<a href="/buyer/readPage"><i class="bi bi-box-arrow-in-left"></i><span> My Page </span></a>
<a href="/buyerUser/logout"><i class="bi bi-box-arrow-in-left"></i><span> Buyer Logout </span></a>
</c:if>
</c:when>
</c:choose>
</c:if>
</div>
</div>
</section>

  <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">

      <h1 class="logo"><a href="/">BizMatch<span>.</span></a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt=""></a>-->

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto" href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="#about">About</a></li>
          <li><a class="nav-link scrollto" href="/startupCommon/list">Startups</a></li>
          <li><a class="nav-link scrollto" href="/buyerCommon/list">Buyers</a></li>
          <li><a class="nav-link scrollto" href="/productCommon/list">Products</a></li>
          <li><a class="nav-link scrollto" href="#contact">Contact</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->
