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
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TabSleep extends android.support.v4.app.Fragment {

    public TabSleep() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_layout, container, false);

        final ArrayList<Items> sleepItems = new ArrayList<>();
        sleepItems.add(new Items(getString(R.string.site0)
                , R.drawable.trademe
                , getString(R.string.site_short_desc_0)));

        sleepItems.add(new Items(getString(R.string.site1)
                , R.drawable.airbnb
                , getString(R.string.site_short_desc_1)));

        sleepItems.add(new Items(getString(R.string.site2)
                , R.drawable.facebook
                , getString(R.string.site_short_desc_2)));


        SleepAdapter adapter = new SleepAdapter(getActivity(), sleepItems);
        ListView listView = rootView.findViewById(R.id.fragment_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    passUrl("http://trademe.co.nz");

                } else if (position == 1) {
                    passUrl("http://airbnb.co.nz/c/jonathans11889");

                }
                passUrl("https://www.facebook.com/search/top/?q=New%20Zealand%20-%20flatmate%20wanted");
            }
        });

        return rootView;
    }

    public void passUrl(String site) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
        startActivity(browserIntent);
    }
}
