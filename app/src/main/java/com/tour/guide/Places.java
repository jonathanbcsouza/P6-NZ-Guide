package com.tour.guide;

/**
 * Created by jonat on 5/01/2018.
 */

public class Places {

    private static final String NO_PHONE_NUMBER = "0";
    private String mPlacesName;
    private String mPlacesAddress;
    private String mPlacesDescription;
    private int mImageResourceId;
    private String mLocationId;
    private double mPlacesRating;
    private String mPlacesPhoneNumber = NO_PHONE_NUMBER;
    private int mThumbnailResourceId;

    public Places(String attractionName
            , String attractionAddress
            , String attractionDescription
            , int imageResourceId
            , String locationId
            , double attractionRating
            , int thumbnailResourceID) {
        mPlacesName = attractionName;
        mPlacesAddress = attractionAddress;
        mPlacesDescription = attractionDescription;
        mImageResourceId = imageResourceId;
        mLocationId = locationId;
        mPlacesRating = attractionRating;
        mThumbnailResourceId = thumbnailResourceID;
    }


    public Places(String attractionName
            , String attractionAddress
            , String attractionDescription
            , int imageResourceId
            , String locationId
            , double attractionRating
            , String attractionPhoneNumber, int thumbnailResourceId) {
        mPlacesName = attractionName;
        mPlacesAddress = attractionAddress;
        mPlacesDescription = attractionDescription;
        mImageResourceId = imageResourceId;
        mLocationId = locationId;
        mPlacesRating = attractionRating;
        mPlacesPhoneNumber = attractionPhoneNumber;
        mThumbnailResourceId = thumbnailResourceId;
    }


    public String getPlacesName() {
        return mPlacesName;
    }


    public String getPlacesAddress() {
        return mPlacesAddress;
    }


    public String getPlacesDescription() {
        return mPlacesDescription;
    }


    public int getImageResourceId() {
        return mImageResourceId;
    }


    public String getLocationId() {
        return mLocationId;
    }


    public double getPlacesRating() {
        return mPlacesRating;
    }


    public String getPlacesPhoneNumber() {
        return mPlacesPhoneNumber;
    }


    public boolean hasPhoneNumber() {
        return !(mPlacesPhoneNumber.equals(NO_PHONE_NUMBER));
    }


    public int getThubmnailResourceId() {
        return mThumbnailResourceId;
    }
}
