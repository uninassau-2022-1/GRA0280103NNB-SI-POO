package com.example.urnaeletrnica;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumeroVoto;
    Double voto;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumeroVoto=findViewById(R.id.etNumeroVoto);

        button=findViewById(R.id.btn);



    }
    public void votar(View v){

            Intent telalula=new Intent(this,ActivityLula.class);
            Intent telabolsonaro=new Intent(this,ActivityBolsonaro.class);
            voto=Double.parseDouble(etNumeroVoto.getText().toString());

            if(voto==13){
                startActivity(telalula);
            }else if(voto==17){
                startActivity(telabolsonaro);
            }

    }

    

}