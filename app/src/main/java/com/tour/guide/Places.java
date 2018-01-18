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

    public Places(String placesName
            , String placesAddress
            , String placesDescription
            , int imageResourceId
            , String locationId
            , double placesRating
            , int thumbnailResourceID) {
        mPlacesName = placesName;
        mPlacesAddress = placesAddress;
        mPlacesDescription = placesDescription;
        mImageResourceId = imageResourceId;
        mLocationId = locationId;
        mPlacesRating = placesRating;
        mThumbnailResourceId = thumbnailResourceID;
    }

    public Places(String placesName
            , String placesAddress
            , String placesDescription
            , int imageResourceId
            , String locationId
            , double placesRating
            , String placesPhoneNumber, int thumbnailResourceId) {
        mPlacesName = placesName;
        mPlacesAddress = placesAddress;
        mPlacesDescription = placesDescription;
        mImageResourceId = imageResourceId;
        mLocationId = locationId;
        mPlacesRating = placesRating;
        mPlacesPhoneNumber = placesPhoneNumber;
        mThumbnailResourceId = thumbnailResourceId;
    }


    public String   getPlacesName() {
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
