package com.dsn.searchcollege5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dsn.searchcollege5.classes.Conexao;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private Button btnEntrarTL,btnRegistrarTL;
    private EditText txtEmailTL,txtSenhaTL;

    private FirebaseAuth auth;

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
        btnEntrarTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmailTL.getText().toString().trim();
                String senha = txtSenhaTL.getText().toString().trim();
                logar(email,senha);

            }
        });
    }

    private void logar(String email, String senha) {
        auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Intent i = new Intent(MainActivity.this,TelaPrincipal.class);
                            startActivity(i);
                        }else{
                            alert("Email ou Senha Incorretos !");
                        }

                    }
                });
    }

    private void alert(String s) {
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
    }

    private  void inicializarComponentes(){
        txtEmailTL = (EditText) findViewById(R.id.txtEmailTL);
        txtSenhaTL = (EditText) findViewById(R.id.txtSenhaTL);
        btnEntrarTL = (Button) findViewById(R.id.btnEntrarTL);
        btnRegistrarTL = (Button) findViewById(R.id.btnRegistrarTL);
    }

    protected void onStart(){
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }

}
