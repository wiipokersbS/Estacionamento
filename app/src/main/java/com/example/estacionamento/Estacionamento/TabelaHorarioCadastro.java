package com.example.estacionamento.Estacionamento;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estacionamento.R;

public class TabelaHorarioCadastro extends AppCompatActivity {

    TextView txt;
    Spinner spinner;
    EditText horaAbertura, horaFechamento;
    Button btn_cadastro, btn_voltar;

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_horario);

        txt = findViewById(R.id.txtHorario);
        spinner = findViewById(R.id.spinner);
        horaAbertura = findViewById(R.id.horarioAbertura);
        horaFechamento = findViewById(R.id.horarioFechamento);
        btn_cadastro = findViewById(R.id.Button_cadastroH);
        btn_voltar = findViewById(R.id.btn_back);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.days_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }


}
