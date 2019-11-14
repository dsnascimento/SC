package com.dsn.searchcollege5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TelaSobreFaculdade extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre_faculdade);


        ImageView imagem = findViewById(R.id.imageView);
        TextView nome = (TextView) findViewById(R.id.SobreFaculdade);
        TextView curso = findViewById(R.id.Cursos);


        Intent intent = getIntent();

        String parametro = (String) intent.getSerializableExtra("nome");
        Integer posicao  = (Integer) intent.getSerializableExtra("p");

        int img = (int) intent.getSerializableExtra("imagem");
        String cursos = String.valueOf(intent.getSerializableExtra("curso"));


        List<Faculdades> faculdades = DescricaoFaculdade.adicionarFaculdades();


        Faculdades f = faculdades.get(posicao);

        nome.setText(parametro);
        imagem.setImageResource(img);
        curso.setText(cursos);
    }
}
