package com.ankitsharma.digitalworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private EditText name, email, password;
    private Button button;
    private ProgressDialog progressDialog;
    private FirebaseDatabase db = FirebaseDatabase.getInstance ();
    private DatabaseReference root =db.getReference ().child ("Users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_register);
        getSupportActionBar ().hide ();

        changeStatusBarColor();
        name = findViewById (R.id.EditTextName);
        email = findViewById (R.id.editTextEmail);
        password = findViewById (R.id.editTextPassword);
        button = findViewById (R.id.circularRegisterButton);

        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog (RegisterActivity.this);
                progressDialog.setTitle ("We are Creating your Account");
                progressDialog.setMessage ("Please wait while loading");

                progressDialog.show ();
                new Handler ().postDelayed (new Runnable () {
                    @Override
                    public void run() {
                        progressDialog.dismiss ();
                    }
                },10000);

                String Name = name.getText ().toString ();
                String Email = email.getText ().toString ();
                String Password = password.getText ().toString ();

                HashMap<String , String> userMap = new HashMap<> ();
                userMap.put ("Name",Name);
                userMap.put ("Email",Email);
                userMap.put ("Password",Password);

                root.push ().setValue (userMap);
                Toast.makeText (RegisterActivity.this, "Welcome "+Name+" to our digital services app", Toast.LENGTH_SHORT).show ();
                Intent intent = new Intent (RegisterActivity.this,MainActivity.class);
                startActivity (intent);
            }
        });

    }

    private void changeStatusBarColor() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = getWindow ();
            window.addFlags (WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor (getResources ().getColor (R.color.register_bk_color));

        }
    }
    public void onLoginClick(View view){
        startActivity (new Intent (this,LoginActivity.class));
        overridePendingTransition (R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
}