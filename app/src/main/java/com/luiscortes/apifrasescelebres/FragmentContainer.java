package com.luiscortes.apifrasescelebres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class FragmentContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        if (savedInstanceState == null) {
           Class fragmentClass = (Class) getIntent().getSerializableExtra("fragmentClass");

           try {
               Fragment fragment = (Fragment) fragmentClass.newInstance();
               getSupportFragmentManager().beginTransaction()
                       .replace(R.id.flFragmentContainer, fragment)
                       .commit();

           } catch (IllegalAccessException | InstantiationException e) {
               e.printStackTrace();
           }
        }
    }
}