package com.example.devmobtp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Exercice2 extends AppCompatActivity {

    private EditText sensor;
    private Button ok;
    private TextView dispo;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice2);

        sensor = findViewById(R.id.sensortext);
        ok = findViewById(R.id.ok);
        dispo = findViewById(R.id.dispo);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                List<Sensor> sensorsList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
                String nameSensor = sensor.getText().toString();
                for (Sensor s : sensorsList) {
                    if (s.getName().equals(nameSensor)) {
                        dispo.setText("Capteur disponible");
                        break;
                    } else {
                        dispo.setText("Capteur indisponible");
                    }
                }
            }
        });

    }

}