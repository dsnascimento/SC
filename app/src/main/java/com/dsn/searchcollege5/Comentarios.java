package com.dsn.searchcollege5;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Comentarios {

    //private int imagemTC;
    private String nomeTC;
    private String txtComenteTC;
    private String idFaculdade;
    private Integer posicao;



    public Comentarios(String s, String nada, String comentarios) {
    }

    public Comentarios() {
    }

    public void salvar(){


        DatabaseReference firebaseRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference comentarios = firebaseRef
                .child("comentarios_usuario")
                // .child( getIdFaculdade() )
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
        return getTxtComenteTC();
    }

    public void setTxtComente(String txtComente) {
        this.setTxtComenteTC(txtComente);
    }

    @Override
    public String toString() {
        return getTxtComenteTC();
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
}

