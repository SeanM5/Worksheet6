package edu.temple.colorChoice;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import edu.temple.worksheet3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    public int color;
    public static String COLOR_KEY = "color";
    public View v;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        this.color = bundle.getInt(COLOR_KEY);

    }

    public static CanvasFragment newInstance(int color){
        CanvasFragment canvasFragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(CanvasFragment.COLOR_KEY, color);
        canvasFragment.setArguments(bundle);
        return canvasFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_canvas, container, false);

        v.setBackgroundColor(this.color);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onDetach() {
        super.onDetach();


    }
}
