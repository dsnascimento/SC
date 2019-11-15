package com.dsn.searchcollege5;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ComentariosAdapter  extends ArrayAdapter {


    private final Context context;
    private final ArrayList<Comentarios> elementosTC;


    public ComentariosAdapter(Context context, ArrayList<Comentarios> elementosTC) {
        super(context, R.layout.listacomentarios, elementosTC);
        this.context = context;
        this.elementosTC = elementosTC;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listacomentarios, parent, false);

        TextView nomeUsuarioTC = (TextView) rowView.findViewById(R.id.nomeUsuarioTC);
        TextView comentarioTC = (TextView) rowView.findViewById(R.id.comentarioTC);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imgUserTC);

        nomeUsuarioTC.setText(elementosTC.get(position).getNomeTC());
        comentarioTC.setText(elementosTC.get(position).getTxtComente());
        imagem.setImageResource(elementosTC.get(position).getImagemTC());
        return rowView;
    }

}
