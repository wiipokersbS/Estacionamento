package com.example.estacionamento.Adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.estacionamento.R;

public class EstacionamentoHolder extends RecyclerView.ViewHolder {

    public TextView nomeFantasia;
    public ImageButton btnEditar;
    public ImageButton btnExcluir;

    public EstacionamentoHolder(View itemView) {
        super(itemView);

        nomeFantasia = itemView.findViewById(R.id.nomeFantasia);
        btnEditar = (ImageButton) itemView.findViewById(R.id.btnEdit);
        btnExcluir = (ImageButton) itemView.findViewById(R.id.btnDelete);

    }
}
