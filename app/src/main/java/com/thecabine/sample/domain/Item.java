package com.thecabine.sample.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by admin on 10/21/15.
 */
public class Item implements Serializable{
    private static final long serialVersionUID = 1L;

    @SerializedName("type")
    private String mType;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("shortDescription")
    private String mShortDescription;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("smallImage")
    private String mSmallImageUrl;
    @SerializedName("bigImage")
    private String mBigImageUrl;
    @SerializedName("latitude")
    private String mLatitude;
    @SerializedName("longitude")
    private String mLongitude;

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getSmallImageUrl() {
        return mSmallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        mSmallImageUrl = smallImageUrl;
    }

    public String getBigImageUrl() {
        return mBigImageUrl;
    }

    public void setBigImageUrl(String bigImageUrl) {
        mBigImageUrl = bigImageUrl;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }
}

//        "smallImage": "http://mama-studio.com/tt/imgs/tt_event1.png",
//        "bigImage": "http://mama-studio.com/tt/imgs/tt_event1_big.png",
//        "latitude": "9.932510",
//        "longitude": "-84.092154"