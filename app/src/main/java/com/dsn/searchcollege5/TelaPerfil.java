package com.dsn.searchcollege5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dsn.searchcollege5.classes.Conexao;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TelaPerfil extends AppCompatActivity {

    private TextView lblEmailTP,lblIdTP,lblNomeTP;
    private Button btnLogOutTP;

    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        inicializarComponentes();
        eventoClick();
    }

    private void eventoClick() {
        btnLogOutTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexao.logOut();
                finish();
                Intent TP = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(TP);
            }
        });
    }

    private void inicializarComponentes(){
        lblNomeTP = (TextView) findViewById(R.id.lblNomeTP);
        lblIdTP = (TextView) findViewById(R.id.lblIdTP);
        lblEmailTP = (TextView) findViewById(R.id.lblEmailTP);
        btnLogOutTP = (Button) findViewById(R.id.btnLogOutTP);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();
        verificaUser();
    }

    private void verificaUser() {
        if(user == null){
            finish();
        }else{
            lblNomeTP.setText("Nome: "+user.getDisplayName());
            lblIdTP.setText("ID: "+user.getUid());
            lblEmailTP.setText("Email: "+user.getEmail())
            ;
        }

    }

}