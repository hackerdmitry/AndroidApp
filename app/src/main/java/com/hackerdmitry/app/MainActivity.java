package com.hackerdmitry.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Несколько дней ушло на запуск AndroidStudio", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("App", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("App", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("App", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("App", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("App", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("App", "onDestroy");
    }
}
