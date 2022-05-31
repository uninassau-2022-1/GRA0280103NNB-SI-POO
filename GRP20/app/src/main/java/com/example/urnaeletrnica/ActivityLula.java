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

import com.example.urnaeletrnica.Model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityLula extends AppCompatActivity {

    Button btnvotar;
    int votoLula;
    private EditText et_nome,et_cpf;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lula);

        mAuth=FirebaseAuth.getInstance();

        et_nome=findViewById(R.id.et_nome);
        et_cpf=findViewById(R.id.et_cpf);
        btnvotar=findViewById(R.id.btnvotar);

        votoLula=0;

        btnvotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel=new UserModel();

                userModel.setNome(et_nome.getText().toString());
                userModel.setCpf(et_cpf.getText().toString());

                if(!TextUtils.isEmpty(userModel.getNome()) || !TextUtils.isEmpty(userModel.getCpf())){
                    mAuth.createUserWithEmailAndPassword(userModel.getNome(),userModel.getCpf()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                userModel.setId(mAuth.getUid());
                                userModel.salvar();

                                votoLula+=+1;

                                DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
                                reference.child("qntVotosLula").child("votoLula").setValue(votoLula);



                                Intent telaresultado=new Intent(ActivityLula.this,ActivityResultado.class);
                                telaresultado.putExtra("votoresultadolula",votoLula);



                                startActivity(telaresultado);


                            }else{
                                String error= task.getException().getMessage();
                                Toast.makeText(ActivityLula.this,""+error, Toast.LENGTH_SHORT).show();
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
        Intent intent=new Intent(ActivityLula.this,ActivityResultado.class);
        startActivity(intent);
        finish();
    }



}