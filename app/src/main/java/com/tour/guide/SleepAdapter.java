package com.tour.guide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SleepAdapter extends ArrayAdapter<Items> {

    SleepAdapter(Context context, ArrayList<Items> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_itens, parent, false);
        }

        Items currentPlaces = getItem(position);

        ImageView attractionImage = listItemView.findViewById(R.id.list_item_image);

        assert currentPlaces != null;
        attractionImage.setImageResource(currentPlaces.getThubmnailResourceId());

        TextView attractionName = listItemView.findViewById(R.id.list_item_title);
        attractionName.setText(currentPlaces.getPlacesName());

        TextView attractionAddress = listItemView.findViewById(R.id.list_item_description);

        if (currentPlaces.hasPhoneNumber()) {
            attractionAddress.setText(currentPlaces.getPlacesPhoneNumber());
            attractionAddress.setTextColor(ContextCompat.getColor(getContext(), R.color.tabsSelected));
        } else {

            attractionAddress.setText(currentPlaces.getPlacesAddress());
            attractionAddress.setTextColor(ContextCompat.getColor(getContext(), R.color.itemsSubTitle));
        }

        return listItemView;
    }
}