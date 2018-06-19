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
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_itens, parent, false);
        }

        Categories currentAucklandTour = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.list_item_title);
        nameTextView.setText(currentAucklandTour.getItemTitle());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.list_item_description);
        numberTextView.setText(currentAucklandTour.getItemDescription());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_image);

        iconView.setImageResource(currentAucklandTour.getItemImage());

        return listItemView;
    }

}

