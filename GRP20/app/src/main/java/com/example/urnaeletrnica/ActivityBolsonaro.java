package com.example.urnaeletrnica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.urnaeletrnica.ModelB.UserModelB;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityBolsonaro extends AppCompatActivity {

    Button btnvotarb;
    int votoBolsonaro;
    private EditText et_nome,et_cpf;

    private FirebaseAuth mAuth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsonaro);

        mAuth1=FirebaseAuth.getInstance();

        et_nome=findViewById(R.id.et_nomeb);
        et_cpf=findViewById(R.id.et_cpfb);
        btnvotarb=findViewById(R.id.btnvotarb);

        votoBolsonaro=0;

        btnvotarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModelB userModelB=new UserModelB();

                userModelB.setNome(et_nome.getText().toString());
                userModelB.setCpf(et_cpf.getText().toString());

                if(!TextUtils.isEmpty(userModelB.getNome()) || !TextUtils.isEmpty(userModelB.getCpf())){
                    mAuth1.createUserWithEmailAndPassword(userModelB.getNome(),userModelB.getCpf()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                userModelB.setId(mAuth1.getUid());
                                userModelB.salvar();

                                votoBolsonaro+=+1;

                                DatabaseReference reference1= FirebaseDatabase.getInstance().getReference();
                                reference1.child("qntVotosBolsonaro").child("votoBolsonaro").setValue(votoBolsonaro);



                                Intent telaresultado1=new Intent(ActivityBolsonaro.this,ResultadoB.class);
                                telaresultado1.putExtra("votoresultadobolsonaro",votoBolsonaro);



                                startActivity(telaresultado1);


                            }else{
                                String error= task.getException().getMessage();
                                Toast.makeText(ActivityBolsonaro.this,""+error, Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });



    }

    public void voltar(View v){
        this.finish();
    }

    private void abrirTelaPrincipal() {
        Intent intent=new Intent(ActivityBolsonaro.this,ResultadoB.class);
        startActivity(intent);
        finish();
    }

}