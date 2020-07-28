package com.aman.twopanefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getSupportFragmentManager();
        OptionFragment optionFragment=new OptionFragment();
        fragmentManager.beginTransaction()
                .add(R.id.frameLayout,optionFragment)
                .commit();
    }
}