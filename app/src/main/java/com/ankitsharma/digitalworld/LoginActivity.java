package com.ankitsharma.digitalworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email,password;
    private Button button;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getWindow ().getDecorView ().setSystemUiVisibility (View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
        setContentView (R.layout.activity_login);




       email = findViewById (R.id.editTextEmail);
       password = findViewById (R.id.editTextPassword);
       button = findViewById (R.id.login_btn);
       mAuth = FirebaseAuth.getInstance ();
       button.setOnClickListener (new View.OnClickListener () {
           @Override
           public void onClick(View view) {
             createUser();
           }
       });

    }

    private void createUser() {
        String Email = email.getText ().toString ();
        String Password = password.getText ().toString ();
        if(!Email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher (Email).matches ()){
            if (!Password.isEmpty ()){
           mAuth.createUserWithEmailAndPassword (Email,Password)
                   .addOnCompleteListener (new OnCompleteListener<AuthResult> () {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           progressDialog = new ProgressDialog (LoginActivity.this);
                           progressDialog.setTitle ("Login to your Account");
                           progressDialog.setMessage ("Please wait while loading");

                           progressDialog.show ();
                           new Handler ().postDelayed (new Runnable () {
                               @Override
                               public void run() {
                                   progressDialog.dismiss ();
                               }
                           },10000);
                           Toast.makeText (LoginActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show ();
                           startActivity (new Intent (LoginActivity.this,MainActivity.class));
                           finish ();
                       }
                   }).addOnFailureListener (new OnFailureListener () {
               @Override
               public void onFailure(@NonNull Exception e) {
                   Toast.makeText (LoginActivity.this, "Error in Registration ", Toast.LENGTH_SHORT).show ();
               }
           });
            }else {
                password.setError ("Empty fields are not allowed");
            }
        }else if(Email.isEmpty ()){
            email.setError ("Empty fields are not allowed");
        }else {
            email.setError ("Please Enter your correct details.");
        }
    }

    public void onLoginClick(View view){
     startActivity (new Intent (this,RegisterActivity.class));
     overridePendingTransition (R.anim.slide_in_right,R.anim.stay);
    }
}