package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.parseLong;

@WebServlet(name = "controllers.AdInfoServlet", urlPatterns = "/adsInfo")
public class AdInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adInfo = request.getParameter("card-id");
        Long adId= parseLong(adInfo);

//        String ad_user = request.getParameter("ad")

        Ad currentAd = DaoFactory.getAdsDao().findByAdId(adId);
        request.setAttribute("selectedAd", currentAd);
        request.getRequestDispatcher("/WEB-INF/ads/adInfo.jsp").forward(request,response);
    }
}
