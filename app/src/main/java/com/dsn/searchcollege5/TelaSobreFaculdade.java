package com.dsn.searchcollege5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TelaSobreFaculdade extends AppCompatActivity {
    private ListView listnome;
    private Button btnComentarios;
    private EditText txtComenteS;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private List<Comentarios> comentarios = new ArrayList<>();

    ArrayAdapter<Comentarios> arrayAdapter;

    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre_faculdade);

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
//        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();

        listnome = (ListView) findViewById(R.id.lstComentariosss);


        txtComenteS = findViewById(R.id.txtComenteS);
        Button btnCometarios = (Button) findViewById(R.id.btnComentarios);
        btnCometarios.setOnClickListener(cliqueComentarios);


        ImageView imagem = findViewById(R.id.imageView);
        TextView nome = (TextView) findViewById(R.id.SobreFaculdade);
        TextView curso = findViewById(R.id.Cursos);


        Intent intent = getIntent();

        String parametro = (String) intent.getSerializableExtra("nome");
        Integer posicao = (Integer) intent.getSerializableExtra("p");


        int img = (int) intent.getSerializableExtra("imagem");
        String cursos = String.valueOf(intent.getSerializableExtra("curso"));


        List<Faculdades> faculdades = DescricaoFaculdade.adicionarFaculdades();


        Faculdades f = faculdades.get(posicao);

        recuperarComentarios();

        nome.setText(parametro);
        imagem.setImageResource(img);
        curso.setText(cursos);


    }

    View.OnClickListener cliqueComentarios = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = getIntent();
            Integer posicao = (Integer) intent.getSerializableExtra("p");


            Comentarios comentario = new Comentarios();
            comentario.setTxtComente(txtComenteS.getText().toString());
            comentario.setPosicao(posicao);
            comentario.setIdFaculdade(posicao.toString());
            comentario.salvar();
        }
    };


    private void recuperarComentarios() {
        Intent intent = getIntent();
        final Integer posicao = (Integer) intent.getSerializableExtra("p");



        FirebaseDatabase.getInstance().getReference().child("comentarios_usuario").

                //databaseReference.
                        addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

//professor fez-----
                        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                            Comentarios c2 = postSnapshot.getValue(Comentarios.class);
                            if ( c2.getPosicao()==posicao){
                                comentarios.add(c2);
                            }
                        }
                        arrayAdapter = new ArrayAdapter<Comentarios>(TelaSobreFaculdade.this, android.R.layout.simple_list_item_1,
                                comentarios);
                        listnome.setAdapter(arrayAdapter);
                        arrayAdapter.notifyDataSetChanged();
                    }
                    //professor fez-----
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                        // ...
                    }
                });




    }


}
