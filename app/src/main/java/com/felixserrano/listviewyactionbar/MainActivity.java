package com.felixserrano.listviewyactionbar;

import android.app.ListActivity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends ListActivity {

    int longitud = 6;
    private static final String[] items = {"En", "un", "lugar", "de",
            "la", "Mancha", "de", "cuyo", "nombre", "no", "quiero",
            "acordarme", "no", "ha", "mucho", "tiempo", "que",
            "vivía", "un", "hidalgo", "de", "los", "de", "lanza",
            "en", "astillero", "adarga", "antigua", "rocín", "flaco",
            "y", "galgo", "corredor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        Arrays.copyOf(items,longitud));
        setListAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return (super.onCreateOptionsMenu(menu));
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        ArrayAdapter<String> arrayAdapter;
        switch (item.getItemId())
        {
            case R.id.anyadir:
                longitud++;
                arrayAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        Arrays.copyOf(items,longitud));
                setListAdapter(arrayAdapter);
                break;
            case R.id.reset:
                longitud = 6;
                 arrayAdapter =
                        new ArrayAdapter<String>(this,
                                android.R.layout.simple_list_item_1,
                                Arrays.copyOf(items,longitud));
                setListAdapter(arrayAdapter);
                break;
            case R.id.acercade:
                Toast.makeText(this,getString(R.string.mensaje),Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
