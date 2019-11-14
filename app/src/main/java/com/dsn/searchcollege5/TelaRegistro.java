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

public class TelaRegistro extends AppCompatActivity {

    private  EditText txtNomeCompletoTR,txtEmailTR,txtSenhaTR;
    private Button btnSalvarTR,btnVoltarTR;

    private  FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registro);
        inicializaComponentes();
        eventoClicks();
    }

    private void eventoClicks() {
        btnVoltarTR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        btnSalvarTR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomec = txtNomeCompletoTR.getText().toString().trim();
                String email = txtEmailTR.getText().toString().trim();
                String senha = txtSenhaTR.getText().toString().trim();

                //esse método irá ser ultilizado para criar uma nova conta
                criarUser(email,senha,nomec);

                Intent TP = new Intent(getApplicationContext(), TelaPerfil.class);
                startActivity(TP);
            }
        });
    }

    private void criarUser(String email, String senha, String nomec) {
        auth.createUserWithEmailAndPassword(email,senha)
                .addOnCompleteListener(TelaRegistro.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            alert("Usuario Registrado com Sucesso !");
                            Intent i =new Intent(TelaRegistro.this,TelaPerfil.class);
                            startActivity(i);
                            finish();
                        } else {
                            alert("Usuario Não Registrado ! !");
                        }
                    }
                });
    }
    //menssagem a ser exibida se o login for salvo com sucesso
    private void alert(String msg){
        Toast.makeText(TelaRegistro.this,msg,Toast.LENGTH_SHORT).show();
    }

    private void inicializaComponentes(){
        txtNomeCompletoTR = (EditText) findViewById(R.id.txtNomeCompletoTR);
        txtEmailTR = (EditText) findViewById(R.id.txtEmailTR);
        txtSenhaTR = (EditText) findViewById(R.id.txtSenhaTR);
        btnSalvarTR = (Button) findViewById(R.id.btnSalvarTR);
        btnVoltarTR = (Button) findViewById(R.id.btnVoltarTR);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //receber conexao
        auth = Conexao.getFirebaseAuth();
    }
}
