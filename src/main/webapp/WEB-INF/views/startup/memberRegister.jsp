<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- iCheck -->
<link href="/resources/plugins/iCheck/square/blue.css" rel="stylesheet"
	type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="/resources/index2.html"><b>MIS</b> Spring Project</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Register a new membership</p>

			<form action="/startup/memberRegister" role="form" method="post">
				<div class="form-group has-feedback">
					<div class="form-group">
						<label for="exampleInputEmail1">이름</label> <input type="text"
							name='s_name' class="form-control" placeholder="Enter Name">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">회원 이메일(아이디)</label> <input
							type="text" name='s_id' class="form-control"
							placeholder="Enter ID">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">회원 비밀번호</label> <input type="text"
							name='s_pw' class="form-control" placeholder="Enter PW">
					</div>

				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</form>
		</div>
	</div>
	<!-- /.login-box-body -->
	<!-- /.login-box -->

	<!-- jQuery 2.1.4 -->
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="/resources/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- iCheck -->
	<script src="/resources/plugins/iCheck/icheck.min.js"
		type="text/javascript"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>