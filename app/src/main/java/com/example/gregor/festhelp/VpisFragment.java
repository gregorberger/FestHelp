package com.example.gregor.festhelp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class VpisFragment extends Fragment {


    EditText et_username;
    EditText et_password;
    Button bt_login;
    Button bt_register;
    ProgressDialog progressDialog;

    String user;
    String pwd;

    int layout;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_sign_in, container, false);

        et_username = v.findViewById(R.id.et_username);
        et_password = v.findViewById(R.id.et_password);
        bt_register = v.findViewById(R.id.bt_register);
        bt_login = v.findViewById(R.id.bt_login);

        progressDialog = new ProgressDialog(getContext());

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                RegistracijaFragment registracijaFragment = new RegistracijaFragment();
                fragmentTransaction2.addToBackStack("xyz");
                //fragmentTransaction2.hide(VpisFragment.this);
                fragmentTransaction2.replace(R.id.fragment_container, registracijaFragment).commit();
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Prosim počakajte");
                progressDialog.setTitle("Vpisovanje");
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            user = (et_username.getText().toString());
                            pwd = (et_password.getText().toString());
                            userLogin(user, pwd);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        return v;
    }


    void userLogin(String username, String password) {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {
                    progressDialog.dismiss();
                    alertDisplayer("Vpis uspešen.", "Dobrodošli " + parseUser.getUsername());
                    FragmentManager fragmentManager2 = getFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    RacunFragment racunFragment = new RacunFragment();
                    fragmentTransaction2.addToBackStack("xyz");
                    fragmentTransaction2.hide(VpisFragment.this);
                    fragmentTransaction2.replace(R.id.fragment_container, racunFragment).commit();
                } else {
                    progressDialog.dismiss();
                    alertDisplayer("Vpis neuspešen.", e.getMessage() + " Prosim probajte ponovno.");
                }
            }
        });
    }

    void alertDisplayer(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }


}
