package com.example.urnaeletrnica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView mostrarvotolula=(TextView)findViewById(R.id.mostrarvotolula);

        Intent it=getIntent();
        int votoslulatotal=it.getIntExtra("votoresultadolula",0);

        mostrarvotolula.setText(String.valueOf(votoslulatotal));

    }
}