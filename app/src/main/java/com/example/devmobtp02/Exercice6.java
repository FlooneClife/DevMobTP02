package com.example.devmobtp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Exercice6 extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private ImageView img;
    private static final int SENSOR_SENSITIVITY = 4;

    TextView distanceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice6);

        distanceText = findViewById(R.id.distanceText);
        img = findViewById(R.id.oksign);

        final SensorEventListener mSensorEventListener = new SensorEventListener() {
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
            public void onSensorChanged(SensorEvent sensorEvent) {
               if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (sensorEvent.values[0] >= -SENSOR_SENSITIVITY && sensorEvent.values[0] <= SENSOR_SENSITIVITY) {
                distanceText.setText("Proche");
                img.setVisibility(View.VISIBLE);
            } else {
                distanceText.setText("Loin");
                img.setVisibility(View.GONE);
            }
        }

            }
        };

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        mSensorManager.registerListener(mSensorEventListener, mSensor, SensorManager.SENSOR_DELAY_UI);

    }

}