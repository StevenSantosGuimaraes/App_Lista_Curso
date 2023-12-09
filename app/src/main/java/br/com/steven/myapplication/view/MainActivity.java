package br.com.steven.myapplication.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.steven.myapplication.R;
import br.com.steven.myapplication.controller.PessoaController;
import br.com.steven.myapplication.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref listavip";
    PessoaController controller;
    Pessoa pessoa;
    private Button btnLimpar;
    private Button btnSalvar;
    private Button btnFinalizar;
    private EditText primeiroPome;
    private EditText sobrenome;
    private EditText cursoDesejado;
    private EditText telefoneContato;
    private SharedPreferences.Editor listaVip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

        controller = new PessoaController();
        pessoa = new Pessoa();

        mapearComponentes();
        recuperarDadosSharedPreferences();
        exibirDadosRecuperadosNoFormulario();

        btnLimpar.setOnClickListener(view -> {
            limparDadosDoSharedPreferences();
            apagarFormulario(primeiroPome, sobrenome, cursoDesejado, telefoneContato);
        });

        btnSalvar.setOnClickListener(view -> {
            guardarDadosNoSharedPreferences();
            apagarFormulario(primeiroPome, sobrenome, cursoDesejado, telefoneContato);
        });

        btnFinalizar.setOnClickListener(view -> {
            Toast.makeText(this, "Aplicativo finalizado com sucesso.", Toast.LENGTH_SHORT).show();
            finish();
        });

    }

    private void guardarDadosNoSharedPreferences() {
        listaVip.putString("primeiroNome", primeiroPome.getText().toString());
        listaVip.putString("sobrenome", sobrenome.getText().toString());
        listaVip.putString("cursoDesejado", cursoDesejado.getText().toString());
        listaVip.putString("telefoneContato", telefoneContato.getText().toString());
        listaVip.apply();
        Toast.makeText(this, "Seus dados foram salvo com sucesso.", Toast.LENGTH_SHORT).show();
        apagarFormulario(primeiroPome, sobrenome, cursoDesejado, telefoneContato);
    }

    private void limparDadosDoSharedPreferences() {
        listaVip.clear();
        listaVip.apply();
    }

    private void exibirDadosRecuperadosNoFormulario() {
        primeiroPome.setText(pessoa.getPrimeiroNome());
        sobrenome.setText(pessoa.getSobrenome());
        cursoDesejado.setText(pessoa.getCursoDesejado());
        telefoneContato.setText(pessoa.getTelefoneContato());
    }

    private void recuperarDadosSharedPreferences() {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
        pessoa.setSobrenome(preferences.getString("sobrenome",""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado",""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato",""));
    }

    private void mapearComponentes() {
        primeiroPome = findViewById(R.id.editTextPrimeiroNome);
        sobrenome = findViewById(R.id.editTextSobrenome);
        cursoDesejado = findViewById(R.id.editTextNomeCursoDesejado);
        telefoneContato = findViewById(R.id.editTextTelefoneContato);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
    }

    private static void apagarFormulario(EditText primeiroPome, EditText sobrenome, EditText cursoDesejado, EditText telefoneContato) {
        primeiroPome.setText(null);
        sobrenome.setText(null);
        cursoDesejado.setText(null);
        telefoneContato.setText(null);
    }

}