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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class TabJobs extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener {

    public TabJobs() {
    }

    private final ArrayList<Items> jobsArray = new ArrayList<>();
    private int icon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_layout_spinner, container, false);

        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner_jobs);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_jobs_categories, R.layout.spinner_custom_sleep_tab);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(this);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final String getValue = (String) parent.getItemAtPosition(position);
        icon = R.drawable.ic_keyboard_arrow_right_black_24dp;

        switch (position) {
            case 0: //Construction
                jobsArray.clear();
                createArray(getValue, icon, getString(R.string.category0), getString(R.string.const0));
                createArray(getValue, icon, getString(R.string.category1), getString(R.string.const1));
                createArray(getValue, icon, getString(R.string.category0), getString(R.string.const2));
                createArray(getValue, icon, getString(R.string.category1), getString(R.string.const3));
                createArray(getValue, icon, getString(R.string.category0), getString(R.string.const4));
                createArray(getValue, icon, getString(R.string.category0), getString(R.string.const5));
                createArray(getValue, icon, getString(R.string.category0), getString(R.string.const7));
                break;

            case 1: //Hospitality
                jobsArray.clear();
                createArray(getValue, icon, getString(R.string.category0), getString(R.string.hosp0));
                break;

            case 2: // Cleaning
                jobsArray.clear();
                createArray(getValue, icon, getString(R.string.category1), getString(R.string.clean0));
                createArray(getValue, icon, getString(R.string.category1), getString(R.string.clean1));
                createArray(getValue, icon, getString(R.string.category1), getString(R.string.clean2));
                break;

            case 3: //General
                jobsArray.clear();
                createArray(getValue, icon, getString(R.string.category2), getString(R.string.gen0));
                createArray(getValue, icon, getString(R.string.category2), getString(R.string.gen1));
                break;

        }
        final SleepAdapter adapter = new SleepAdapter(getActivity(), jobsArray);
        final ListView listView = getActivity().findViewById(R.id.jobs_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Items jobs = jobsArray.get(position);
                passUrl(jobs.getPlacesPhoneNumber());

            }
        });
    }

    public void createArray(String value, int icon, String site, String siteDesc) {

        Snackbar.make(getView(), "Changed to: " + value, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        jobsArray.add(new Items(site
                , icon
                , siteDesc));
    }

    public void passUrl(String site) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
        startActivity(browserIntent);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
