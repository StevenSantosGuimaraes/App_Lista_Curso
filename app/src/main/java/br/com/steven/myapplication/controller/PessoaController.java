package br.com.steven.myapplication.controller;

import android.content.SharedPreferences;

import br.com.steven.myapplication.model.Pessoa;
import br.com.steven.myapplication.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    private SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
        pessoa.setSobrenome(preferences.getString("sobrenome",""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado",""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato",""));
    }

    public void salvar (Pessoa pessoa) {
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();
    }

    public void apagarDadosDoSharedPreferences () {
        listaVip.clear();
        listaVip.apply();
    }
    
}
