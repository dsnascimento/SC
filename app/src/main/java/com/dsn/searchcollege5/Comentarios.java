package com.dsn.searchcollege5;

import android.widget.Button;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Comentarios {

    //private int imagemTC;
    private String nomeTC;
    private String txtComenteTC;
    private String idFaculdade;



    public Comentarios(String s, String nada, String comentarios) {
    }

    public Comentarios() {
    }

    public void salvar(){


        DatabaseReference firebaseRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference comentarios = firebaseRef
                .child("comentarios_usuario")
                .child( getIdFaculdade() )
                .child(getIdFaculdade());
        comentarios.setValue( this );

    }



    public String getIdFaculdade() {
        return idFaculdade;
    }

    public void setIdFaculdade(String idFaculdade) {
        this.idFaculdade = idFaculdade;
    }


    public String getNomeTC() {
        return nomeTC;
    }

    public void setNomeTC(String nomeTC) {
        this.nomeTC = nomeTC;}

    public String getTxtComente() {
        return txtComenteTC;
    }

    public void setTxtComente(String txtComente) {
        this.txtComenteTC = txtComente;
    }

    @Override
    public String toString() {
        return txtComenteTC;
    }
}

