package com.tour.guide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jonat on 26/12/2017.
 */

public class CategoriesAdapter extends ArrayAdapter<Categories> {


    private static final String LOG_TAG = CategoriesAdapter.class.getSimpleName();

    public CategoriesAdapter(Activity context, ArrayList<Categories> androidCategories) {

        super(context, 0, androidCategories);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_itens, parent, false);
        }

        // Get the com.tour.guide.Places object located at this position in the list
        Categories currentAucklandTour = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.list_item_title);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentAucklandTour.getItemTitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.list_item_item_description);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentAucklandTour.getItemDescription());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentAucklandTour.getItemImage());

        //ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_image);
        //iconView.setImageResource(currentAucklandTour.getItemImage());



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}

