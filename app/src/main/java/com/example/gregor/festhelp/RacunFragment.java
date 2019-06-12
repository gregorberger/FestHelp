package com.example.gregor.festhelp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;

public class RacunFragment extends Fragment {

    Handler mHandler;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_account, container, false);

        mHandler=new Handler();
        TextView uporabniskoIme = (TextView) v.findViewById(R.id.uporabniskoIme);
        Button odjava = (Button) v.findViewById(R.id.racunOdjava);
        final ParseUser currentUser = ParseUser.getCurrentUser();

        uporabniskoIme.setText(currentUser.getUsername());

        odjava.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      currentUser.logOut();
                      FragmentManager fragmentManager2 = getFragmentManager();
                      FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                      VpisFragment vpisFragment = new VpisFragment();
                      fragmentTransaction2.addToBackStack("xyz");
                      fragmentTransaction2.hide(RacunFragment.this);
                      fragmentTransaction2.replace(R.id.fragment_container, vpisFragment).commit();
                      new AlertDialog.Builder(getContext())
                              .setTitle("Odjava uspešna")
                              .setMessage("Uspešno ste odjavili uporabnika: " + currentUser.getUsername())
                              .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialog, int which) {
                                      dialog.cancel();
                                  }
                              }).show();

                  }
      });


        return v;
    }




}
