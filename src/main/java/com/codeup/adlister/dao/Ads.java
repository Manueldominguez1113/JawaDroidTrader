package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    long insert(Ad ad);
    long deleteAd(Ad ad);
    Ad findByAdId(long adId);
    Ad updateAd(Ad ad);
    Ad findByUserID(long userId);
    List<Ad>findAllByUserID(long userId);

}
