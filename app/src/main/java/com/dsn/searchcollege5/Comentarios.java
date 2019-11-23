package com.dsn.searchcollege5;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Comentarios {

    //private int imagemTC;
    private String nomeTC;
    private String txtComenteTC;
    private String idFaculdade;
    private Integer posicao;
    private String email = "egonascimento@hotmail.com";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Comentarios() {
    }

    public void salvar(){


        DatabaseReference firebaseRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference comentarios = firebaseRef
                .child("comentarios_usuario")
                // .child( getIdFaculdade() )
                .child(getIdFaculdade())
                .child(UUID.randomUUID().toString())    ;
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
        return getTxtComenteTC();
    }

    public void setTxtComente(String txtComente) {
        this.setTxtComenteTC(txtComente);
    }



    public String getTxtComenteTC() {
        return txtComenteTC;
    }

    public void setTxtComenteTC(String txtComenteTC) {
        this.txtComenteTC = txtComenteTC;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    @NonNull
    @Override
    public String toString() {
        return txtComenteTC + " " + email;
    }
}

