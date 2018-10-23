package edu.temple.colorChoice;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import edu.temple.worksheet3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends Fragment {

    View v;
    Spinner spin;
    String[] colors;
    private chosenColor parentActivity;

    public ChoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        colors = getResources().getStringArray(R.array.colorArray);

        v = inflater.inflate(R.layout.fragment_choice, container, false);

        spin = v.findViewById(R.id.spin);
        ColorAdapter colorAdapt = new ColorAdapter(getActivity(), colors);

        spin.setAdapter(colorAdapt);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    return;
                } else {

                    parentActivity.selectColor(position - 1);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        parentActivity = (chosenColor) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        parentActivity = null;
    }

    @Override
    public void onStop() {
        super.onStop();
        spin.setSelection(0);
    }
}

interface chosenColor{
    void selectColor(int position);
};
