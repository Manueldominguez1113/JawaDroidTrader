package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.parseLong;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("searchType");
        String searchInput = request.getParameter("search");

        /* String stringUser_id = request.getParameter("userid");
        long userid = parseLong(stringUser_id);*/
/*        if(search != null && searchInput != null) {
            //adID Title User Category
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
            request.setAttribute("users", DaoFactory.getUsersDao().all());
        } else {*/
        String userID = request.getParameter("userid");
        long id = parseLong(userID);
        request.setAttribute("user_name", DaoFactory.getUsersDao().findByUserId(id));
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
            request.setAttribute("user", DaoFactory.getUsersDao().all());
            /*request.setAttribute("userbyid", DaoFactory.getUsersDao().findByUserId(userid));*/
            //}
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
