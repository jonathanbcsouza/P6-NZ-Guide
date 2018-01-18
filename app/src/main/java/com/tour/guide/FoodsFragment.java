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


public class FoodsFragment extends android.support.v4.app.Fragment {

    public FoodsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);


        final ArrayList<Places> foodsPlaces = new ArrayList<>();
        foodsPlaces.add(new Places(getString(R.string.restaurant1)
                , getString(R.string.restaurant1Address)
                , getResources().getString(R.string.restaurant1Description)
                , R.drawable.restaurant1
                , getString(R.string.restaurant_location_1)
                , 4.9
                , getString(R.string.restaurant1phone)
                , R.drawable.restaurant1));

        foodsPlaces.add(new Places(getString(R.string.restaurant2)
                , getString(R.string.restaurant2Address)
                , getResources().getString(R.string.restaurant2Description)
                , R.drawable.restaurant2
                , getString(R.string.restaurant_location_2)
                , 4.9
                , getString(R.string.restaurant2phone)
                , R.drawable.restaurant2));

        foodsPlaces.add(new Places(getString(R.string.restaurant3)
                , getString(R.string.restaurant3Address)
                , getResources().getString(R.string.restaurant3Description)
                , R.drawable.restaurant3
                , getString(R.string.restaurant_location_3)
                , 4.9
                , getString(R.string.restaurant3phone)
                , R.drawable.restaurant3));

        foodsPlaces.add(new Places(getString(R.string.restaurant4)
                , getString(R.string.restaurant4Address)
                , getResources().getString(R.string.restaurant4Description)
                , R.drawable.restaurant4
                , getString(R.string.restaurant_location_4)
                , 4.9
                , getString(R.string.restaurant4phone)
                , R.drawable.restaurant4));

        foodsPlaces.add(new Places(getString(R.string.restaurant5)
                , getString(R.string.restaurant5Address)
                , getResources().getString(R.string.restaurant5Description)
                , R.drawable.restaurant5
                , getString(R.string.restaurant_location_5)
                , 4.9
                , getString(R.string.restaurant5phone)
                , R.drawable.restaurant5));

        foodsPlaces.add(new Places(getString(R.string.restaurant6)
                , getString(R.string.restaurant6Address)
                , getResources().getString(R.string.restaurant6Description)
                , R.drawable.restaurant6
                , getString(R.string.restaurant_location_6)
                , 4.9
                , getString(R.string.restaurant6phone)
                , R.drawable.restaurant6));

        foodsPlaces.add(new Places(getString(R.string.restaurant7)
                , getString(R.string.restaurant7Address)
                , getResources().getString(R.string.restaurant7Description)
                , R.drawable.restaurant7
                , getString(R.string.restaurant_location_7)
                , 4.9
                , getString(R.string.restaurant7phone)
                , R.drawable.restaurant7));

        foodsPlaces.add(new Places(getString(R.string.restaurant8)
                , getString(R.string.restaurant8Address)
                , getResources().getString(R.string.restaurant8Description)
                , R.drawable.restaurant8
                , getString(R.string.restaurant_location_8)
                , 4.9
                , getString(R.string.restaurant8phone)
                , R.drawable.restaurant8));

        foodsPlaces.add(new Places(getString(R.string.restaurant9)
                , getString(R.string.restaurant9Address)
                , getResources().getString(R.string.restaurant9Description)
                , R.drawable.restaurant9
                , getString(R.string.restaurant_location_9)
                , 4.9
                , getString(R.string.restaurant9phone)
                , R.drawable.restaurant9));

        foodsPlaces.add(new Places(getString(R.string.restaurant10)
                , getString(R.string.restaurant10Address)
                , getResources().getString(R.string.restaurant10Description)
                , R.drawable.restaurant10
                , getString(R.string.restaurant_location_10)
                , 4.9
                , getString(R.string.restaurant10phone)
                , R.drawable.restaurant10));

        foodsPlaces.add(new Places(getString(R.string.restaurant11)
                , getString(R.string.restaurant11Address)
                , getResources().getString(R.string.restaurant11Description)
                , R.drawable.restaurant11
                , getString(R.string.restaurant_location_11)
                , 4.9
                , getString(R.string.restaurant11phone)
                , R.drawable.restaurant11));


        PlacesAdapter adapter = new PlacesAdapter(getActivity(), foodsPlaces);
        ListView listView = rootView.findViewById(R.id.fragment_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentHotels = new Intent(getActivity(), AllPlacesActivity.class);

                Places hotels = foodsPlaces.get(position);

                Bundle bundle = new Bundle();
                bundle.putString(Keys.PLACE_NAME_KEY, hotels.getPlacesName());
                bundle.putString(Keys.PLACE_ADDRESS_KEY, hotels.getPlacesAddress());
                bundle.putString(Keys.PLACE_DETAIL_KEY, hotels.getPlacesDescription());
                bundle.putInt(Keys.PLACE_IMAGE_KEY, hotels.getImageResourceId());
                bundle.putString(Keys.PLACE_LOCATION_KEY, hotels.getLocationId());
                bundle.putDouble(Keys.PLACE_RATING_KEY, hotels.getPlacesRating());
                bundle.putString(Keys.PLACE_PHONE_NUMBER_KEY, hotels.getPlacesPhoneNumber());

                bundle.putInt(Keys.FRAGMENT_PLACE, 3);
                intentHotels.putExtras(bundle);

                startActivity(intentHotels);
            }
        });

        return rootView;
    }
}
