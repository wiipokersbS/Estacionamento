package com.example.estacionamento.Responsavel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.estacionamento.R;

public class ResponsavelCadastro extends AppCompatActivity {

    EditText nome, telefone;
    Button back, cadastrar, exibir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_responsavel);

        nome = findViewById(R.id.EditText_User_FUL);
        telefone = findViewById(R.id.EditText_User_Phone);
        back = findViewById(R.id.btn_backs);
        cadastrar = findViewById(R.id.btn_cadastrarResp);
        exibir = findViewById(R.id.Button_exibir);

        final ResponsavelEstacionamento responsavelEstacionamento= new ResponsavelEstacionamento();

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(ResponsavelCadastro.this).create();
                alertDialog.setTitle(" Informações Cadastradas ");
                alertDialog.setMessage(" Bem - Vindo :" + responsavelEstacionamento.getNome() + "\n"+
                        " Telefone Cadastrado : " + responsavelEstacionamento.getTelefone());



            }
        });

        exibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });






    }


}
