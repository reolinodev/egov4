<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"  language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>EX-EM</title>
	<script type="module" src="/dist/adminConfig.js"></script>
	<link rel="stylesheet" href="/lib/tmpl/dist/css/adminlte.min.css"/>
	<script type="module" src="/dist/adminLogin.js"></script>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="card card-outline card-primary">
			<div class="card-header text-center">
				<a href="#" class="h1"><b>EX-EM</b></a>
			</div>

			<div class="card-body">
				<p class="login-box-msg">LOGIN</p>

				<form name="frm" id="frm" method="POST">
					<div class="input-group mb-3">
						<input type="text" class="form-control" name="login_id" id="loginId" title="ID" placeholder="ID"  />
						<input type="hidden" name="login_device" id="loginDevice"/>
						<input type="hidden" name="device_browser" id="deviceBrowser"/>

						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control" name="user_pw" id="userPw" title="Password" placeholder="Password" />

						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="idSaveCheck">
								<label for="idSaveCheck">
									Remember Id
								</label>
							</div>
						</div>
						<div class="col-4">
							<button type="button" class="btn btn-primary btn-block" id="loginBtn">Login</button>
						</div>
					</div>
				</form>

				<p class="mb-1" id="pwChangeBtn">
					<a href="#">Change Password</a>
				</p>
				<p class="mb-0" id="signUpBtn">
					<a href="#" class="text-center">Sign Up</a>
				</p>

				<div class="form-group row">
					<div class="col-12 text-lg-center" id="msg">${ msg }</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
