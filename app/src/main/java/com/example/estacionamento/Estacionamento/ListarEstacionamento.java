package com.example.estacionamento.Estacionamento;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.estacionamento.Adapter.EstacionamentoAdapter;
import com.example.estacionamento.R;
import java.util.ArrayList;
import java.util.List;

public class ListarEstacionamento extends AppCompatActivity {

    List<EstabelecimentosLista> estabelecimentosListas = new ArrayList<>();

    private RecyclerView recyclerView;

   TextView titulo;

   Button btn_back;

   EstacionamentoAdapter adapter;


    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_estacionamento);

        titulo = findViewById(R.id.textView);

        recyclerView = findViewById(R.id.recyclerView);

        btn_back = findViewById(R.id.btn_back);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        EstacionamentoDAO dao = new EstacionamentoDAO(this);

        adapter = new EstacionamentoAdapter(dao.retornarTodos());

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


}
