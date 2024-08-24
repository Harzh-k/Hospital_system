package com.admin.servlet;

import com.dao.DoctorDao;
import com.db.DbConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id=Integer.parseInt(req.getParameter("id"));
        DoctorDao dao= new DoctorDao(DbConnect.getConn());
        HttpSession session=req.getSession();

        if(dao.deleteDoctor(id)){
            session.setAttribute("sucMsg","Doctor Delete Successfully..");
            res.sendRedirect("admin/view_doctor.jsp");
        }else{
            session.setAttribute("error","something went wrong");
            res.sendRedirect("admin/view_doctor.jsp");
        }

    }
}
