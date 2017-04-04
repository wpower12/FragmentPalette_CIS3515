package com.poweriii.fragmentspalette;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {

    ArrayList<String> colors;
    boolean first;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("palfrag: ", "creating view");
        first = true;
        colors = new ArrayList<>();
        colors.add("Red");
        colors.add("White");
        colors.add("Blue");
        colors.add("Green");

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        Spinner spinner = (Spinner) v.findViewById( R.id.spinner );
        PaletteAdapter pa = new PaletteAdapter( v.getContext(), colors );
        spinner.setAdapter( pa );

        spinner.setOnItemSelectedListener( new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    if( first ){
                        first = false;
                    } else {
                        // Need to send basically just the position to the other fragment.
                        ((PaletteInterface)getActivity()).sendColor(colors.get(position));
                    }
                } catch (Exception e ){

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );
        return v;
    }

    public interface PaletteInterface {
        public void sendColor( String c_str );
    }
}
