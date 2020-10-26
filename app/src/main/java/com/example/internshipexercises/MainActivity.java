package com.example.internshipexercises;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


//Details activity
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        usePreferences();
    }

    private void setToolbar() {
        Toolbar mytoolbar = findViewById(R.id.my_toolbar);
        mytoolbar.setTitle("Restaurant name");
        mytoolbar.setSubtitle("Restaurant description");
        setSupportActionBar(mytoolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_favourite:
                Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void usePreferences(){
        SharedPreferences preferences = getSharedPreferences("choices", MainActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("chosenColor", "RED");
        editor.putInt("chosenNumber", 7);
        //async
        editor.apply();
        //sync
//        editor.commit();

        String color = preferences.getString("chosenColor", "BLACK");
        int number = preferences.getInt("chosenNumber", 0);

        Log.d("MainActivity", "color:" + color + " number:" + number);
    }
}
