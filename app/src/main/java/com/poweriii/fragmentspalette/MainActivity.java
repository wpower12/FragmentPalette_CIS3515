package com.poweriii.fragmentspalette;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity implements PaletteFragment.PaletteInterface {

    CanvasFragment cf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment( new PaletteFragment(), R.id.frag1);
        cf = new CanvasFragment();
        addFragment( cf, R.id.frag2 );
    }

    private void addFragment(Fragment f, int id ){
        getFragmentManager()
                .beginTransaction()
                .replace(id, f)
                .commit();
    }

    @Override
    public void sendColor(String color_str) {
        cf.updateColor(color_str);
    }
}
