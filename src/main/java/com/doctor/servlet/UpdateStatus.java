package com.doctor.servlet;

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

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            int id=Integer.parseInt(req.getParameter("id"));
            int did=Integer.parseInt(req.getParameter("did"));
            String comm=req.getParameter("comm");

            AppointmentDao dao=new AppointmentDao(DbConnect.getConn());
            HttpSession session=req.getSession();

            if(dao.updateCommentStatus(id,did,comm)){
                session.setAttribute("sucMsg","Comment updated");
                res.sendRedirect("doctor/patient.jsp");
            }else{
                session.setAttribute("error","Something went wrong");
                res.sendRedirect("doctor/patient.jsp");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
