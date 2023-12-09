package br.com.steven.myapplication.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import br.com.steven.myapplication.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado...");
        return super.toString();
    }

    public void salvar (Pessoa pessoa) {
        Log.i("MVC_Controller", "Salvo: " + pessoa.toString());
    }
    
}
