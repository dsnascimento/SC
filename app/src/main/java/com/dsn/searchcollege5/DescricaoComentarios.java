package com.dsn.searchcollege5;

import java.util.ArrayList;

public class DescricaoComentarios {

    public static ArrayList<Comentarios> adicionarComentarios() {
        ArrayList<Comentarios> comentarios = new ArrayList<Comentarios>();

        Comentarios c = new Comentarios("R.drawable.area1","nada","Comentarios");

        c = new Comentarios("R.drawable.area1","nada","Cometarios");
                comentarios.add(c);

        return comentarios;

    }
}