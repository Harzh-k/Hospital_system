package com.doctor.servlet;

import com.dao.DoctorDao;
import com.dao.UserDao;
import com.db.DbConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doctorChangePassword")
public class DoctorPasswordChange extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");

        DoctorDao dao = new DoctorDao(DbConnect.getConn());
        HttpSession session = req.getSession();

        if (dao.checkOldPassword(uid, oldPassword)) {

            if (dao.changePassword(uid, newPassword)) {
                session.setAttribute("sucMsg", "Password Change Sucessfully");
                res.sendRedirect("doctor/edit_profile.jsp");

            } else {
                session.setAttribute("error", "Something wrong on server");
                res.sendRedirect("doctor/edit_profile.jsp");
            }

        } else {
            session.setAttribute("error", "Old Password Incorrect");
            res.sendRedirect("doctor/edit_profile.jsp");
        }
    }
}
