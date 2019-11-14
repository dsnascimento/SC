package com.dsn.searchcollege5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FaculdadesAdapter extends ArrayAdapter {


    private final Context context;
    private final ArrayList<Faculdades> elementos;

    public FaculdadesAdapter(Context context, ArrayList<Faculdades> elementos) {
        super(context, R.layout.listafaculdades, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listafaculdades, parent, false);

        TextView nomeFaculdade = (TextView) rowView.findViewById(R.id.nomeFaculdade);
        TextView endereco = (TextView) rowView.findViewById(R.id.endereco);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imgfvc);
        TextView cidade = (TextView) rowView.findViewById(R.id.cidade);

        nomeFaculdade.setText(elementos.get(position).getNome());
        endereco.setText(elementos.get(position).getEndereco());
        imagem.setImageResource(elementos.get(position).getImagem());
        cidade.setText(elementos.get(position).getCidade());
        return rowView;
    }

}
