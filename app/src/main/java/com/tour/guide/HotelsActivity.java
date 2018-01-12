/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tour.guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class HotelsActivity extends android.support.v4.app.Fragment {

    public HotelsActivity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        final ArrayList<Places> hotelsPlaces = new ArrayList<>();
        hotelsPlaces.add(new Places(getString(R.string.hotel1)
                , getString(R.string.hotel1Address)
                , getResources().getString(R.string.hotel1description)
                , R.drawable.hotel1
                , "43.646257, -79.409191"
                , 3.9
                , getString(R.string.hotel1phone)
                , R.drawable.hotel1));

        hotelsPlaces.add(new Places(getString(R.string.hotel2)
                , getString(R.string.hotel2Address)
                , getResources().getString(R.string.hotel2description)
                , R.drawable.hotel2
                , "43.646257, -79.409191"
                , 3.9
                , getString(R.string.hotel2phone)
                , R.drawable.hotel2));

        hotelsPlaces.add(new Places(getString(R.string.hotel3)
                , getString(R.string.hotel3Address)
                , getResources().getString(R.string.hotel3description)
                , R.drawable.hotel3
                , "43.646257, -79.409191"
                , 3.9
                , getString(R.string.hotel3phone)
                , R.drawable.hotel3));


        PlacesAdapter adapter = new PlacesAdapter(getActivity(), hotelsPlaces);
        ListView listView = rootView.findViewById(R.id.fragment_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentHotels = new Intent(getActivity(), AllPlacesActivity.class);

                Places hotels = hotelsPlaces.get(position);

                Bundle bundle = new Bundle();
                bundle.putString(Keys.PLACE_NAME_KEY, hotels.getPlacesName());
                bundle.putString(Keys.PLACE_DETAIL_KEY, hotels.getPlacesDescription());
                bundle.putString(Keys.PLACE_ADDRESS_KEY, hotels.getPlacesAddress());
                bundle.putString(Keys.PLACE_LOCATION_KEY, hotels.getLocationId());
                bundle.putInt(Keys.PLACE_IMAGE_KEY, hotels.getImageResourceId());
                bundle.putDouble(Keys.PLACE_RATING_KEY, hotels.getPlacesRating());
                bundle.putString(Keys.PLACE_PHONE_NUMBER_KEY, hotels.getPlacesPhoneNumber());

                bundle.putInt(Keys.FRAGMENT_PLACE, 1);
                intentHotels.putExtras(bundle);

                startActivity(intentHotels);
            }
        });

        return rootView;
    }
}
