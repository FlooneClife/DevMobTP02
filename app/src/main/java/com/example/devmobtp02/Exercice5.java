package com.example.devmobtp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Exercice5 extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView value1;
    private TextView value2;
    private TextView value3;

    private static final int SHAKE_THRESHOLD = 800;
    private float x;
    private float y;
    private float z;
    long lastUpdate;
    private float last_x;
    private float last_y;
    private float last_z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice5);
        Camera cam = Camera.open();
        Camera.Parameters p = cam.getParameters();

        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        value3 = findViewById(R.id.value3);

        final SensorEventListener mSensorEventListener = new SensorEventListener() {
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
            public void onSensorChanged(SensorEvent sensorEvent) {

                long curTime = System.currentTimeMillis();
                if ((curTime - lastUpdate) > 100) {
                    long diffTime = (curTime - lastUpdate);
                    lastUpdate = curTime;

                    x = sensorEvent.values[0];
                    y = sensorEvent.values[1];
                    z = sensorEvent.values[2];

                    float speed = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000;

                    if ((speed > SHAKE_THRESHOLD) && (p.getFlashMode().equals("off"))) {
                        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        cam.setParameters(p);
                        cam.startPreview();
                        Toast.makeText(getApplicationContext(), "Secousse détectée", Toast.LENGTH_LONG).show();

                    } else if ((speed > SHAKE_THRESHOLD) && (p.getFlashMode().equals("torch"))) {
                        p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        cam.setParameters(p);
                        cam.stopPreview();
                        Toast.makeText(getApplicationContext(), "Secousse détectée", Toast.LENGTH_LONG).show();
                    }
                    last_x = x;
                    last_y = y;
                    last_z = z;
                }
            }
        };

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(mSensorEventListener, mSensor, SensorManager.SENSOR_DELAY_UI);
    }
}