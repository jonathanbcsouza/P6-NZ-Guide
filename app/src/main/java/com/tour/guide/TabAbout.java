package com.tour.guide;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TabAbout extends Fragment implements AdapterView.OnItemSelectedListener {

    private TextView city;
    private TextView population;
    private TextView airport;
    private TextView transport;
    private TextView aboutTheCity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.about_layout, container, false);

        city = rootView.findViewById(R.id.city);
        population = rootView.findViewById(R.id.population);
        airport = rootView.findViewById(R.id.airport);
        transport = rootView.findViewById(R.id.transport);
        aboutTheCity = rootView.findViewById(R.id.description_city);

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

                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_0));
                population.setText(getString(R.string.population_0));
                airport.setText(getString(R.string.airports_0));
                transport.setText(getString(R.string.transports_0));
                aboutTheCity.setText(getString(R.string.about_city_0));
                break;

            case 1:
                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_1));
                population.setText(getString(R.string.population_1));
                airport.setText(getString(R.string.airports_1));
                transport.setText(getString(R.string.transports_1));
                aboutTheCity.setText(getString(R.string.about_city_1));
                break;

            case 2:
                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_2));
                population.setText(getString(R.string.population_2));
                airport.setText(getString(R.string.airports_2));
                transport.setText(getString(R.string.transports_2));
                aboutTheCity.setText(getString(R.string.about_city_2));
                break;
/*
            case 3:
                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_3));
                population.setText(getString(R.string.population_3));
                airport.setText(getString(R.string.airports_3));
                transport.setText(getString(R.string.transports_3));
                aboutTheCity.setText(getString(R.string.about_city_3));
                break;

            case 4:
                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_4));
                population.setText(getString(R.string.population_4));
                airport.setText(getString(R.string.airports_4));
                transport.setText(getString(R.string.transports_4));
                aboutTheCity.setText(getString(R.string.about_city_4));
                break;

            case 5:
                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_5));
                population.setText(getString(R.string.population_5));
                airport.setText(getString(R.string.airports_5));
                transport.setText(getString(R.string.transports_5));
                aboutTheCity.setText(getString(R.string.about_city_5));
                break;

            case 6:
                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_6));
                population.setText(getString(R.string.population_6));
                airport.setText(getString(R.string.airports_6));
                transport.setText(getString(R.string.transports_6));
                aboutTheCity.setText(getString(R.string.about_city_6));
                break;

            case 7:
                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_7));
                population.setText(getString(R.string.population_7));
                airport.setText(getString(R.string.airports_7));
                transport.setText(getString(R.string.transports_7));
                aboutTheCity.setText(getString(R.string.about_city_7));
                break;

            case 8:
                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_8));
                population.setText(getString(R.string.population_8));
                airport.setText(getString(R.string.airports_8));
                transport.setText(getString(R.string.transports_8));
                aboutTheCity.setText(getString(R.string.about_city_8));
                break;

            case 9:
                Toast.makeText(getContext(), "Changed to: " + getValue, Toast.LENGTH_SHORT).show();
                city.setText(getString(R.string.city_9));
                population.setText(getString(R.string.population_9));
                airport.setText(getString(R.string.airports_9));
                transport.setText(getString(R.string.transports_9));
                aboutTheCity.setText(getString(R.string.about_city_9));
                break;
*/
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}

