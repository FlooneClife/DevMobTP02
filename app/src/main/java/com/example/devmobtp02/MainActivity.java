package com.example.devmobtp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button but1;
    Button but2;
    Button but3;
    Button but4;
    Button but5;
    Button but6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next1 = new Intent(MainActivity.this, com.example.devmobtp02.Exercice1.class);
                startActivity(next1);
            }
        });

        but2 = (Button) findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next2 = new Intent(MainActivity.this, com.example.devmobtp02.Exercice2.class);
                startActivity(next2);
            }
        });

        but3 = (Button) findViewById(R.id.but3);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next3 = new Intent(MainActivity.this, com.example.devmobtp02.Exercice3.class);
                startActivity(next3);
            }
        });

        but4 = (Button) findViewById(R.id.but4);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next4 = new Intent(MainActivity.this, com.example.devmobtp02.Exercice4.class);
                startActivity(next4);
            }
        });

        but5 = (Button) findViewById(R.id.but5);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next5 = new Intent(MainActivity.this, com.example.devmobtp02.Exercice5.class);
                startActivity(next5);
            }
        });

        but6 = (Button) findViewById(R.id.but6);
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent next6 = new Intent(MainActivity.this, com.example.devmobtp02.Exercice6.class);
                startActivity(next6);
            }
        });

    }

}