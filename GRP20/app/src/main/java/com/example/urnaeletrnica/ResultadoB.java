package com.example.urnaeletrnica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_b);

        TextView mostrarvotobolsonaro=(TextView)findViewById(R.id.mostrarvotobolsonaro);

        Intent it=getIntent();
        int votosbolsonarototal=it.getIntExtra("votoresultadobolsonaro",0);

        mostrarvotobolsonaro.setText(String.valueOf(votosbolsonarototal));
    }
}