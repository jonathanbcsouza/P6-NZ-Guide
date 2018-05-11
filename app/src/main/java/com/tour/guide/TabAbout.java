package com.tour.guide;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class TabAbout extends Fragment implements AdapterView.OnItemSelectedListener {

    private TextView city;
    private TextView population;
    private TextView airport;
    private TextView transport;
    private TextView aboutTheCity;
    private ImageView photoCity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.about_layout, container, false);

        city = rootView.findViewById(R.id.city);
        population = rootView.findViewById(R.id.population);
        airport = rootView.findViewById(R.id.airport);
        transport = rootView.findViewById(R.id.transport);
        aboutTheCity = rootView.findViewById(R.id.description_city);
        photoCity = rootView.findViewById(R.id.city_photo);

        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner_sleeps);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_cities, R.layout.spinner_custom_sleep_tab);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(this);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String getValue = (String) parent.getItemAtPosition(position);

        switch (position) {
            case 0:

                Snackbar.make(getView(), "Changed to: " + getValue, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                city.setText(getString(R.string.city_0));
                population.setText(getString(R.string.population_0));
                airport.setText(getString(R.string.airports_0));
                transport.setText(getString(R.string.transports_0));
                aboutTheCity.setText(getString(R.string.about_city_0));
                photoCity.setImageResource(R.mipmap.auckland);
                break;

            case 1:
                Snackbar.make(getView(), "Changed to: " + getValue, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                city.setText(getString(R.string.city_1));
                population.setText(getString(R.string.population_1));
                airport.setText(getString(R.string.airports_1));
                transport.setText(getString(R.string.transports_1));
                aboutTheCity.setText(getString(R.string.about_city_1));
                photoCity.setImageResource(R.drawable.wellington);
                break;

            case 2:
                Snackbar.make(getView(), "Changed to: " + getValue, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                city.setText(getString(R.string.city_2));
                population.setText(getString(R.string.population_2));
                airport.setText(getString(R.string.airports_2));
                transport.setText(getString(R.string.transports_2));
                aboutTheCity.setText(getString(R.string.about_city_2));
                photoCity.setImageResource(R.drawable.christchurch);
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
