package com.example.estacionamento.Estacionamento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.estacionamento.Array.Estacionamento;
import com.example.estacionamento.Sqlite.DbGateway;

import java.util.ArrayList;
import java.util.List;

public class EstacionamentoDAO {

    private final String TABLE_ESTACIONAMENTO = "Estacionamento";

    private DbGateway gw;

    public EstacionamentoDAO(Context context) {

        gw = DbGateway.getInstance(context);
    }

    public boolean salvar(String nomeFantasia, String razaoSocial, String cnpj, String cep, String logradouro, String numero, String bairro, String cidade, String estado){

        ContentValues contentValues = new ContentValues();

        contentValues.put("nomeFantasia", nomeFantasia);
        contentValues.put("razaoSocial", razaoSocial);
        contentValues.put("cnpj", cnpj);
        contentValues.put("cep", cep);
        contentValues.put("logradouro", logradouro);
        contentValues.put("numero", numero);
        contentValues.put("bairro", bairro);
        contentValues.put("cidade", cidade);
        contentValues.put("estado", estado);

        return gw.getDatabase().insert(TABLE_ESTACIONAMENTO, null, contentValues) > 0;
    }

    public List<EstabelecimentosLista> retornarTodos(){

        List<EstabelecimentosLista> lstEstacionamento = new ArrayList<>();

        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Estacionamento", null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nomeF = cursor.getString(cursor.getColumnIndex("nomeFantasia"));
            String razaoF = cursor.getString(cursor.getColumnIndex("razaoSocial"));
            String cnpjs = cursor.getString(cursor.getColumnIndex("cnpj"));
            String ceps = cursor.getString(cursor.getColumnIndex("cep"));
            String logradouros = cursor.getString(cursor.getColumnIndex("logradouro"));
            String nums = cursor.getString(cursor.getColumnIndex("numeor"));
            String bairros = cursor.getString(cursor.getColumnIndex("bairro"));
            String cidades = cursor.getString(cursor.getColumnIndex("cidade"));
            String estados = cursor.getString(cursor.getColumnIndex("estado"));
        }

        cursor.close();
        return lstEstacionamento;

    }

    public EstabelecimentosLista retornarUltimo(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Estacionamento ORDER BY ID DESC", null);

        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nomeF = cursor.getString(cursor.getColumnIndex("nomeFantasia"));
            String razaoF = cursor.getString(cursor.getColumnIndex("razaoSocial"));
            String cnpjs = cursor.getString(cursor.getColumnIndex("cnpj"));
            String ceps = cursor.getString(cursor.getColumnIndex("cep"));
            String logradouros = cursor.getString(cursor.getColumnIndex("logradouro"));
            String nums = cursor.getString(cursor.getColumnIndex("numero"));
            String bairros = cursor.getString(cursor.getColumnIndex("bairro"));
            String cidades = cursor.getString(cursor.getColumnIndex("cidade"));
            String estados = cursor.getString(cursor.getColumnIndex("estado"));

            cursor.close();

            return new EstabelecimentosLista(id, nomeF, razaoF, cnpjs,ceps, logradouros, nums,bairros,
                    cidades, estados);
        }

        return null;

    }
}
