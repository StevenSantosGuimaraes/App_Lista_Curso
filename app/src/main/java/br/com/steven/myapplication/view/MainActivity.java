package br.com.steven.myapplication.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.steven.myapplication.R;
import br.com.steven.myapplication.controller.PessoaController;
import br.com.steven.myapplication.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    Pessoa pessoa;
    private Button btnLimpar;
    private Button btnSalvar;
    private Button btnFinalizar;
    private EditText primeiroPome;
    private EditText sobrenome;
    private EditText cursoDesejado;
    private EditText telefoneContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        pessoa = new Pessoa();

        mapearComponentes();
        controller.buscar(pessoa);
        exibirDadosRecuperadosNoFormulario();

        btnLimpar.setOnClickListener(view -> {
            controller.apagarDadosDoSharedPreferences();
            apagarFormulario(primeiroPome, sobrenome, cursoDesejado, telefoneContato);
            Toast.makeText(this, "Formulário e dados anteriores foram apagados com sucesso.", Toast.LENGTH_SHORT).show();
        });

        btnSalvar.setOnClickListener(view -> {
            pessoa.setPrimeiroNome(primeiroPome.getText().toString());
            pessoa.setSobrenome(sobrenome.getText().toString());
            pessoa.setCursoDesejado(cursoDesejado.getText().toString());
            pessoa.setTelefoneContato(telefoneContato.getText().toString());

            controller.salvar(pessoa);
            Toast.makeText(this, "Pessoa inserida com sucesso.", Toast.LENGTH_SHORT).show();
            apagarFormulario(primeiroPome, sobrenome, cursoDesejado, telefoneContato);
        });

        btnFinalizar.setOnClickListener(view -> {
            Toast.makeText(this, "Aplicativo finalizado com sucesso.", Toast.LENGTH_SHORT).show();
            finish();
        });

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

    private void exibirDadosRecuperadosNoFormulario() {
        if (pessoa != null) {
            primeiroPome.setText(pessoa.getPrimeiroNome());
            sobrenome.setText(pessoa.getSobrenome());
            cursoDesejado.setText(pessoa.getCursoDesejado());
            telefoneContato.setText(pessoa.getTelefoneContato());
        }
    }

}