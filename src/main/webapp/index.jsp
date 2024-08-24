<%@page import="com.db.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Care Hospital</title>

<%@include file="components/allcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0.3);
}
</style>

</head>
<body>
	<%@include file="components/navbar.jsp"%>
    <% Connection conn=DbConnect.getConn();
    out.print(conn);%>
	<!--carousel--!>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="images/img3.jpg" class="d-block w-100" alt="..." height="500px">
			</div>
			<div class="carousel-item">
				<img src="images/img2.png" class="d-block w-100" alt="..." height="500px">
			</div>
			<div class="carousel-item">
				<img src="images/img1.jpg" class="d-block w-100" alt="..." height="500px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

<!--cards--!>
	<div class="container p-3">
		<p class="text-center fs-2">Key Features of our Hospital</p>
		<div class="row">
			<div class="col-md-8-p-5">
				<div class="row">
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">
									<b>Experienced Medical Professionals</b>
								</p>
								<p>Staffed with a team of skilled and compassionate medical
									professionals dedicated to delivering expert care.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">
									<b>Comprehensive Medical Care</b>
								</p>
								<p>Offering a wide spectrum of healthcare services, ensuring
									all-encompassing medical support for our community.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">
									<b>State-of-the-Art Facilities</b>
								</p>
								<p>Equipped with cutting-edge technology and modern
									facilities to provide advanced and efficient healthcare
									services.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">
									<b>Patient-Centered Approach</b>
								</p>
								<p>Embracing a patient-focused philosophy, we prioritize
									open communication and create a supportive environment for
									personalized healthcare experiences.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr>

<!--card two--!>
	<div class="container p-2 center">
		<p class="text-center fs-2">Our Team</p>
		<div class="row d-flex justify-content-center">

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="images/harsh.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5 text-center pt-3">Harshal Khilari</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="images/atharva.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5 text-center pt-3">Atharva Shinde</p>
					</div>
				</div>
			</div>


		</div>
	</div>





	<%@include file="components/footer.jsp"%>



</body>
</html>