package com.example.mukit.omrlab;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "xxxxxxx";

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");

    }


    ///!!  IMPORTANT funvtion as this solved -- No implementation found for long
    /// org.opencv.core.Mat.n_Mat() error Using OpenCV-- error


    static {
        if (!OpenCVLoader.initDebug()) {
            // Handle initialization error
            Log.d(TAG, "not loaded open cv");
        }
    }

    private Button takePictureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// testing openCV

        if (!OpenCVLoader.initDebug()) {
            Toast.makeText(getApplicationContext(), "OpenCv not available", Toast.LENGTH_LONG).show();
        }

        ////////////

        takePictureButton = (Button) findViewById(R.id.takeImg);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            takePictureButton.setEnabled(false);
            Toast.makeText(getApplicationContext(), "permission not granted", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                takePictureButton.setEnabled(true);
            }
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public void imgCapture(View view) {

        Intent ansActivity = new Intent(MainActivity.this, AnswerInputActivity.class);
        startActivity(ansActivity);

    }


}
