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

public class PlacesAdapter extends ArrayAdapter<Places> {

    PlacesAdapter(Context context, ArrayList<Places> attraction) {
        super(context, 0, attraction);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_itens, parent, false);
        }

        // Get the Attraction object located at this position in the list
        Places currentPlace = getItem(position);

        // Find the ImageView in list_item.xml by Id for displaying attraction thumbnail
        ImageView placeImage = listItemView.findViewById(R.id.list_item_image);
        assert currentPlace != null;
        placeImage.setImageResource(currentPlace.getThubmnailResourceId());

        // Find the TextView in list_item.xml by Id for displaying attraction name
        TextView placeName = listItemView.findViewById(R.id.list_item_title);
        // Get the name from attractionName object
        // Set the attraction name on TextView
        placeName.setText(currentPlace.getPlacesName());

        // Find the TextView in list_item.cml by id for displaying attraction address or phone number
        TextView placeAddress = listItemView.findViewById(R.id.list_item_item_description);
        // If current Attraction object has a phone number then, display phone number and change
        // the text color to color accent
        if (currentPlace.hasPhoneNumber()) {
            placeAddress.setText(currentPlace.getPlacesPhoneNumber());
            placeAddress.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        } else {
            // If current Attraction object has not a phone number then, display address and change
            // the text color to secondary color
            placeAddress.setText(currentPlace.getPlacesAddress());
            placeAddress.setTextColor(ContextCompat.getColor(getContext(), R.color.secondaryTextColor));
        }

        return listItemView;
    }
}