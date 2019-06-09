package com.example.gregor.festhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SupportFragment extends Fragment {
    private EditText emailNaslov;
    private EditText sporocilo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_support, container, false);
        emailNaslov = v.findViewById(R.id.kontaktEmailNaslov);
        sporocilo = v.findViewById(R.id.kontaktSporocilo);
        (v.findViewById(R.id.kontaktPoslji)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String to =  "festhelpsupport@gmail.com";
                String sub = emailNaslov.getText().toString();
                String mess = sporocilo.getText().toString();
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                mail.putExtra(Intent.EXTRA_SUBJECT, sub);
                mail.putExtra(Intent.EXTRA_TEXT, mess);
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail, "Pošlji mail preko:"));
            }
        });
        return v;
    }
}
