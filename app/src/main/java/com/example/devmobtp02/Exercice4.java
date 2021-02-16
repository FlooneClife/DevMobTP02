package com.example.devmobtp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Exercice4 extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView direction;
    float [] history = new float[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice4);

        direction = findViewById(R.id.direction);

        final SensorEventListener mSensorEventListener = new SensorEventListener() {
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
            public void onSensorChanged(SensorEvent sensorEvent) {
                float xChange = history[0] - sensorEvent.values[0];
                float yChange = history[1] - sensorEvent.values[1];
                history[0] = sensorEvent.values[0];
                history[1] = sensorEvent.values[1];
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];

                if (xChange > 2){
                    direction.setText("GAUCHE");
                }
                else if (xChange < -2){
                    direction.setText("DROITE");
                }
                if (yChange > 2){
                    direction.setText("BAS");
                }
                else if (yChange < -2){
                    direction.setText("HAUT");
                }

            }
        };

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(mSensorEventListener, mSensor, SensorManager.SENSOR_DELAY_UI);
    }

}