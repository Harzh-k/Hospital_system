package com.user.servlet;

import com.dao.UserDao;
import com.db.DbConnect;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user_register")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try{
            String fullName=req.getParameter("fullname");
            String email=req.getParameter("email");
            String password=req.getParameter("password");

            User u=new User(fullName,email,password);

            UserDao dao=new UserDao(DbConnect.getConn());

            HttpSession session=req.getSession();


            boolean f= dao.register(u);

            if(f){
                session.setAttribute("success","Register Successfully");
                resp.sendRedirect("signup.jsp");
            }else{
               session.setAttribute("error","Something went wrong");
                resp.sendRedirect("signup.jsp");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
