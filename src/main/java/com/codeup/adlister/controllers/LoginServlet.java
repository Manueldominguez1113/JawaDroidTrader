package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import org.mindrot.jbcrypt.BCrypt;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean Attempt= false;
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null) {

            response.sendRedirect("/login");
            return;
        }
        String hash = Password.hash(user.getPassword());
        System.out.println("original = " + user.getPassword());
        System.out.println("hash = " + hash);

        boolean validAttempt = Password.check(user.getPassword(), hash);

        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
//            PrintWriter script = response.getWriter();
//            script.println("<script>");
//            script.println("alert('You have the wrong user_ID or password')");
//            script.println("history.back()"); // going back to prior page ,-->login page
//            script.println("</script>");
            response.sendRedirect("/login");
            goGPost attempt =true;
        }




    }

}
