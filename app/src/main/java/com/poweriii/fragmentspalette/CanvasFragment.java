package com.poweriii.fragmentspalette;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    View v;

    public CanvasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedData) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_canvas, container, false);

        Bundle args = getArguments();
        if( args != null && args.get("COLOR") != null ){
            String clr = args.get("COLOR").toString();
            v.setBackgroundColor(Color.parseColor(clr));
        }

        return v;
    }


    public void updateColor( String color_str ){
        v.setBackgroundColor(Color.parseColor(color_str));
    }
}
