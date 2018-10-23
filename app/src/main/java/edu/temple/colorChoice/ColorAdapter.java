package edu.temple.colorChoice;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import edu.temple.worksheet3.R;

public class ColorAdapter extends BaseAdapter {

    Context con;
    String[] colors;
    String[] colorCodes;

    public ColorAdapter(Context con, String[] colors) {

        this.con = con;
        this.colors = colors;
        colorCodes = con.getResources().getStringArray(R.array.hexColor);
    }

    @Override
    public int getCount() {
        return colors.length + 1;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView text = new TextView(con);
        if(position == 0){
            text.setText(con.getString(R.string.select));
            text.setTextSize(24);
            text.setGravity(Gravity.CENTER);
        } else {
            text.setText(colors[position - 1]);
            text.setTextSize(24);
            text.setBackgroundColor(Color.parseColor(colorCodes[position - 1]));
            text.setGravity(Gravity.CENTER);

        }
        return text;
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView text = new TextView(con);
        if(position == 0){
            text.setHeight(0);
        } else {
            text.setText(colors[position - 1]);
            text.setTextSize(24);

            text.setBackgroundColor(Color.parseColor(colorCodes[position - 1]));
            text.setGravity(Gravity.CENTER);

        }
        return text;    }
}

