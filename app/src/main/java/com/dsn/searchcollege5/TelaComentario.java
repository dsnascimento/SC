package com.dsn.searchcollege5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaComentario extends AppCompatActivity {

    private Button btnVoltarTC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_comentario);

        Button btnVoltarTC = (Button) findViewById(R.id.btnVoltarTC);
        btnVoltarTC.setOnClickListener(cliqueVoltarTC);


        ListView listComentarios = (ListView) findViewById(R.id.listComentariosTC);
        final ArrayList<Comentarios> comentarios = DescricaoComentarios.adicionarComentarios();
        ArrayAdapter adapter = new ComentariosAdapter(this, comentarios);
        listComentarios.setAdapter(adapter);

        listComentarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaComentario.this,TelaComentario.class);


                //------AQUI VOCE PEGA OS DADOS DO MODELO PARA CARREGAR NA TELA
                intent.putExtra("nome", comentarios.get(position).getImagemTC());
                intent.putExtra("imagem",comentarios.get(position).getNomeTC());
                intent.putExtra("curso",comentarios.get(position).getTxtComente());

                intent.putExtra("c", position);

                startActivity(intent);
            }
        });
    }
    View.OnClickListener cliqueVoltarTC = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            onBackPressed();
        }
    };

}
