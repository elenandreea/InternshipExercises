package com.example.internshipexercises;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.internshipexercises.Utils.DownloaderUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Runnable downloadRunnable = new DownloadRunnable();

    class DownloadRunnable implements Runnable{

        @Override
        public void run() {
            Bitmap bitmap = DownloaderUtil.INSTANCE.downloadImage();
            runOnUiThread(() -> imageView.setImageBitmap(bitmap));
        }
    }

    private void downloadImageUsingExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(downloadRunnable);
    }

    private void downloadImageUsingThread(){
        new Thread(() -> {
            final Bitmap bitmap = DownloaderUtil.INSTANCE.downloadImage();
            runOnUiThread(() -> imageView.setImageBitmap(bitmap));
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
//        downloadImageUsingThread();
        downloadImageUsingExecutor();
    }

}
