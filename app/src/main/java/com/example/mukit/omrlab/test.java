package com.example.mukit.omrlab;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

public class test extends AppCompatActivity {

    private static final String TAG ="testActivity" ;

    private Bitmap originalBitmap;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        imageView= (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bmp);
    }

    public void showToast(String str) {
        Toast.makeText(test.this, str, Toast.LENGTH_SHORT).show();
    }
}
