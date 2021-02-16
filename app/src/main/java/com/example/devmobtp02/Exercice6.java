package com.example.devmobtp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Exercice6 extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private static final int SENSOR_SENSITIVITY = 5;

    TextView distance;
    TextView distanceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice6);

        distance = findViewById(R.id.distance);
        distanceText = findViewById(R.id.distanceText);

        final SensorEventListener mSensorEventListener = new SensorEventListener() {
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
            public void onSensorChanged(SensorEvent sensorEvent) {
               if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (sensorEvent.values[0] >= -SENSOR_SENSITIVITY && sensorEvent.values[0] <= SENSOR_SENSITIVITY) {
                distanceText.setText("Proche");
            } else {
                distanceText.setText("Loin");
            }
            distance.setText(Float.toString(sensorEvent.values[0]));
        }

            }
        };

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        mSensorManager.registerListener(mSensorEventListener, mSensor, SensorManager.SENSOR_DELAY_UI);

    }

}