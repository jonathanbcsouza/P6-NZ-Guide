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
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        final ArrayList<Places> flatMatesList = new ArrayList<Places>();
        flatMatesList.add(new Places(getString(R.string.flatmate1)
                , getString(R.string.cn_tower_address)
                , getResources().getString(R.string.cn_tower)
                , R.drawable.auckland
                , "43.642482,-79.387074"
                , 3.5
                , R.drawable.skytower));
        flatMatesList.add(new Places(getString(R.string.flatmate2)
                , getString(R.string.cn_tower_address)
                , getResources().getString(R.string.cn_tower)
                , R.drawable.auckland
                , "43.642482,-79.387074"
                , 3.5
                , R.drawable.skytower));

        PlacesAdapter adapter = new PlacesAdapter(getActivity(), flatMatesList);
        ListView listView = rootView.findViewById(R.id.list_places);
        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity(), AllPlacesActivity.class);

                // Get the {@link Word} object at the given position the user clicked on
                Places hotels = flatMatesList.get(position);

                /** Create a new Bundle to send data to {@link PLACEDetailActivity} */
                Bundle bundle = new Bundle();
                bundle.putString(Keys.PLACE_NAME_KEY, hotels.getPlacesName());
                bundle.putString(Keys.PLACE_ADDRESS_KEY, hotels.getPlacesAddress());
                bundle.putInt(Keys.PLACE_IMAGE_KEY, hotels.getImageResourceId());
                bundle.putString(Keys.PLACE_LOCATION_KEY, hotels.getLocationId());
                bundle.putString(Keys.PLACE_DETAIL_KEY, hotels.getPlacesDescription());
                bundle.putDouble(Keys.PLACE_RATING_KEY, hotels.getPlacesRating());

                bundle.putInt(Keys.FRAGMENT_PLACE, 2);
                intent.putExtras(bundle);

                // start new activity
                startActivity(intent);
            }
        });

        return rootView;
    }
}
