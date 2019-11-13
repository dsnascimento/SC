package com.dsn.searchcollege5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button btnEntrarTL,btnRegistrarTL;
    EditText txtEmailTL,txtSenhaTL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        //Respensavel pelas açoes dos botoes da tela Login
        eventoClicks();
    }

    private void eventoClicks(){
        btnRegistrarTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TR = new Intent(getApplicationContext(), TelaRegistro.class);
                startActivity(TR);
            }
        });

        //btn entrar !

    }


    private  void inicializarComponentes(){
        txtEmailTL = (EditText) findViewById(R.id.txtEmailTL);
        txtSenhaTL = (EditText) findViewById(R.id.txtSenhaTL);
        btnEntrarTL = (Button) findViewById(R.id.btnEntrarTL);
        btnRegistrarTL = (Button) findViewById(R.id.btnRegistrarTL);
    }



}
