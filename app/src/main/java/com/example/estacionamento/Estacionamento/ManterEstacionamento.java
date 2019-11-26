package com.example.estacionamento.Estacionamento;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.estacionamento.Adapter.EstacionamentoAdapter;
import com.example.estacionamento.R;


public class ManterEstacionamento extends AppCompatActivity {

    EditText nomeFantasia, razaoSocial, cnpj,cep ,logradouro, numero,
    bairro, cidade;

    Button cadastro,voltar;

    TextView cadastroEs, tvErro;

    Spinner estado;

    EstacionamentoAdapter estacionamentoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_estab);

        nomeFantasia = findViewById(R.id.EditText_NomeF);
        razaoSocial = findViewById(R.id.EditText_NomeR);
        cadastro = findViewById(R.id.Button_cadastro);
       voltar = findViewById(R.id.btn_back);
        cadastroEs = findViewById(R.id.textView);
        cnpj = findViewById(R.id.EditText_CNPJ);
        cep = findViewById(R.id.EditText_CEP);
        logradouro = findViewById(R.id.EditText_Lograd);
        numero = findViewById(R.id.EditText_num);
        bairro = findViewById(R.id.EditText_Bairro);
        estado = findViewById(R.id.spinnerEstado);
        cidade = findViewById(R.id.EditText_Cidade);
        tvErro = findViewById(R.id.tvInvisibleError);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.estados, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estado.setAdapter(adapter);




        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (nomeFantasia.getText().toString().length() == 0 ||
                        razaoSocial.getText().toString().length() == 0 ||
                        cnpj.length() == 0 || cep.length() == 0 ||
                        numero.length() == 0 || bairro.length() == 0||  cidade.length() == 0
                || logradouro.length() == 0 ) {

                    nomeFantasia.setError(" Nome Fantasia é Obrigatório");
                    razaoSocial.setError(" Razão Social é Obrigatório");
                    cnpj.setError(" CNPJ  é Obrigatório");
                    cep.setError(" CEP  é Obrigatório");
                    numero.setError(" Número  é Obrigatório");
                    bairro.setError(" Bairro  é Obrigatório");
                    cidade.setError(" Cidade é Obrigatória");
                    logradouro.setError(" Logradouro é Obrigatório");

                    tvErro = (TextView)estado.getSelectedView();
                    tvErro.setError(" Estado é Obrigatório ");



                }

               else{

               AlertDialog alertDialog = new AlertDialog.Builder(ManterEstacionamento.this).create();
               alertDialog.setTitle(" Informações Cadastradas ");
               alertDialog.setMessage("Nome Fantasia: " + nomeFantasia.getText().toString()
                       + "\n" + "Razão Social : " + razaoSocial.getText().toString()
                      + "\n" + "CNPJ : " + cnpj.getText().toString()
                      + "\n" + "CEP : " + cep.getText().toString()
                       + "\n" + "Logradouro + : " + logradouro.getText().toString()
                      +  "\n"+ "Número : " + numero.getText().toString()
                      +  "\n"+ "Bairro : " + bairro.getText().toString()
                      +  "\n"+  "Cidade :" + cidade.getText().toString()
                      +   "\n"+  "Estado : " + estado.getSelectedItem());

                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {

                           String nomeF = nomeFantasia.getText().toString();
                           String razaoS = razaoSocial.getText().toString();
                           String cnpjS = cnpj.getText().toString();
                           String cepS = cep.getText().toString();
                           String logradouros = logradouro.getText().toString();
                           String num = numero.getText().toString();
                           String bairros = bairro.getText().toString();
                           String cidades = cidade.getText().toString();
                           String estados = String.valueOf(estado.getSelectedItemId());


                           EstacionamentoDAO dao = new EstacionamentoDAO(getBaseContext());

                           boolean sucesso = dao.salvar(nomeF,razaoS,cnpjS,cepS,logradouros,num,
                                   bairros,cidades,estados);

                           if(sucesso){


                               Toast.makeText(getApplicationContext(), "Salvo com sucesso!",
                                       Toast.LENGTH_SHORT).show();
                           }else {
                               Toast.makeText(getApplicationContext(), "Erro",
                                       Toast.LENGTH_SHORT).show();
                           }

                       }
                   });
                 alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
                       @Override
                     public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                      }
                   });
               alertDialog.show();

            }

            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

  // private void insertEstacionamento() {

      /*  try{

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

            OkHttpClient client = new OkHttpClient();

            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://teste_conexao/create.php").newBuilder();
            urlBuilder.addQueryParameter("nomeFantasia", nomeFantasia.getText().toString());
            urlBuilder.addQueryParameter("razaoSocial", razaoSocial.getText().toString());
            urlBuilder.addQueryParameter("cnpj", cnpj.getText().toString());
            urlBuilder.addQueryParameter("cep", cep.getText().toString());
            urlBuilder.addQueryParameter("numero", numero.getText().toString());
            urlBuilder.addQueryParameter("bairro", bairro.getText().toString());
            urlBuilder.addQueryParameter("estado", estado.getText().toString());
            urlBuilder.addQueryParameter("cidade", cidade.getText().toString());

            String url = urlBuilder.build().toString();

            Request request = new Request.Builder()
                    .url(url)
                    .build();


            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                nomeFantasia.setText(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });

                }
            });



        } catch (Exception e){
            e.printStackTrace();
        }*/

      /*  ApiInterface apiInterface = APIClient.getApiClient().create(ApiInterface.class);
        Call<Estacionamento> call = apiInterface.insertEstacionamento(nomeFantasia, razaoSocial,
                cnpj, cep,numero, bairro, estado, cidade);

        call.enqueue(new Callback<Estacionamento>() {
            @Override
            public void onResponse(Call<Estacionamento> call, Response<Estacionamento> response) {

                Estacionamento estacionamento = response.body();
            }

            @Override
            public void onFailure(Call<Estacionamento> call, Throwable t) {

                Toast.makeText(ManterEstacionamento.this, t.getMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });*/





    }

