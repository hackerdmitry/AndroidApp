package com.hackerdmitry.app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button toBatteryActivity, toLocationActivity;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Несколько дней ушло на запуск AndroidStudio", Toast.LENGTH_LONG).show();

        textView = findViewById(R.id.textView2);
        toBatteryActivity = findViewById(R.id.toBatteryActivity);
        toLocationActivity = findViewById(R.id.toLocationActivity);
        toBatteryActivity.setOnClickListener(this);
        toLocationActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toBatteryActivity:
                textView.setText("Была вызвана активность BatteryActivity");
                startActivity(new Intent(this, BatteryActivity.class));
                break;
            case R.id.toLocationActivity:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    textView.setText("Активность LocationActivity не будет доступна, пока не будет предоставлено разрешение");
                } else {
                    startActivity(new Intent(this, LocationActivity.class));
                    textView.setText("Была вызвана активность LocationActivity");
                }
                break;
        }
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
