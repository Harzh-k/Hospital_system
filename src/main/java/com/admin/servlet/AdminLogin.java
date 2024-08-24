package com.admin.servlet;

import com.entity.User;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            String email=req.getParameter("email");
            String password=req.getParameter("password");

            HttpSession session=req.getSession();

            if("admin@gmail.com".equals(email) && "admin".equals(password)){
                session.setAttribute("adminobj",new User());
                res.sendRedirect("admin/index.jsp");
            }else{
                session.setAttribute("error","Invalid Email & Password");
                res.sendRedirect("admin_login.jsp");
            }

        }catch(Exception e){
           e.printStackTrace();
        }
    }
}
