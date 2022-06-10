<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"  language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>EX-EM</title>
	<%@include file ="../include/config.jsp" %>
	<script type="module" src="/dist/adminPwChange.js"></script>
</head>
<body class="hold-transition login-page">
<div class="login-box">
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<a href="#" class="h1"><b>Admin</b></a>
		</div>
		<div class="card-body">
			<p class="login-box-msg">Change Password</p>
			<form name="frm" id="frm" method="POST">
				<div class="input-group mb-3">
					<input
							type="text"
							name="login_id"
							id="loginId"
							class="form-control"
							placeholder="ID"
					/>
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-user"></span>
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
							placeholder="Confirm Password"
					/>
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
				</div>

				<div class="input-group mb-3" style="height: 15px">
					<span id="msg"></span>
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
								id="pwChangeBtn"
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
