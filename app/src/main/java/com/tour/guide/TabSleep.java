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
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class TabSleep extends android.support.v4.app.Fragment {

    public TabSleep() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_layout, container, false);

        final ArrayList<Items> sleepItems = new ArrayList<>();
        sleepItems.add(new Items(getString(R.string.accommodation1)
                , getString(R.string.sight1Address)
                , getResources().getString(R.string.accommodation_descr_1)
                , R.mipmap.sight1
                , getString(R.string.sights_location_1)
                , 5
                , getString(R.string.sight1phone)
                , R.mipmap.sight1));

        SleepAdapter adapter = new SleepAdapter(getActivity(), sleepItems);
        ListView listView = rootView.findViewById(R.id.fragment_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intentSleep = new Intent(getActivity(), AllPlacesActivity.class);

                Items hotels = sleepItems.get(position);

                Bundle bundle = new Bundle();
                bundle.putString(Keys.PLACE_NAME_KEY, hotels.getPlacesName());
                bundle.putString(Keys.PLACE_DETAIL_KEY, hotels.getPlacesDescription());
                bundle.putString(Keys.PLACE_ADDRESS_KEY, hotels.getPlacesAddress());
                bundle.putString(Keys.PLACE_LOCATION_KEY, hotels.getLocationId());
                bundle.putInt(Keys.PLACE_IMAGE_KEY, hotels.getImageResourceId());
                bundle.putDouble(Keys.PLACE_RATING_KEY, hotels.getPlacesRating());
                bundle.putString(Keys.PLACE_PHONE_NUMBER_KEY, hotels.getPlacesPhoneNumber());

                bundle.putInt(Keys.FRAGMENT_PLACE, 1);
                intentSleep.putExtras(bundle);

                startActivity(intentSleep);
            }
        });

        return rootView;
    }

}
