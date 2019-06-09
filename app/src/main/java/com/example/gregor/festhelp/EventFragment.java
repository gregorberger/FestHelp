package com.example.gregor.festhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class EventFragment extends Fragment {

    ImageButton dnevneAktivnosti;
    ImageButton vecerneAktivnosti;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_schedule, container, false);

        dnevneAktivnosti = (ImageButton) v.findViewById(R.id.dnevneAktivnostiButton);
        vecerneAktivnosti = (ImageButton) v.findViewById(R.id.vecerneAktivnostiButton);

        dnevneAktivnosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), DnevniActivity.class);
                startActivity(in);
            }
        });

        vecerneAktivnosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), NocniActivity.class);
                startActivity(in);
            }
        });

        return v;
    }


}
