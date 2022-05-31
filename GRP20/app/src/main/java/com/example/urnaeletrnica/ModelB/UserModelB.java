package com.example.urnaeletrnica.ModelB;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;

public class UserModelB {
    private String id;
    private String nome;
    private String cpf;

    public UserModelB() {
    }

    public UserModelB(String id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void salvar(){
        DatabaseReference referenceB= FirebaseDatabase.getInstance().getReference();
        referenceB.child("eleitoresb").child(getId()).setValue(this);
    }
    public void salvarVoto(){

    }
}





