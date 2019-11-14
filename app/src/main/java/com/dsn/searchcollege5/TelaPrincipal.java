package com.dsn.searchcollege5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaPrincipal extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        ListView listfaculdade = (ListView) findViewById(R.id.lisFaculdades);
        final ArrayList<Faculdades> faculdades = DescricaoFaculdade.adicionarFaculdades();
        ArrayAdapter adapter = new FaculdadesAdapter(this, faculdades);
        listfaculdade.setAdapter(adapter);

        listfaculdade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaPrincipal.this,TelaSobreFaculdade.class);


                //------AQUI VOCE PEGA OS DADOS DO MODELO PARA CARREGAR NA TELA
                intent.putExtra("nome", faculdades.get(position).getSobre());
                intent.putExtra("imagem",faculdades.get(position).getImagem());
                intent.putExtra("curso",faculdades.get(position).getCurso());

                intent.putExtra("p", position);

                startActivity(intent);
            }
        });

    }


}