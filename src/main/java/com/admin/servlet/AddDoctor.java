package com.admin.servlet;

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


@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            String fullname= req.getParameter("fullname");
            String dob=req.getParameter("dob");
            String qualification=req.getParameter("qualification");
            String specialist=req.getParameter("spec");
            String email=req.getParameter("email");
            String mobno=req.getParameter("mobno");
            String password=req.getParameter("password");

            Doctor d=new Doctor(fullname , dob, qualification,specialist,email,mobno,password );

            DoctorDao dao=new DoctorDao(DbConnect.getConn());

            HttpSession session=req.getSession();

            if(dao.registerDoctor(d)){
                session.setAttribute("sucMsg","Doctor Added Successfully");
                res.sendRedirect("admin/doctor.jsp");
            }else{
                session.setAttribute("error","Something Went Wrong");
                res.sendRedirect("admin/doctor.jsp");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
