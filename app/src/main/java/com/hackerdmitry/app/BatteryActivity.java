package com.hackerdmitry.app;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.os.BatteryManager.BATTERY_PLUGGED_AC;
import static android.os.BatteryManager.BATTERY_PLUGGED_USB;

public class BatteryActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        textView = findViewById(R.id.textView);

        Intent batteryStatus = this.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

        textView.setText(isCharging ? "Заряжается" : "Работает от батареи");

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        int batteryPct = (int)(level / (float) scale * 100);
        textView.setText(textView.getText() + ", " + batteryPct + "%");

        if (isCharging) {
            int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            if (chargePlug == BATTERY_PLUGGED_USB)
                textView.setText(textView.getText() + "\nЗарядка идет по USB");
            else if (chargePlug == BATTERY_PLUGGED_AC)
                textView.setText(textView.getText() + "\nУстройство подключено к сети");
        }
    }
}
