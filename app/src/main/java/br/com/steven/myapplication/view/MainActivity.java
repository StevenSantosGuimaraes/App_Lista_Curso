package br.com.steven.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.steven.myapplication.R;
import br.com.steven.myapplication.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa("Steven","Guimarães","Fullstack em Java","(00) 0.0000-0000");
        System.out.println(pessoa);

        EditText primeiroPome = findViewById(R.id.editTextPrimeiroNome);
        EditText sobrenome = findViewById(R.id.editTextSobrenome);
        EditText cursoDesejado = findViewById(R.id.editTextNomeCursoDesejado);
        EditText telefoneContato = findViewById(R.id.editTextTelefoneContato);

        Button btnLimpar = findViewById(R.id.btnLimpar);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnFinalizar = findViewById(R.id.btnFinalizar);

        primeiroPome.setText(pessoa.getPrimeiroNome());
        sobrenome.setText(pessoa.getSobrenome());
        cursoDesejado.setText(pessoa.getCursoDesejado());
        telefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(view -> {
            Toast.makeText(this, "Formulário reiniciado com sucesso.", Toast.LENGTH_SHORT).show();
            apagarFormulario(primeiroPome, sobrenome, cursoDesejado, telefoneContato);
        });

        btnSalvar.setOnClickListener(view -> {
            Toast.makeText(this, "Dados informados com sucesso.", Toast.LENGTH_SHORT).show();
            apagarFormulario(primeiroPome, sobrenome, cursoDesejado, telefoneContato);
        });

        btnFinalizar.setOnClickListener(view -> {
            Toast.makeText(this, "Aplicativo finalizado com sucesso.", Toast.LENGTH_SHORT).show();
            finish();
        });

    }

    private static void apagarFormulario(EditText primeiroPome, EditText sobrenome, EditText cursoDesejado, EditText telefoneContato) {
        primeiroPome.setText(null);
        sobrenome.setText(null);
        cursoDesejado.setText(null);
        telefoneContato.setText(null);
    }

}