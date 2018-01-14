package com.tour.guide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SightsFragment extends android.support.v4.app.Fragment {

    public SightsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        final ArrayList<Places> sightsPlaces = new ArrayList<>();
        sightsPlaces.add(new Places(getString(R.string.sight1)
                , getString(R.string.sight1Address)
                , getResources().getString(R.string.sight1description)
                , R.drawable.sight1
                , "-36.8484437,174.7600023,17z"
                , 5
                , getString(R.string.sight1phone)
                , R.drawable.sight1));

        sightsPlaces.add(new Places(getString(R.string.sight2)
                , getString(R.string.sight2Address)
                , getResources().getString(R.string.sight2description)
                , R.drawable.sight2
                , "-37.0136954,174.5542605,11z"
                , 4.2
                , "+64 9 365 9918 - Tourist Information"
                , R.drawable.sight2));

        sightsPlaces.add(new Places(getString(R.string.sight3)
                , getString(R.string.sight3Address)
                , getResources().getString(R.string.sight3description)
                , R.drawable.sight3
                , "-36.8429654,174.7559422,16z"
                , 4
                , "+64 9 365 9918 - Tourist Information"
                , R.drawable.sight3));

        sightsPlaces.add(new Places(getString(R.string.sight4)
                , getString(R.string.sight4Address)
                , getResources().getString(R.string.sight3description)
                , R.drawable.sight4
                , "-36.899982,174.7745785,15z"
                , 4
                , getString(R.string.sight4phone)
                , R.drawable.sight4));

        sightsPlaces.add(new Places(getString(R.string.sight5)
                , getString(R.string.sight5Address)
                , getResources().getString(R.string.sight3description)
                , R.drawable.sight5
                , "-36.8270751,174.8096291,17z"
                , 4
                , getString(R.string.sight5phone)
                , R.drawable.sight5));

        sightsPlaces.add(new Places(getString(R.string.sight6)
                , getString(R.string.sight6Address)
                , getResources().getString(R.string.sight3description)
                , R.drawable.sight6
                , "-36.8505695,174.7304198,15z"
                , 4
                , getString(R.string.sight6phone)
                , R.drawable.sight6));

        sightsPlaces.add(new Places(getString(R.string.sight7)
                , getString(R.string.sight7Address)
                , getResources().getString(R.string.sight3description)
                , R.drawable.sight7
                , "-36.8556312,174.770044,14z"
                , 4
                , getString(R.string.sight7phone)
                , R.drawable.sight7));

        sightsPlaces.add(new Places(getString(R.string.sight8)
                , getString(R.string.sight8Address)
                , getResources().getString(R.string.sight3description)
                , R.drawable.sight8
                , "-36.9074857,174.9005203,17z"
                , 4
                , getString(R.string.sight8phone)
                , R.drawable.sight8));

        sightsPlaces.add(new Places(getString(R.string.sight9)
                , getString(R.string.sight9Address)
                , getResources().getString(R.string.sight3description)
                , R.drawable.sight9
                , "-36.8508956,174.7623284,17z"
                , 4
                , getString(R.string.sight9phone)
                , R.drawable.sight9));

        sightsPlaces.add(new Places(getString(R.string.sight10)
                , getString(R.string.sight10Address)
                , getResources().getString(R.string.sight3description)
                , R.drawable.sight10
                , "-36.8429846,174.7647521,17z"
                , 4
                , getString(R.string.sight10phone)
                , R.drawable.sight10));


        PlacesAdapter adapter = new PlacesAdapter(getActivity(), sightsPlaces);
        ListView listView = rootView.findViewById(R.id.fragment_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intentSights = new Intent(getActivity(), AllPlacesActivity.class);

                Places sights = sightsPlaces.get(position);

                Bundle bundle = new Bundle();
                bundle.putString(Keys.PLACE_NAME_KEY, sights.getPlacesName());
                bundle.putString(Keys.PLACE_ADDRESS_KEY, sights.getPlacesAddress());
                bundle.putString(Keys.PLACE_DETAIL_KEY, sights.getPlacesDescription());
                bundle.putInt(Keys.PLACE_IMAGE_KEY, sights.getImageResourceId());
                bundle.putString(Keys.PLACE_LOCATION_KEY, sights.getLocationId());
                bundle.putDouble(Keys.PLACE_RATING_KEY, sights.getPlacesRating());
                bundle.putString(Keys.PLACE_PHONE_NUMBER_KEY, sights.getPlacesPhoneNumber());

                bundle.putInt(Keys.FRAGMENT_PLACE, 0);
                intentSights.putExtras(bundle);

                startActivity(intentSights);
            }
        });

        return rootView;
    }
}
