package com.example.internshipexercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private int incrementValue = 0;
    private TextView incrementTv;
    private Button incrementBtn;
    private TextView textView;

    private void initViews(){
        incrementTv = findViewById(R.id.counter_value_tv);
        incrementBtn = findViewById(R.id.increment_bt);

        incrementTv.setText(String.valueOf(incrementValue));
        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementValue++;
                incrementTv.setText(String.valueOf(incrementValue));
            }
        });
    }


    protected void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);
        state.putInt("nrOfTimes", incrementValue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Happy to be born");


        if((savedInstanceState != null) && (savedInstanceState.getSerializable("nrOfTimes") != null)){
            incrementValue = savedInstanceState.getInt("nrOfTimes");
        }else{
            incrementValue = 0;
        }

        initViews();
    }

    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: I exist but you cannot see me");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: Preparing final UI changes for master");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: You can see me, but i don t want to interact");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: Packing up, preparing to leave");
    }


    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: Bye bye");
    }
}
