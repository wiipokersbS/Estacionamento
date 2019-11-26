package com.example.estacionamento.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estacionamento.Estacionamento.EstabelecimentosLista;
import com.example.estacionamento.R;

import java.util.List;

public class EstacionamentoAdapter extends RecyclerView.Adapter<EstacionamentoHolder> {

    private final List<EstabelecimentosLista> estabelecimentosListas;

    public EstacionamentoAdapter(List<EstabelecimentosLista> estabelecimentosListas) {
        this.estabelecimentosListas = estabelecimentosListas;
    }


    @NonNull
    @Override
    public EstacionamentoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EstacionamentoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EstacionamentoHolder holder, int position) {

        holder.nomeFantasia.setText(estabelecimentosListas.get(position).getNomeFantasia());

    }


    @Override
    public int getItemCount() {
        return estabelecimentosListas != null ? estabelecimentosListas.size() : 0;
    }

    public void adicionarEstacionamento(EstabelecimentosLista estac){
        estabelecimentosListas.add(estac);
        notifyItemInserted(getItemCount());
    }
}
