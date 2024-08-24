package com.admin.servlet;

import com.dao.SpecialistDao;
import com.db.DbConnect;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String specname=req.getParameter("specname");

        SpecialistDao dao=new SpecialistDao(DbConnect.getConn());
        boolean f=dao.addSpecialist(specname);

        HttpSession session=req.getSession();

        if(f){
            session.setAttribute("sucMsg","Specialist Added");
            res.sendRedirect("admin/index.jsp");

        }else{
            session.setAttribute("error","Something went wrong");
            res.sendRedirect("admin/index.jsp");
        }
    }
}
