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


public class FlatmatesWanted extends android.support.v4.app.Fragment {

    public FlatmatesWanted() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        final ArrayList<Places> flatmatesPlaces = new ArrayList<>();
        flatmatesPlaces.add(new Places(getString(R.string.flatmate1)
                , getString(R.string.flatmate1Address)
                , getResources().getString(R.string.flatmate1Description)
                , R.drawable.flatmate1
                , getString(R.string.flatmate_location_1)
                , 4.9
                , getString(R.string.flatmate1phone)
                , R.drawable.flatmate1));

        flatmatesPlaces.add(new Places(getString(R.string.flatmate2)
                , getString(R.string.flatmate2Address)
                , getResources().getString(R.string.flatmate2Description)
                , R.drawable.flatmate2
                , getString(R.string.flatmate_location_2)
                , 5.0
                , getString(R.string.flatmate2phone)
                , R.drawable.flatmate2));

        flatmatesPlaces.add(new Places(getString(R.string.flatmate3)
                , getString(R.string.flatmate3Address)
                , getResources().getString(R.string.flatmate3Description)
                , R.drawable.flatmate3
                , getString(R.string.flatmate_location_3)
                , 3.5
                , getString(R.string.flatmate3phone)
                , R.drawable.flatmate3));

        flatmatesPlaces.add(new Places(getString(R.string.flatmate4)
                , getString(R.string.flatmate4Address)
                , getResources().getString(R.string.flatmate4Description)
                , R.drawable.flatmate4
                , getString(R.string.flatmate_location_4)
                , 3.9
                , getString(R.string.flatmate4phone)
                , R.drawable.flatmate4));

        flatmatesPlaces.add(new Places(getString(R.string.flatmate5)
                , getString(R.string.flatmate5Address)
                , getResources().getString(R.string.flatmate5Description)
                , R.drawable.flatmate5
                , getString(R.string.flatmate_location_5)
                , 4.9
                , getString(R.string.flatmate5phone)
                , R.drawable.flatmate5));

        flatmatesPlaces.add(new Places(getString(R.string.flatmate6)
                , getString(R.string.flatmate6Address)
                , getResources().getString(R.string.flatmate6Description)
                , R.drawable.flatmate6
                , getString(R.string.flatmate_location_6)
                , 2.9
                , getString(R.string.flatmate6phone)
                , R.drawable.flatmate6));

        flatmatesPlaces.add(new Places(getString(R.string.flatmate7)
                , getString(R.string.flatmate7Address)
                , getResources().getString(R.string.flatmate7Description)
                , R.drawable.flatmate7
                , getString(R.string.flatmate_location_7)
                , 3.9
                , getString(R.string.flatmate7phone)
                , R.drawable.flatmate7));


        PlacesAdapter adapter = new PlacesAdapter(getActivity(), flatmatesPlaces);
        ListView listView = rootView.findViewById(R.id.fragment_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentHotels = new Intent(getActivity(), AllPlacesActivity.class);

                Places flatmates = flatmatesPlaces.get(position);

                Bundle bundle = new Bundle();
                bundle.putString(Keys.PLACE_NAME_KEY, flatmates.getPlacesName());
                bundle.putString(Keys.PLACE_ADDRESS_KEY, flatmates.getPlacesAddress());
                bundle.putString(Keys.PLACE_DETAIL_KEY, flatmates.getPlacesDescription());
                bundle.putInt(Keys.PLACE_IMAGE_KEY, flatmates.getImageResourceId());
                bundle.putString(Keys.PLACE_LOCATION_KEY, flatmates.getLocationId());
                bundle.putDouble(Keys.PLACE_RATING_KEY, flatmates.getPlacesRating());
                bundle.putString(Keys.PLACE_PHONE_NUMBER_KEY, flatmates.getPlacesPhoneNumber());

                bundle.putInt(Keys.FRAGMENT_PLACE, 2);
                intentHotels.putExtras(bundle);

                startActivity(intentHotels);
            }
        });

        return rootView;
    }
}
