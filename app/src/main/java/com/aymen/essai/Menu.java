package com.aymen.essai;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Menu extends AppCompatActivity {
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 0, 0, "Ajouter");
        menu.add(0, 1, 0, "Afficher");
        menu.add(0, 2, 0, "List Personne");
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                setTitle("Ajouter");
                fragment = new FragmentOne();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction f = fm.beginTransaction();
                f.replace(R.id.fragmentone, fragment);
                f.commit();
                break;
            case 1:
                setTitle("Afficher");
                fragment = new FragmentTwo();
                Bundle bundle = new Bundle();
                bundle.putString("donne1", "Contenu from Activity");
                fragment.setArguments(bundle);
                fm = getFragmentManager();
                f = fm.beginTransaction();
                f.replace(R.id.fragmentone, fragment);
                f.commit();
                break;
            case 2:
                setTitle("Liste Personne");

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
