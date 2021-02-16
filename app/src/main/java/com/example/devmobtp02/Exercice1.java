package com.example.devmobtp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Exercice1 extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice1);

        lv = (ListView) findViewById(R.id.list1);

        final SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        final ArrayAdapter<Sensor> adapter = new ArrayAdapter<>(Exercice1.this, android.R.layout.simple_list_item_1, sensorsList);
        lv.setAdapter(adapter);

    }

}