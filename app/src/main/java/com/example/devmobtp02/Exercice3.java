package com.example.devmobtp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Exercice3 extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView value1;
    private TextView value2;
    private TextView value3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice3);
        LinearLayout bg = (LinearLayout) findViewById(R.id.container);

        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        value3 = findViewById(R.id.value3);

        final SensorEventListener mSensorEventListener = new SensorEventListener() {
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];
                value1.setText("X = " + x);
                value2.setText("Y = " + y);
                value3.setText("Z = " + z);
                if(x < -3) {
                    bg.setBackgroundColor(Color.GREEN);
                } else if(x > 4) {
                    bg.setBackgroundColor(Color.RED);
                } else {
                    bg.setBackgroundColor(Color.BLACK);
                }
            }
        };

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(mSensorEventListener, mSensor, SensorManager.SENSOR_DELAY_UI);
    }

}