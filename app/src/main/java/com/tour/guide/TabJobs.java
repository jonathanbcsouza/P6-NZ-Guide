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
import android.support.design.widget.Snackbar;
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


public class TabJobs extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener {

    public TabJobs() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_layout_spinner, container, false);


        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner_jobs);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_cities, R.layout.spinner_custom_sleep_tab);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(this);

        return rootView;
    }

    public void createList(String site, int icon, String desc, String url) {
        final ArrayList<Items> jobItens = new ArrayList<>();
        jobItens.add(new Items(site
                , icon
                , desc
                , url));

        SleepAdapter adapter = new SleepAdapter(getActivity(), jobItens);
        ListView listView = getActivity().findViewById(R.id.jobs_list);
        listView.setAdapter(adapter);

    }

    public void passUrl(String site) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
        startActivity(browserIntent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String getValue = (String) parent.getItemAtPosition(position);

        switch (position) {
            case 0:

                Snackbar.make(getView(), "Changed to: " + getValue, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                createList("a", R.drawable.facebook, "c", ".com");

                break;

            case 1:
                Snackbar.make(getView(), "Changed to: " + getValue, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                break;

            case 2:
                Snackbar.make(getView(), "Changed to: " + getValue, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
