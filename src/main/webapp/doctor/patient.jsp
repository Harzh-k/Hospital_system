<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				<c:if test="${not empty sucMsg}">
                <p class="text-center text-success fs-5">${sucMsg}</p>
                <c:remove var="sucMsg" scope="session"/>
                </c:if>

                <c:if test="${not empty error}">
                <p class="text-center text-danger fs-5">${error}</p>
                <c:remove var="error" scope="session"/>
                </c:if>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor Name</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						Doctor d=(Doctor) session.getAttribute("doctorObj");
						AppointmentDao dao = new AppointmentDao(DbConnect.getConn());
						DoctorDao dao2 = new DoctorDao(DbConnect.getConn());
						List<Appointment> list = dao.getAllAppointmentByDoctorId(d.getId());
						for (Appointment ap : list) {
						%>
						<tr>
							<th><%=ap.getFullName()%></th>
							<td><%=ap.getGender()%></td>
							<td><%=ap.getAge()%></td>
							<td><%=ap.getAppointmentDate()%></td>
							<td><%=ap.getEmail()%></td>
							<td><%=ap.getPhoneNo()%></td>
							<td><%=ap.getDisease()%></td>
							<td><%=d.getFullname()%></td>
							<td><%=ap.getAddress()%></td>
							<td><%=ap.getStatus()%></td>

							<td>
								<%
								if ("pending".equals(ap.getStatus())) {
								%> <a
								href="comment.jsp?id=<%=ap.getId()%>"
								class="btn btn-success btn-sm">Comment</a> <%
 } else {
 %><a href="comment.jsp"
								class="btn btn-success btn-sm disabled">Comment</a>
								<%
								}
								%>
							</td>
						</tr>
						<%
						}
						%>


					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>