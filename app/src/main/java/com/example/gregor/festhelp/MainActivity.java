package com.example.gregor.festhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);


//        ((Button) findViewById(R.id.kontakt)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(R.layout.activity_support);
//
//
//                String to = "festhelpsupport@gmail.com";
//                String sub = ((EditText)findViewById(R.id.kontaktEmailNaslov)).getText().toString();
//                String mess = ((EditText)findViewById(R.id.kontaktSporocilo)).getText().toString();
//                Intent mail = new Intent(Intent.ACTION_SEND);
//                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
//                mail.putExtra(Intent.EXTRA_SUBJECT, sub);
//                mail.putExtra(Intent.EXTRA_TEXT, mess);
//                mail.setType("message/rfc822");
//                startActivity(Intent.createChooser(mail, "Send email via:"));
//
//
//
//            }
//        });



    }

//    @Override
//    public void onBackPressed() {
//        setContentView(R.layout.activity_main);
//
//
//        ((Button) findViewById(R.id.kontakt)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(R.layout.activity_support);
//
//                String to = "festhelpsupport@gmail.com";
//                String sub = ((EditText)findViewById(R.id.kontaktEmailNaslov)).getText().toString();
//                String mess = ((EditText)findViewById(R.id.kontaktSporocilo)).getText().toString();
//                Intent mail = new Intent(Intent.ACTION_SEND);
//                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
//                mail.putExtra(Intent.EXTRA_SUBJECT, sub);
//                mail.putExtra(Intent.EXTRA_TEXT, mess);
//                mail.setType("message/rfc822");
//                startActivity(Intent.createChooser(mail, "Send email via:"));
//
//
//
//            }
//        });


//    }


}
