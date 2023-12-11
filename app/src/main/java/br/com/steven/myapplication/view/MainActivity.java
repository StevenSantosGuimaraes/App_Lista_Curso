package br.com.steven.myapplication.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.steven.myapplication.R;
import br.com.steven.myapplication.controller.CursoController;
import br.com.steven.myapplication.controller.PessoaController;
import br.com.steven.myapplication.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController pessoaController;
    CursoController cursoController;
    Pessoa pessoa;
    List<String> nomesDosCursos;

    private EditText primeiroPome;
    private EditText sobrenome;
    private Spinner spinnerCursos;
    private EditText telefoneContato;
    private Button btnLimpar;
    private Button btnSalvar;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapearComponentes();

        pessoaController = new PessoaController(MainActivity.this);
        pessoa = new Pessoa();

        pessoaController.buscar(pessoa);
        exibirDadosRecuperadosNoFormulario();

        cursoController = new CursoController();
        cursoController.getListOfCourses();
        nomesDosCursos = cursoController.dadosParaSpinner();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomesDosCursos);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnerCursos.setAdapter(adapter);

        btnLimpar.setOnClickListener(view -> {
            pessoaController.apagarDadosDoSharedPreferences();
            apagarFormulario(primeiroPome, sobrenome, telefoneContato);
            Toast.makeText(this, "Formulário e dados anteriores foram apagados com sucesso.", Toast.LENGTH_SHORT).show();
        });

        btnSalvar.setOnClickListener(view -> {
            pessoa.setPrimeiroNome(primeiroPome.getText().toString());
            pessoa.setSobrenome(sobrenome.getText().toString());
            //pessoa.setCursoDesejado(cursoDesejado.getText().toString());
            pessoa.setTelefoneContato(telefoneContato.getText().toString());

            pessoaController.salvar(pessoa);
            Toast.makeText(this, "Pessoa inserida com sucesso.", Toast.LENGTH_SHORT).show();
            apagarFormulario(primeiroPome, sobrenome, telefoneContato);
        });

        btnFinalizar.setOnClickListener(view -> {
            Toast.makeText(this, "Aplicativo finalizado com sucesso.", Toast.LENGTH_SHORT).show();
            finish();
        });

    }

    private void mapearComponentes() {
        primeiroPome = findViewById(R.id.editTextPrimeiroNome);
        sobrenome = findViewById(R.id.editTextSobrenome);
        spinnerCursos = findViewById(R.id.spinnerNomeCursoDesejado);
        telefoneContato = findViewById(R.id.editTextTelefoneContato);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
    }

    private static void apagarFormulario(EditText primeiroPome, EditText sobrenome, EditText telefoneContato) {
        primeiroPome.setText(null);
        sobrenome.setText(null);
        //cursoDesejado.setText(null);
        telefoneContato.setText(null);
    }

    private void exibirDadosRecuperadosNoFormulario() {
        if (pessoa != null) {
            primeiroPome.setText(pessoa.getPrimeiroNome());
            sobrenome.setText(pessoa.getSobrenome());
            //cursoDesejado.setText(pessoa.getCursoDesejado());
            telefoneContato.setText(pessoa.getTelefoneContato());
        }
    }

}