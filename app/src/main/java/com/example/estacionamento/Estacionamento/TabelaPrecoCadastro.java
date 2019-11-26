package com.example.estacionamento.Estacionamento;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estacionamento.R;

public class TabelaPrecoCadastro  extends AppCompatActivity {

    TextView txtTitulo;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_preco);

        txtTitulo = findViewById(R.id.txtPreco);

    }
}
