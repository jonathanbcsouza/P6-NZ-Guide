package com.tour.guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class AllPlacesActivity extends AppCompatActivity {

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_places);

        bundle = getIntent().getExtras();

        assert bundle != null;
        int identifier = bundle.getInt(Keys.FRAGMENT_PLACE);
        switch (identifier) {
            case 0:
                setTitle(getString(R.string.sights));
                break;
            case 1:
                setTitle(getString(R.string.sleep));
                break;
            case 2:
                setTitle(R.string.jobs);
                break;
        }


        View phoneIcon = findViewById(R.id.place_phone_icon_layout);
        View phoneNumberInContactSection = findViewById(R.id.allPlaces_activity_phone_number_layout);

        TextView addressTitle = findViewById(R.id.address_text);

        if (bundle.containsKey(Keys.PLACE_PHONE_NUMBER_KEY)) {
            phoneIcon.setVisibility(View.VISIBLE);
            phoneNumberInContactSection.setVisibility(View.VISIBLE);
            addressTitle.setText(getString(R.string.contact_title));

            showPhoneNumberAndMakeCall();
        } else {

            phoneIcon.setVisibility(View.GONE);
            phoneNumberInContactSection.setVisibility(View.GONE);
            addressTitle.setText(getString(R.string.address_title));
        }

        ImageView placeImage = findViewById(R.id.place_image);
        placeImage.setImageResource(bundle.getInt(Keys.PLACE_IMAGE_KEY));

        TextView placeDescription = findViewById(R.id.allPlaces_activity_attraction_description);
        placeDescription.setText(bundle.getString(Keys.PLACE_DETAIL_KEY));

        TextView placeName = findViewById(R.id.place_name);
        placeName.setText(bundle.getString(Keys.PLACE_NAME_KEY));

        TextView placeAddress = findViewById(R.id.detail_activity_place_address);
        placeAddress.setText(bundle.getString(Keys.PLACE_ADDRESS_KEY));

        TextView ratingText = findViewById(R.id.place_rating_text);
        ratingText.setText(String.valueOf(bundle.getDouble(Keys.PLACE_RATING_KEY)));

        RatingBar ratingBar = findViewById(R.id.place_rating_bar);
        ratingBar.setRating((float) bundle.getDouble(Keys.PLACE_RATING_KEY));

        LinearLayout openMaps = findViewById(R.id.detail_activity_take_me_to_location);
        openMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getMapsURIString(bundle.getString(Keys.PLACE_LOCATION_KEY))));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }


    private String getMapsURIString(String locationId) {
        String[] latitudeAndLongitude = locationId.split(",");
        String latitude = latitudeAndLongitude[0];
        String longitude = latitudeAndLongitude[1];
        return "geo:" + latitude + "," + longitude
                + "?q=<" + latitude + ">,<" + longitude + ">,("
                + bundle.getString(Keys.PLACE_NAME_KEY) + ")";
    }

    private void showPhoneNumberAndMakeCall() {
        TextView phoneNumber = findViewById(R.id.detail_activity_place_phone_number);
        phoneNumber.setText(bundle.getString(Keys.PLACE_PHONE_NUMBER_KEY));

        ImageView callIcon = findViewById(R.id.place_phone_icon);
        callIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = bundle.getString(Keys.PLACE_PHONE_NUMBER_KEY);
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            }
        });
    }
}