package com.example.estacionamento.Login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estacionamento.R;
import com.example.estacionamento.mapa.MapsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class MainActivity extends AppCompatActivity {

    EditText email, password ;

    Button SignUp;
    TextView ButtonGoToLoginActivity, ButtonGoToMapsActivity;

    String EmailHolder, PasswordHolder ;


    ProgressDialog progressDialog;


    FirebaseAuth firebaseAuth ;


    Boolean EditTextStatus ;

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.EditText_User_EmailID);
        password = findViewById(R.id.EditText_User_Password);

        SignUp = findViewById(R.id.Button_SignUp);
        ButtonGoToLoginActivity = findViewById(R.id.Button_LoginActivity);
        ButtonGoToLoginActivity = findViewById(R.id.Button_LoginActivity);
        ButtonGoToMapsActivity = findViewById(R.id.Button_Mapa);




        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(MainActivity.this);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CheckEditTextIsEmptyOrNot();


                if(EditTextStatus){


                    UserRegistrationFunction();

                }

                else {

                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_LONG).show();

                }

            }
        });


        ButtonGoToLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();


                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        ButtonGoToMapsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });


    }


    public void UserRegistrationFunction(){


        progressDialog.setMessage("Carregando ...");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(EmailHolder, PasswordHolder).
                addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {


                        if(task.isSuccessful()){


                            Toast.makeText(MainActivity.this,"Usuário registrado com sucesso!",Toast.LENGTH_LONG).show();

                            firebaseAuth.signOut();

                        }else{


                            Toast.makeText(MainActivity.this,"Algo errado aconteceu.",Toast.LENGTH_LONG).show();
                        }


                        progressDialog.dismiss();

                    }
                });

    }

    public void CheckEditTextIsEmptyOrNot(){


        EmailHolder = email.getText().toString().trim();
        PasswordHolder = password.getText().toString().trim();

        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {

            EditTextStatus = false;

        }
        else {

            EditTextStatus = true ;
        }

    }




}