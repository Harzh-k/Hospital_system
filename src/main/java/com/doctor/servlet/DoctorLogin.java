package com.doctor.servlet;


import com.dao.DoctorDao;
import com.db.DbConnect;
import com.entity.Doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        HttpSession session=req.getSession();

        DoctorDao dao = new DoctorDao(DbConnect.getConn());
        Doctor doctor=dao.login(email,password);

        if(doctor !=null){
            session.setAttribute("doctorObj",doctor);
            res.sendRedirect("doctor/index.jsp");
        }else{
            session.setAttribute("error","Invalid email and password");
            res.sendRedirect("doctor_login.jsp");
        }
    }
}
