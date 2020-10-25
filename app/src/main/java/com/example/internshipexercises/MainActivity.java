package com.example.internshipexercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.internshipexercises.model.Post;
import com.example.internshipexercises.server.ServerProvider;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getPostSynchronously();
        getPostASynchronously();

    }

    private void getPostASynchronously() {
        ServerProvider.createPostService().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                if(posts!=null){
                    Log.d(TAG, "there are" + posts.size() );
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e(TAG, "error");
            }
        });
    }

    private void getPostSynchronously() {
        try {
            Response<List<Post>> response = ServerProvider.createPostService().getPosts().execute();
            List<Post> posts = response.body();
            if(posts!=null){
                Log.d(TAG, "there are" + posts.size() );
            }
        } catch (IOException e) {
            Log.e(TAG, "error");
        }
    }

}
