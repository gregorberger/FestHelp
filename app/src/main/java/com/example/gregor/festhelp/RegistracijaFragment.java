package com.example.gregor.festhelp;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegistracijaFragment extends Fragment {

    EditText et_username;
    EditText et_password;
    EditText et_passwordAgain;
    Button bt_login;
    Button bt_register;
    ProgressDialog progressDialog;

    String user;
    String pwd;
    String pwdAgain;

    Handler mHandler;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_registration, container, false);

        mHandler = new Handler();

        et_username = v.findViewById(R.id.et_username);

        et_password = v.findViewById(R.id.et_password);
        et_passwordAgain = v.findViewById(R.id.et_passwordAgain);

        bt_register = v.findViewById(R.id.bt_register);
        bt_login = v.findViewById(R.id.bt_login);

        progressDialog = new ProgressDialog(getContext());

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Prosim počakajte");
                progressDialog.setTitle("Registriranje");
                progressDialog.show();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            user = (et_username.getText().toString());
                            pwd = (et_password.getText().toString());
                            pwdAgain = (et_passwordAgain.getText().toString());

                            if(pwd.equals(pwdAgain)){
                                progressDialog.dismiss();
                                userRegister(user, pwd);
                            }
                            else if(user.length() <= 5 ){
                                progressDialog.dismiss();
                                new AlertDialog.Builder(getContext())
                                        .setTitle("Registranija ni bila uspešna.")
                                        .setMessage("Uporabniško ime mora imeti vsaj 6 znakov.")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        }).show();

                            }
                            else{
                                progressDialog.dismiss();
                                new AlertDialog.Builder(getContext())
                                        .setTitle("Registranija ni bila uspešna.")
                                        .setMessage("Gesli se morata ujemati.")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        }).show();

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        return v;
    }

    void userRegister(final String username, final String password){
        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    progressDialog.dismiss();
                    alertDisplayer("Registracija usešna", "Uporabniško ime: " + username);
                    FragmentManager fragmentManager2 = getFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    RacunFragment racunFragment = new RacunFragment();
                    fragmentTransaction2.addToBackStack("xyz");
                    fragmentTransaction2.hide(RegistracijaFragment.this);
                    fragmentTransaction2.replace(R.id.fragment_container, racunFragment).commit();
                } else {
                    progressDialog.dismiss();
                    alertDisplayer("Registranija ni bila uspešna.", e.getMessage()+" Prosim probajte ponovno.");
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
