package com.tour.guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TabSights extends android.support.v4.app.Fragment {

    public TabSights() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_layout, container, false);

        final ArrayList<Items> sightsPlaces = new ArrayList<>();
        sightsPlaces.add(new Items(getString(R.string.sight1)
                , getString(R.string.sight1Address)
                , getResources().getString(R.string.sight1description)
                , R.mipmap.sight1
                , getString(R.string.sights_location_1)
                , 5
                , getString(R.string.sight1phone)
                , R.mipmap.sight1));

        sightsPlaces.add(new Items(getString(R.string.sight2)
                , getString(R.string.sight2Address)
                , getResources().getString(R.string.sight2description)
                , R.mipmap.sight2
                , getString(R.string.sights_location_2)
                , 4.2
                , getString(R.string.sight2phone) + getString(R.string.tourist_information)
                , R.mipmap.sight2));

        sightsPlaces.add(new Items(getString(R.string.sight3)
                , getString(R.string.sight3Address)
                , getResources().getString(R.string.sight3description)
                , R.mipmap.sight3
                , getString(R.string.sights_location_3)
                , 4
                , getString(R.string.sight3phone) + getString(R.string.tourist_information)
                , R.mipmap.sight3));

        sightsPlaces.add(new Items(getString(R.string.sight4)
                , getString(R.string.sight4Address)
                , getResources().getString(R.string.sight3description)
                , R.mipmap.sight4
                , getString(R.string.sights_location_4)
                , 4
                , getString(R.string.sight4phone)
                , R.mipmap.sight4));

        sightsPlaces.add(new Items(getString(R.string.sight5)
                , getString(R.string.sight5Address)
                , getResources().getString(R.string.sight3description)
                , R.mipmap.sight5
                , getString(R.string.sights_location_5)
                , 4
                , getString(R.string.sight5phone)
                , R.mipmap.sight5));
        
        sightsPlaces.add(new Items(getString(R.string.sight8)
                , getString(R.string.sight8Address)
                , getResources().getString(R.string.sight3description)
                , R.mipmap.sight8
                , getString(R.string.sights_location_8)
                , 4
                , getString(R.string.sight8phone)
                , R.mipmap.sight8));

        sightsPlaces.add(new Items(getString(R.string.sight9)
                , getString(R.string.sight9Address)
                , getResources().getString(R.string.sight3description)
                , R.mipmap.sight9
                , getString(R.string.sights_location_9)
                , 4
                , getString(R.string.sight9phone)
                , R.mipmap.sight9));

        sightsPlaces.add(new Items(getString(R.string.sight10)
                , getString(R.string.sight10Address)
                , getResources().getString(R.string.sight3description)
                , R.mipmap.sight10
                , getString(R.string.sights_location_10)
                , 4
                , getString(R.string.sight10phone)
                , R.mipmap.sight10));

        ItemsAdapter adapter = new ItemsAdapter(getActivity(), sightsPlaces);
        ListView listView = rootView.findViewById(R.id.fragment_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intentSights = new Intent(getActivity(), AllPlacesActivity.class);

                Items sights = sightsPlaces.get(position);

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
