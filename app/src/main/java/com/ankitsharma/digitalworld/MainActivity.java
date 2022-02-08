package com.ankitsharma.digitalworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button button1,button2, button3, button4, button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        getSupportActionBar ().hide ();
        button1 = findViewById (R.id.call_btn);
        button2 = findViewById (R.id.call_web_btn);
        button3 = findViewById (R.id.call_digital_btn);
        button4 = findViewById (R.id.call_hacking_btn);
        button5 = findViewById (R.id.call_security_btn);
        button1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Intent.ACTION_DIAL);
                i.setData (Uri.parse ("tel:09891628296"));
                startActivity (i);
            }
        });
        button2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Intent.ACTION_DIAL);
                i.setData (Uri.parse ("tel:09891628296"));
                startActivity (i);
            }
        });
        button3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Intent.ACTION_DIAL);
                i.setData (Uri.parse ("tel:09891628296"));
                startActivity (i);
            }
        });
        button4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Intent.ACTION_DIAL);
                i.setData (Uri.parse ("tel:09891628296"));
                startActivity (i);
            }
        });
        button5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Intent.ACTION_DIAL);
                i.setData (Uri.parse ("tel:09891628296"));
                startActivity (i);
            }
        });
    }
}