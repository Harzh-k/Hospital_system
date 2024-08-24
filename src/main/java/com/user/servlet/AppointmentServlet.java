package com.user.servlet;

import com.dao.AppointmentDao;
import com.db.DbConnect;
import com.entity.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/appAppointment")
public class AppointmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int userId=Integer.parseInt(req.getParameter("userid"));
        String fullname=req.getParameter("fullname");
        String gender=req.getParameter("gender");
        String age=req.getParameter("age");
        String appointment_date=req.getParameter("appoint_date");
        String email=req.getParameter("email");
        String phno=req.getParameter("phno");
        String disease=req.getParameter("diseases");
        int doct_id=Integer.parseInt(req.getParameter("doct"));
        String address=req.getParameter("address");

        Appointment ap=new Appointment(userId,fullname,gender,age,appointment_date,email,phno,disease,doct_id,address,"pending");

        AppointmentDao dao=new AppointmentDao(DbConnect.getConn());
        HttpSession session= req.getSession();

        if(dao.addAppointment(ap)){
            session.setAttribute("sucMsg","Appointment sucessfully");
            res.sendRedirect("user_appointment.jsp");
        }else{
            session.setAttribute("error","Something went Wrong");
            res.sendRedirect("user_appointment.jsp");
        }
    }
}
