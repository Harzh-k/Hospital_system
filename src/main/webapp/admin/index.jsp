<%@page import="com.dao.DoctorDao"%>
<%@page import="com.db.DbConnect"%>
<html>
<head>
<title>Admin Dashboard</title>
<%@include file="../components/allcss.jsp"%>
<style type="text/css">
.paint-card{
 box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
 }
 </style>
</head>

<body>
<%@include file="navbar.jsp"%>

<c:if test="${empty adminobj}">
<c:redirect url="../admin_login.jsp"></c:redirect>
</c:if>

	<div class="container p-5">
		<p class="text-center fs-3">Admin Dashboard</p>

		<c:if test="${not empty error}">
			<p class="fs-3 text-cen ter text-danger">${error}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		<c:if test="${not empty sucMsg}">
			<div class="fs-3 text-center text-success" role="alert">${sucMsg}</div>
			<c:remove var="sucMsg" scope="session" />
		</c:if>


       <%DoctorDao dao=new DoctorDao(DbConnect.getConn());%>
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<div class=" card-body text-center text-success">
						<i class="fas fa-light fa-user-doctor fa-3x" style="color: #005eff;"></i><br>
						<p class="fs-4 text-primary text-center">
							Doctor <br><%=dao.countDoctor()%>
						</p>
					</div>
				</div>
			</div>





			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-solid fa-user fa-3x" style="color: #005eff;"></i><br>
						<p class="fs-4 text-center text-primary">
							User <br><%=dao.countUser()%>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x "style="color: #005eff;"></i><br>
						<p class="fs-4 text-center text-primary">
							Total Appointment <br><%=dao.countAppointment()%>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4 mt-2">

				<div class="card paint-card " data-bs-toggle="modal"
					data-bs-target="#exampleModal">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x "style="color: #005eff;"></i><br>
						<p class="fs-4 text-center text-primary">
							Specialist <br><%=dao.countSpecialist()%>
						</p>
					</div>
				</div>

			</div>

		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="../addSpecialist" method="post">

						<div class="form-group">
							<label>Enter Specialist Name</label> <input type="text"
								name="specname" class="form-control">
						</div>
						<div class="text-center mt-3">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>

					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>