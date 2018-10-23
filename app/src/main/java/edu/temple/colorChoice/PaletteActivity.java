package edu.temple.colorChoice;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import edu.temple.worksheet3.R;

public class PaletteActivity extends AppCompatActivity implements chosenColor {


    FragmentManager fm = getSupportFragmentManager();
    ChoiceFragment cf;

    boolean singlePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        singlePane = findViewById(R.id.canvas) == null;
        cf = new ChoiceFragment();

        fm.beginTransaction()
                .replace(R.id.choice, new ChoiceFragment())
                .addToBackStack(null)
                .commit();

    }


    @Override
    public void selectColor(int position) {

        singlePane = findViewById(R.id.canvas) == null;

        if (!singlePane) {

            fm.beginTransaction()
                    .replace(R.id.canvas, new CanvasFragment()
                            .newInstance(Color.parseColor(getResources()
                                    .getStringArray(R.array.hexColor)[position])))
                    .addToBackStack(null)
                    .commit();
        } else {

            fm.beginTransaction()
                    .replace(R.id.choice, new CanvasFragment()
                            .newInstance(Color.parseColor(getResources()
                                    .getStringArray(R.array.hexColor)[position])))
                    .addToBackStack(null)
                    .commit();

        }
    }
}
