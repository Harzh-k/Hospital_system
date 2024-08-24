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

@WebServlet("/doctorUpdateProfile")
public class EditProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            String fullname= req.getParameter("fullname");
            String dob=req.getParameter("dob");
            String qualification=req.getParameter("qualification");
            String specialist=req.getParameter("spec");
            String email=req.getParameter("email");
            String mobno=req.getParameter("mobno");


            int id=Integer.parseInt(req.getParameter("id"));

            Doctor d=new Doctor(id,fullname , dob, qualification,specialist,email,mobno,"" );

            DoctorDao dao=new DoctorDao(DbConnect.getConn());

            HttpSession session=req.getSession();

            if(dao.editDoctor(d)){
                session.setAttribute("sucMsgd","Doctor update Successfully");
                res.sendRedirect("doctor/edit_profile.jsp");
            }else{
                session.setAttribute("errord","Something Went Wrong");
                res.sendRedirect("doctor/edit_profile.jsp");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
