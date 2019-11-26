package com.example.estacionamento.Estacionamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.estacionamento.Login.LoginActivity;
import com.example.estacionamento.R;
import com.example.estacionamento.Responsavel.ResponsavelCadastro;
import com.example.estacionamento.Responsavel.ResponsavelEstacionamento;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class UserPerfilActivity extends AppCompatActivity {


    Button logout, btCreateDB,btViewDB, btCadastrarHorario, btCadastrarPreco, btExibirEstacionamento;

    TextView userEmailShow ;

    FirebaseAuth firebaseAuth ;

    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        logout = findViewById(R.id.logout);
        userEmailShow = findViewById(R.id.user_email);

      btCreateDB = findViewById(R.id.bt_createdata);
        btViewDB = findViewById(R.id.bt_viewDB);
        btCadastrarHorario = findViewById(R.id.bt_cadastrarHorario);
        btCadastrarPreco = findViewById(R.id.bt_cadastrarPreco);
        btExibirEstacionamento =  findViewById(R.id.btn_exibirEstacionamento);


        firebaseAuth = FirebaseAuth.getInstance();


        if(firebaseAuth.getCurrentUser() == null){

            finish();


            Intent intent = new Intent(UserPerfilActivity.this, LoginActivity.class);
            startActivity(intent);


            Toast.makeText(UserPerfilActivity.this, "Por favor, faça o Login para continuar", Toast.LENGTH_LONG).show();

        }

        firebaseUser = firebaseAuth.getCurrentUser();

        ResponsavelEstacionamento responsavelEstacionamento = new ResponsavelEstacionamento();
        ResponsavelCadastro responsavelCadastro = new ResponsavelCadastro();
        Intent in = getIntent();

      userEmailShow.setText("Bem-vindo " +
                " "+ "\n" + firebaseUser.getEmail());





        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseAuth.signOut();

                finish();


                Intent intent = new Intent(UserPerfilActivity.this, LoginActivity.class);
                startActivity(intent);

                Toast.makeText(UserPerfilActivity.this, "Logout realizado com sucesso.", Toast.LENGTH_LONG).show();

            }
        });


        //btCreateDB.setOnClickListener(new View.OnClickListener() {
          //  @Override
          //  public void onClick(View view) {



            //}
       // });
        btViewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserPerfilActivity.this, ManterEstacionamento.class);
                startActivity(intent);




            }
        });


        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(UserPerfilActivity.this, ResponsavelCadastro.class);
                startActivity(intent);
            }
        });

        btCadastrarHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserPerfilActivity.this, TabelaHorarioCadastro.class);
                startActivity(intent);




            }
        });

        btCadastrarPreco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserPerfilActivity.this, TabelaPrecoCadastro.class);
                startActivity(intent);
            }
        });

        btExibirEstacionamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserPerfilActivity.this, ListarEstacionamento.class);
                startActivity(intent);
            }
        });


    }
}