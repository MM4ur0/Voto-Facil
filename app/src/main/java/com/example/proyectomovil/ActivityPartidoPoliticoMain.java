package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import androidx.annotation.NonNull;
public class ActivityPartidoPoliticoMain extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_politico_main);
        replaceFragment(new FragmentInformacion());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if (item.getItemId() == R.id.informacion) {
                    fragment = new FragmentInformacion();
                } else if (item.getItemId() == R.id.candidatos) {
                    fragment = new FragmentCandidatos();
                } else if (item.getItemId() == R.id.plan) {
                    fragment = new FragmentPlan();
                } else {
                    return false;
                }
                replaceFragment(fragment);
                return true;
            }
        });
    }

    private void replaceFragment(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, f);
        ft.commit();
    }
}