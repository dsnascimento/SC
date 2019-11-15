package com.dsn.searchcollege5;

import android.widget.Button;

public class Comentarios {

    private int imagemTC;
    private String nomeTC;
    private String txtComenteTC;

    public Comentarios(int imagemTC, String nomeTC,String txtComenteTC) {

        this.imagemTC = imagemTC;
        this.nomeTC = nomeTC;
        this.txtComenteTC = txtComenteTC;

    }

    public Comentarios(String s, String nada, String comentarios) {
    }

    public int getImagemTC() {
        return imagemTC;
    }

    public void setImagemTC(int imagemTC) {
        this.imagemTC = imagemTC;
    }

    public String getNomeTC() {
        return nomeTC;
    }

    public void setNomeTC(String nomeTC) {
        this.nomeTC = nomeTC;
    }

    public String getTxtComente() {
        return txtComenteTC;
    }

    public void setTxtComente(String txtComente) {
        this.txtComenteTC = txtComente;
    }


}

