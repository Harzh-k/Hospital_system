<html>
<head>
<title>Doctor Login</title>
<%@include file="components/allcss.jsp"%>
</head>
<body>
<%@include file="components/navbar.jsp"%>

<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Doctor Login</p>

						<c:if test="${not empty sucMsg}">
                        <p class="text-center text-success fs-5">${sucMsg}</p>
                        <c:remove var="sucMsg" scope="session"/>
                        </c:if>

                        <c:if test="${not empty error}">
                        <p class="text-center text-danger fs-5">${error}</p>
                        <c:remove var="error" scope="session"/>
                        </c:if>

						<form action="doctorLogin" method="post">
							<div class="mb-3">
								<label class="form-label">Email Address</label><input required
									name="email" type="email" class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>





</body>

</html>