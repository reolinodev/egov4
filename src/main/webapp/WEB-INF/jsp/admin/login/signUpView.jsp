<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"  language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>EX-EM</title>
	<%@include file ="../include/config.jsp" %>
	<script type="module" src="/dist/adminSignUp.js"></script>
</head>
<body class="hold-transition register-page">
<div class="register-box" style="width: 500px">
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<a href="#" class="h1"><b>Admin</b></a>
		</div>
		<div class="card-body">
			<p class="login-box-msg">SIGN UP</p>

			<form name="frm" id="frm" method="POST">
				<div class="input-group mb-3">
					<input
							type="text"
							name="login_id"
							id="loginId"
							class="form-control"
							placeholder="ID"
					/>
					<input type="hidden" id="signUpChk" value="N" />
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-user"></span>
						</div>
					</div>
					<div class="col-4">
						<button
								type="button"
								class="btn btn-success btn-block"
								id="signUpCheckBtn"
						>
							Check Id
						</button>
					</div>
				</div>
				<div class="input-group mb-3">
					<input
							type="text"
							name="user_nm"
							id="userNm"
							class="form-control"
							placeholder="Name"
					/>
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-user"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input
							type="email"
							name="email"
							id="email"
							class="form-control"
							placeholder="Email"
					/>
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-envelope"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input
							type="number"
							name="cell_phone"
							id="cellPhone"
							class="form-control"
							placeholder="Phone number"
					/>
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-phone"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input
							type="password"
							name="user_pw"
							id="userPw"
							class="form-control"
							placeholder="Password"
					/>
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input
							type="password"
							id="userPwRe"
							class="form-control"
							placeholder="Retype password"
					/>
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-12 text-lg-center" id="msg"></div>
				</div>

				<div class="row">
					<div class="col-6">
						<button
								type="button"
								class="btn btn-secondary btn-block"
								id="returnBtn"
						>
							Return
						</button>
					</div>

					<div class="col-6">
						<button
								type="button"
								class="btn btn-primary btn-block"
								id="signUpBtn"
						>
							Submit
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
