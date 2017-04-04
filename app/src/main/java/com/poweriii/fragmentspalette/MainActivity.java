package com.poweriii.fragmentspalette;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements PaletteFragment.PaletteInterface {

    PaletteFragment pf;
    CanvasFragment cf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pf = new PaletteFragment();
        addFragment( pf, R.id.frag1);

        if( findViewById(R.id.frag2) != null ){
            Log.d("Main: ", "Creating the canvas fragment");
            cf = new CanvasFragment();
            addFragment( cf, R.id.frag2 );
        }

    }

    private void addFragment(Fragment f, int id ){
        getFragmentManager()
                .beginTransaction()
                .replace(id, f)
                .commit();
    }

    @Override
    public void sendColor(String color_str) {
        // If in portrait, swap out the
        if( findViewById(R.id.frag2) == null ){
            cf = new CanvasFragment();
            Bundle data = new Bundle();
            data.putString("COLOR", color_str);
            cf.setArguments( data );
            addFragment(cf, R.id.frag1);
        } else {
            cf.updateColor(color_str);
        }
    }
}
