package com.dsn.searchcollege5.classes;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Conexao {

    private static FirebaseAuth firebaseAuth;
    private  static  FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser firebaseUser;

    private  Conexao(){
//depois implementar apra chama-lo
    }
    //se esse metodo for chamado e o oobjeto for igual a nulo devera inicializar o firebase
    public  static FirebaseAuth getFirebaseAuth(){
        if(firebaseAuth == null){
            inicializarFirebasAuth();
        }
        return firebaseAuth;
    }


    private static void inicializarFirebasAuth(){
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                //cria um usuario resgatando a propia conexao para saber se existe um user existente
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    firebaseUser = user;
                }
            }
        };

        firebaseAuth.addAuthStateListener(authStateListener);
    }

    public static FirebaseUser getFirebaseUser(){
        return  firebaseUser;
    }
    //responsavel pela saida da aplicação.
    public static void logOut(){
        firebaseAuth.signOut();
    }
}
