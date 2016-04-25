package com.usabilla.katarina.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements TopSectionFragment.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //gets the fragment manager
        FragmentManager supportFragmentManager = getSupportFragmentManager();

        //Creates the fragment that will be inserted in the main view
        TopSectionFragment topSectionFragment = new TopSectionFragment();

        //Insert the fragment created above in the main view
        supportFragmentManager.beginTransaction().add(R.id.topMemeText, topSectionFragment).commit();


        //Create other fragment
        BottomPictureFragment bottomPictureFragment = new BottomPictureFragment();

        //Another transaction
        supportFragmentManager.beginTransaction().add(R.id.fragment2, bottomPictureFragment).commit();

        //image


    }

    //this gets called by the Top Section Fragment when the users click the button
    @Override
    public void createMeme(String top, String bottom) {
        BottomPictureFragment bottomFragment = (BottomPictureFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.setMemeText(top, bottom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
