package com.doctor.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/doctorLogout")
public class DoctorLogout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.removeAttribute("doctorObj");
        session.setAttribute("sucMsg","Doctor Logout Successfully");
        res.sendRedirect("doctor_login.jsp");
     }
}
